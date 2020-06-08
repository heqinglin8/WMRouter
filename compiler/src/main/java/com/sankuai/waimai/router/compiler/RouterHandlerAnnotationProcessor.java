package com.sankuai.waimai.router.compiler;

import com.google.auto.service.AutoService;
import com.sankuai.waimai.router.annotation.RouterPage;
import com.sankuai.waimai.router.annotation.RouterRegex;
import com.sankuai.waimai.router.annotation.RouterUri;
import com.sankuai.waimai.router.interfaces.Const;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.sun.tools.javac.code.Symbol;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class RouterHandlerAnnotationProcessor extends BaseProcessor {

    public static final String ROUTER_HANDLER_CLASS_NAME = "RouterHandler";
    public static final String URL_MODE_CLASS_NAME = "UriMode";
    public static final String ROUTER_HANDLER_CLASS = Const.GEN_PKG+".RouterHandler";
    public static final String SCHEME = "wm_router";
    public static final String HOST = "page";
    public static final String PAGE_SCHEME_HOST = SCHEME + "://" + HOST;

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        if (annotations == null || annotations.isEmpty()) {
            return false;
        }
        // list泛型的类型
        ClassName type = ClassName.get(ROUTER_HANDLER_CLASS, URL_MODE_CLASS_NAME);

        CodeBlock.Builder builder = CodeBlock.builder();
        builder.add(initCodeBlock(env, RouterUri.class,type).build());
        builder.add(initCodeBlock(env, RouterPage.class,type).build());
        builder.add(initCodeBlock(env, RouterRegex.class,type).build());
        buildHandlerClass(builder.build(), ROUTER_HANDLER_CLASS_NAME,type);
        return true;
    }

    private<T extends Annotation> CodeBlock.Builder initCodeBlock(RoundEnvironment env, Class<T> routerUriClass, ClassName type) {
        CodeBlock.Builder builder = CodeBlock.builder();
        for (Element element : env.getElementsAnnotatedWith(routerUriClass)) {
            if (!(element instanceof Symbol.ClassSymbol)) {
                continue;
            }
            System.out.println("hql initCodeBlock:"+routerUriClass);
            boolean isActivity = isActivity(element);
            boolean isHandler = isHandler(element);

            if (!isActivity && !isHandler) {
                continue;
            }
            System.out.println("hql initCodeBlock 111");
            Symbol.ClassSymbol cls = (Symbol.ClassSymbol) element;
            T uri = cls.getAnnotation(routerUriClass);
            if (uri == null) {
                continue;
            }
            System.out.println("hql initCodeBlock 222");
            // scheme, host, path, handler, exported, interceptors
            //"demo://demo/account"
            if(uri instanceof RouterUri){
                RouterUri routerUri = (RouterUri) uri;
                String[] pathList = routerUri.path();
                for (String path : pathList) {
                    String url = path;
                    if(!"".equals(routerUri.host())){
                        url = routerUri.host() + url;
                    }
                    if(!"".equals(routerUri.scheme())){
                        if("".equals(routerUri.host())){  //path有一个/
                            url = routerUri.scheme()+":/" + url;
                        }else{
                            url = routerUri.scheme()+"://" + url;
                        }
                    }
                    builder.addStatement("mUrlModes.add(new $T($S,$S,$S))",type, cls.getSimpleName(), url,routerUri.remark());
                }
            }else if(uri instanceof RouterPage){
                RouterPage routerPage = (RouterPage) uri;
                System.out.println("hql initCodeBlock 333 ");
                String[] pathList = routerPage.path();
                for (String path : pathList) {
                   String url = PAGE_SCHEME_HOST + path;
                    System.out.println("hql initCodeBlock 444 urlP:"+url);
                    builder.addStatement("mUrlModes.add(new $T($S,$S,$S))",type, cls.getSimpleName(), url,routerPage.remark());
                }
            }else if(uri instanceof RouterRegex){
                RouterRegex routerRegex = (RouterRegex) uri;
                builder.addStatement("mUrlModes.add(new $T($S,$S,$S))",type, cls.getSimpleName(), routerRegex.regex(),routerRegex.remark());
            }

        }

        return builder;
    }

    public void buildHandlerClass(CodeBlock code, String genClassName, ClassName type) {

        // List类型
        ClassName list = ClassName.get("java.util", "List");
        // ArrayList类型
        ClassName arrayList = ClassName.get("java.util", "ArrayList");
        ClassName instance = ClassName.get(Const.GEN_PKG, ROUTER_HANDLER_CLASS_NAME);
        // 生成泛型类型，类型的名称、参数的名称
        TypeName listType = ParameterizedTypeName.get(list, type);
        TypeName arrayListType = ParameterizedTypeName.get(arrayList, type);

        MethodSpec methodSpec = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PRIVATE)
                .addCode(code)
                .build();

        FieldSpec routerModesFieldSpec = FieldSpec.builder(listType, "mUrlModes", Modifier.PUBLIC).initializer("new $T()", arrayListType).build();
        FieldSpec instanceFieldSpec = FieldSpec.builder(instance, "instance", Modifier.PUBLIC).addModifiers(Modifier.STATIC)
                .initializer("new "+ROUTER_HANDLER_CLASS_NAME+"()").build();
        TypeSpec typeSpec = TypeSpec.classBuilder(genClassName)
                .addModifiers(Modifier.PUBLIC)
                .addMethod(methodSpec)
                .addField(routerModesFieldSpec)
                .addField(instanceFieldSpec)
                .addType(buildRouterModeTypeSpec())
                .build();
        try {
            JavaFile.builder(Const.GEN_PKG, typeSpec)
                    .build()
                    .writeTo(filer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private TypeSpec buildRouterModeTypeSpec() {
        TypeSpec inTypeSpec = TypeSpec.classBuilder(URL_MODE_CLASS_NAME)
                .addModifiers(Modifier.PUBLIC)
                .addField(String.class,"url",Modifier.PRIVATE)
                .addField(String.class,"name",Modifier.PRIVATE)
                .addField(String.class,"remark",Modifier.PRIVATE)
                .addMethod(MethodSpec.constructorBuilder()
                        .addParameter(String.class,"name")
                        .addParameter(String.class,"url")
                        .addParameter(String.class,"remark")
                        .addStatement("this.name = name")
                        .addStatement("this.url = url")
                        .addStatement("this.remark = remark")
                        .build())
                .build();
        return inTypeSpec;
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        LinkedHashSet<String> annotations = new LinkedHashSet<>();
        annotations.add(RouterPage.class.getName());
        annotations.add(RouterUri.class.getName());
        annotations.add(RouterRegex.class.getName());
        System.out.println("hql annotations="+annotations.toString());
        return annotations;
    }
}

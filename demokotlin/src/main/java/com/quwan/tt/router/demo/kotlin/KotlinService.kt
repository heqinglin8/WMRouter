package com.quwan.tt.router.demo.kotlin

import com.quwan.tt.router.annotation.RouterService
import com.tt.lib.app.DemoConstant

@RouterService(interfaces = [Object::class], key = [DemoConstant.KOTLIN_SERVICE])
class KotlinService {

}
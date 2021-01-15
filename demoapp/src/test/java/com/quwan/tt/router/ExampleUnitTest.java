package com.quwan.tt.router;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class ExampleUnitTest {
    static {
        System.out.println("静态代码块");
    }
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void main() {
        Person person = new Person();
        ExampleUnitTest test;
    }

    class  Person{
         {
            System.out.println("非静态代码块");
        }

        Person (){
            System.out.println("构造方法");
        }
    }

}
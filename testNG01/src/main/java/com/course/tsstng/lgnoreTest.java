package com.course.tsstng;

import org.testng.annotations.Test;

//忽略测试
public class lgnoreTest {
    @Test
    public void ignoreTest1(){
        System.out.println("需要执行ignoreTest1");
    }
    @Test(enabled = false)
    public void ignoreTest2(){
        System.out.println("不想执行ignoreTest2");
    }
    @Test(enabled = true)
    public void ignoreTest3(){
        System.out.println("需要执行ignoreTest3");
    }

}

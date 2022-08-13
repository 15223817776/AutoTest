package com.course.tsstng;


import org.testng.annotations.*;

public class BasicAnnotation {
    @Test
    public void test1(){
        System.out.println("这是测试用例1");
    }
    @Test
    public void test2(){
        System.out.println("这是测试用例2");
    }


    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod是在测试方法之前运行");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod是在测试方法之后运行");
    }

    @BeforeClass
    public void BeforeClass(){
        System.out.println("BeforeClass是在类运行之前运行");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass是在类运行之后运行");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite套件");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite套件");
    }


}

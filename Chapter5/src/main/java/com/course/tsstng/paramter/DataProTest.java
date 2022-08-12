package com.course.tsstng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProTest {

    @Test(dataProvider = "data")
    public void testData(String name, int age) {
        System.out.println("name=" + name + ",age=" + age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData() {
        Object[][] o = new Object[][]{
                {"zhangsan", 10},
                {"lisi", 20}
        };
        return o;
    }

    @Test( dataProvider= "methoondData")
    public void test1(String name, int age){
        System.out.println("test1：name=" + name + ",age=" + age);
    }
    @Test( dataProvider= "methoondData")
    public void test2(String name, int age){
        System.out.println("test2：name=" + name + ",age=" + age);
    }

    @DataProvider(name = "methoondData")
    public Object[][] methodDataTest(Method method) {
        Object[][] result=null;
        if(method.getName().equals("test1")){
            result =new Object[][]{
                {"zhangsan", 20},
                {"lisi", 30}
            };
        }else if(method.getName().equals("test2")){
            result =new Object[][]{
                    {"xxx", 20},
                    {"mmm", 30}
            };
        }
        return result;
    }
}

package com.course.tsstng.group;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

// 组测试
public class GroupTest {
    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端组的测试方法111");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端组的测试方法222");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端组的测试方法333");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("这是客户端组的测试方法444");
    }


}

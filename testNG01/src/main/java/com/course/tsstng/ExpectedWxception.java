package com.course.tsstng;

import org.testng.annotations.Test;

public class ExpectedWxception {
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeFailed(){
        System.out.println("这是一个失败的异常测试");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeSuccess(){
        System.out.println("这是我的异常测试");
        throw new RuntimeException();
    }
}

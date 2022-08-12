package com.course.tsstng;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 3000)
    public void testTimeOutSuccess() throws Exception{
        Thread.sleep(2000);
    }

    @Test(timeOut = 3000)
    public void testTimeOutFailed() throws Exception{
        Thread.sleep(4000);
    }
}

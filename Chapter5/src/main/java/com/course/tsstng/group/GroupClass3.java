package com.course.tsstng.group;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupClass3 {
    public void teacher1() {
        System.out.println("GroupClass3中的teacher1运行");
    }
    public void teacher2() {
        System.out.println("GroupClass3中的teacher2运行");
    }
}

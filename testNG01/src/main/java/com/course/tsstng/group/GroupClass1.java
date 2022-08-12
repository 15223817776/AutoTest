package com.course.tsstng.group;

import org.testng.annotations.Test;

// 类分组测试
@Test(groups = "student")
public class GroupClass1 {

    public void student1() {
        System.out.println("GroupClass1中的student1运行");
    }
}

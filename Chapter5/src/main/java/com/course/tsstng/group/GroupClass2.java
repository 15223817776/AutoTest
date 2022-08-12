package com.course.tsstng.group;

import org.testng.annotations.Test;

@Test(groups = "student")
public class GroupClass2 {
    public void student1() {
        System.out.println("GroupClass2中的student1运行");
    }
    public void student2() {
        System.out.println("GroupClass2中的student2运行");
    }
}

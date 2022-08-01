package com.jiangnanyidianyu.BaseDemo.集合类;

import java.util.Comparator;

/**
 * @ClassName MyComparator
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2020/10/19 16:15
 */
public class MyComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1,Student s2) {
        // 姓名长度
        int num = s1.getName().length() - s2.getName().length();
        // 姓名内容
        int num2 = num == 0 ? s1.getName().compareTo(s2.getName()) : num;
        // 年龄
        int num3 = num2 == 0 ? s1.getAge() - s2.getAge() : num2;
        return num3;
    }
}

package com.jiangnanyidianyu.BaseDemo.深拷贝和浅拷贝.深拷贝;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Student
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/28 14:16
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student implements Cloneable{
    private Subject subj;
    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Student(subj,name);
    }
}


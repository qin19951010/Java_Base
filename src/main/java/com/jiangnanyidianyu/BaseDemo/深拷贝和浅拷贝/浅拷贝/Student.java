package com.jiangnanyidianyu.BaseDemo.深拷贝和浅拷贝.浅拷贝;

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

    public Student(String s,String sub){
        name = s;
        subj = new Subject(sub);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


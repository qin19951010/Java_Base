package com.jiangnanyidianyu.BaseDemo.深拷贝和浅拷贝.深拷贝;

/**
 * @ClassName Test
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/28 15:17
 */
public class Test {

    @org.junit.Test
    public void Test01() throws CloneNotSupportedException {
        Student student = new Student(new Subject("Mysql"),"Qinnn");
        Student cloneStu = (Student) student.clone();

        System.out.println("原对象和克隆对象是否相等:" + (student == cloneStu));
        System.out.println("原对象的引用类型属性是否和克隆对象的引用类型属性相等:" + (student.getSubj() == cloneStu.getSubj()));

        student.setSubj(new Subject("Mysql_New"));
        System.out.println("原对象的引用类型属性:" + student.getSubj().getName());
        System.out.println("克隆对象的引用类型属性:" + cloneStu.getSubj().getName());

    }
}

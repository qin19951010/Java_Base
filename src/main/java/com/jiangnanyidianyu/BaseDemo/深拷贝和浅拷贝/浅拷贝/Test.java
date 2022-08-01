package com.jiangnanyidianyu.BaseDemo.深拷贝和浅拷贝.浅拷贝;

/**
 * @ClassName Test
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/28 14:18
 */
/*
*
*   通过实现Cloneable接口重写clone方法的方式称为浅拷贝
*
*   浅拷贝会创建一个新对象,拷贝的新对象中基本数据类型的属性是相等的
*   引用数据类型的属性原对象和拷贝对象都指向相同的地址,对原对象中的引用对象修改时会影响到拷贝对象
*
**/
public class Test {

    @org.junit.Test
    public void test01() throws CloneNotSupportedException {
        //原始对象
        Student stud = new Student("杨充","潇湘剑雨");
        System.out.println("原始对象: " + stud.getName() + " - " + stud.getSubj().getName());

        //拷贝对象
        Student clonedStud = (Student) stud.clone();
        System.out.println("拷贝对象: " + clonedStud.getName() + " - " + clonedStud.getSubj().getName());

        //原始对象和拷贝对象是否一样:
        System.out.println("原始对象和拷贝对象是否一样: " + (stud == clonedStud));
        //原始对象和拷贝对象的name属性是否一样
        System.out.println("原始对象和拷贝对象的name属性是否一样: " + (stud.getName() == clonedStud.getName()));
        //原始对象和拷贝对象的subj属性是否一样
        System.out.println("原始对象和拷贝对象的subj属性是否一样: " + (stud.getSubj() == clonedStud.getSubj()));

        stud.setName("Qinnn");
        stud.getSubj().setName("Qinnnnnnnn");
        System.out.println("更新后的原始对象:" + stud.getName() + " - " + stud.getSubj().getName());
        System.out.println("更新原始对象后的克隆对象: " + clonedStud.getName() + " - " + clonedStud.getSubj().getName());
    }

    @org.junit.Test
    public void test02() throws CloneNotSupportedException {
        Student student = new Student(new Subject("JAVA"),"Qinnnn");
        Student clone1 = (Student) student.clone();

        System.out.println("判断原对象和克隆对象的是否相等:" + (student == clone1));
        System.out.println("判断原对象和克隆对象的Subject属性是否相等:" + (student.getSubj()==clone1.getSubj()));
    }
}

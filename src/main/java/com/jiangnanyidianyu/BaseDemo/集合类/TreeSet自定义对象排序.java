package com.jiangnanyidianyu.BaseDemo.集合类;

import java.util.TreeSet;

/**
 * @ClassName TreeSet自定义对象排序
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2020/10/19 15:56
 */
public class TreeSet自定义对象排序 {

    public static void main(String[] args) {

        //TreeSet<Student> ts=new TreeSet<Student>();

        //创建集合对象
        //TreeSet(Comparator<? super E> comparator) 构造一个新的空 TreeSet，它根据指定比较器进行排序。
        TreeSet<Student> ts=new TreeSet<Student>(new MyComparator());

        //创建元素对象
        Student s1=new Student("zhangsan",20);
        Student s2=new Student("lis",22);
        Student s3=new Student("wangwu",24);
        Student s4=new Student("chenliu",26);
        Student s5=new Student("zhangsan",22);
        Student s6=new Student("qianqi",24);

        //将元素对象添加到集合对象中
        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);

        //遍历
        for(Student s:ts){
            System.out.println(s.getName()+"-----------"+s.getAge());
        }
    }

}

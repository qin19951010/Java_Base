package com.jiangnanyidianyu.BaseDemo.集合类bj.List;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ArrayListTest
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/2/22 14:39
 */
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        //添加元素
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        list.add("DDD");
        list.add("EEE");
        System.out.println("list的大小为:"+list.size());
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println(list.get(3));
//        System.out.println(list.get(4));
        //迭代器遍历
        for (String s:list) {
            System.out.println(s);
        }
        //更新元素
//        list.set(0,"AAA1");
//        list.set(1,"BBB1");
//        list.set(2,"CCC1");
//        list.set(3,"DDD1");
//        list.set(4,"EEE1");
//        System.out.println(list);
        //判断容器是否为空
        System.out.println("list容器是否为空:"+ list.isEmpty());
        System.out.println("list容器是否包含AAA:"+ list.contains("AA"));
        System.out.println("list容器中第一次出现AAA的索引:"+ list.indexOf("AAA"));
        System.out.println("list容器中最后一次出现AAA的索引:"+ list.lastIndexOf("AAA"));
        //元素不存在返回-1
        //不可将object数组直接转为String类型的数组,可以单个转换不可整体转换。
        //单例集合转换为Object数组
        Object[] array = list.toArray();
        for (int n = 0;n < array.length;n++)
        {
            String str = (String)array[n];
            System.out.println(str);
        }
        //单例集合转换为泛型类型数组
        String[] array1 = list.toArray(new String[list.size()]);
        for (int n = 0;n < array1.length;n++)
        {
            String str = array1[n];
            System.out.println(str);
        }
        //容器的并集操作
        List arr1 = new ArrayList<String>();
        List arr2 = new ArrayList<String>();
        arr1.add("a");
        arr1.add("b");
        arr1.add("c");

        arr2.add("d");
        arr2.add("e");
        arr2.add("f");
        //容器的并集操作1
        boolean b = arr1.addAll(arr2);
        System.out.println(arr1);
        //容器交集操作
        System.out.println("=========交集操作=========");
    }
}

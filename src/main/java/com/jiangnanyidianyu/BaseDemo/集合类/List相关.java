package com.jiangnanyidianyu.BaseDemo.集合类;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName List相关
 * @Author: Qinnn、
 * @Description: TODO List集合相关
 * @Date: create in 2020/10/19 14:22
 */
public class List相关 {

    public static void main(String[] args) {

        String [] myAarray = {"Java","C#","Redis","Js"};

        /**  ==>坑
        *   Arrays的内部类ArrayList和java.util.ArrayList都是继承AbstractList，remove、add等方法
         *  AbstractList中是默认throw UnsupportedOperationException而且不作任何操作
        */

        /** 返回的是Arrays的内部类,没有实现ListIterator接口 */
        List<String> list = Arrays.asList(myAarray);
        //System.out.println(list.get(0));

        ArrayList<String> list1 = new ArrayList<>(list);

        System.out.println("移除前的结果:");
        for (String s: list1) {
            System.out.println(s);
        }

        System.out.println("移除后的结果:");
        list1.remove(0);
        for (String s: list1) {
            System.out.println(s);
        }
    }

}

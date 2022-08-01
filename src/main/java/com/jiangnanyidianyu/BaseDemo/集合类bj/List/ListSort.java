package com.jiangnanyidianyu.BaseDemo.集合类bj.List;

import java.util.*;

/**
 * @ClassName ListSort
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/2/23 10:55
 */
public class ListSort {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(1);
        list.add(-8);
        list.add(-5);
        list.add(10);
        list.add(5);
        list.add(6);

        //原始数组
        System.out.println("排序前:");
        System.out.println(list);

        //反转
        Collections.reverse(list);
        System.out.println("Collections.reverse(list):");
        System.out.println(list);

        //按自然排序的升序排序
        Collections.sort(list);
        System.out.println("Collections.sort(list)");
        System.out.println(list);

        //定制排序
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println("Person定制排序后:");
        System.out.println(list);
    }
}

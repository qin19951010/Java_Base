package com.jiangnanyidianyu.BaseDemo.集合类;

import java.util.TreeSet;

/**
 * @ClassName TreeSet基本数据类型排序
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2020/10/19 15:53
 */
public class TreeSet基本数据类型排序 {

    public static void main(String[] args) {
        // 创建集合对象
        // 自然顺序进行排序
        TreeSet<Integer> ts = new TreeSet<Integer>();

        // 创建元素并添加
        // 20,18,23,22,17,24,19,18,24
        ts.add(20);
        ts.add(18);
        ts.add(23);
        ts.add(22);
        ts.add(17);
        ts.add(24);
        ts.add(19);
        ts.add(18);
        ts.add(24);

        // 遍历
        for (Integer i : ts) {
            System.out.println(i);
        }
    }

}

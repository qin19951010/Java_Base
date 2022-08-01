package com.jiangnanyidianyu.BaseDemo.集合类.guigu;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/6/30 10:07
 **/
/*
*   foreach 增强for循环
*   用于遍历集合和数组
*
* */
public class Foreach {
    @Test
    public void testForeach(){
        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");

        //内部仍然调用迭代器
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void testForeach2(){
        int[] ints = {1, 2, 3, 4, 5, 6};
        for (int i : ints) {
            System.out.println(i);
        }
    }

    @Test
    public void testForeach3(){

        //方式1,普通for赋值
        String[] arr = {"111", "111", "111"};
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = "GG";
//        }

//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

        //方式二:增强for循环
        //相当于吧arr[i]的元素内容赋值给s
        for (String s : arr) {
            s ="GG";
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

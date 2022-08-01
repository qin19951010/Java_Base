package com.jiangnanyidianyu.BaseDemo.集合类.guigu;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/6/30 9:40
 **/
/*
*   集合元素的遍历操作,使用迭代器Iterator接口
*   迭代器:提供一种方法访问一个容器(container)对象中各个元素,而又不需暴露该对象的内部细节.
*   迭代器模式,这就是为容器而生
*
*   list.iterator()每次都会生成新的迭代器
*
*   3.内部定义了remove,可以在遍历的时候,删除集合中的元素
*   此方法不同于集合直接调用remove()
* */
public class Iterator {
    @Test
    public void test(){
        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");

        java.util.Iterator<String> iterator = list.iterator();
        //方式一
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//
//        //报异常:NoSuchElementException
//        System.out.println(iterator.next());

        System.out.println("====================");
        
        //方式二:
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(iterator.next());
//        }

        //方式三: 推荐
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testReomve(){
        ArrayList<Object> list = new ArrayList<>();
        list.add("111");
        list.add("111");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");

        java.util.Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            if("111".equals(next)){
                iterator.remove();
            }
        }

        java.util.Iterator<Object> iterator2 = list.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }
    }
}



package com.jiangnanyidianyu.BaseDemo.集合类bj.Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName HashMapTraverse
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/2/23 14:13
 */
public class HashMapTraverse {
    /*
    * HashMap遍历方式:
        1.使用迭代器（Iterator）EntrySet 的方式进行遍历；
        2.使用迭代器（Iterator）KeySet 的方式进行遍历；
        3.使用 For Each EntrySet 的方式进行遍历；
        4.使用 For Each KeySet 的方式进行遍历；
        5.使用 Lambda 表达式的方式进行遍历；
        6.使用 Streams API 单线程的方式进行遍历；
        7.使用 Streams API 多线程的方式进行遍历。
    * */
    Map<Integer, String> map = new HashMap();
    {
        // 创建并赋值 HashMap
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
    }

    //1.使用迭代器（Iterator）EntrySet 的方式进行遍历；
    @Test
    public void Test01()
    {
        //遍历
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    //2.使用迭代器（Iterator）KeySet 的方式进行遍历；
    @Test
    public void Test02(){
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()){
            Integer key = iterator.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }

    //3.使用ForEach EntrySet 的方式进行遍历；
    @Test
    public void Test03(){
        for (Map.Entry<Integer,String> entry : map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    //4.使用ForEach KeySet 的方式进行遍历；
    @Test
    public void Test04(){
        for (Integer key : map.keySet()) {
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }

    //5.使用ForEach KeySet 的方式进行遍历；
    @Test
    public void Test05(){
        map.forEach((key,value) -> {
            System.out.println(key);
            System.out.println(value);
        });
    }

    //6.Streams API 单线程遍历；
    @Test
    public void Test06(){
        map.entrySet().stream().forEach((entry) ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }

    //7.Streams API 多线程遍历；
    @Test
    public void Test07(){
        map.entrySet().parallelStream().forEach((entry) ->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }

}

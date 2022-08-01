package com.jiangnanyidianyu.BaseDemo.集合类bj.Map;

import com.jiangnanyidianyu.BaseDemo.集合类bj.Entity.Person;

import java.util.Set;
import java.util.TreeMap;

/**
 * @ClassName MapTest
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/2/23 13:46
 */
public class MapTest {
    public static void main(String[] args) {
        /*
            按年龄定制化排序
            treeMap有序且唯一
        */
        TreeMap<Person, String> treeMap = new TreeMap<Person,String>();
        treeMap.put(new Person("张三", 30), "zhangsan");
        treeMap.put(new Person("张三", 33), "zhangsan33");
        treeMap.put(new Person("李四", 20), "lisi");
        treeMap.put(new Person("王五", 10), "wangwu");
        treeMap.put(new Person("小红", 5), "xiaohong");

        Set<Person> keySet = treeMap.keySet();
        for (Person key : keySet) {
            System.out.println(key.getAge() + "-" + key.getName());
        }
    }
}

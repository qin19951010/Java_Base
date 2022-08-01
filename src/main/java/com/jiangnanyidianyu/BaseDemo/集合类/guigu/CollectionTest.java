package com.jiangnanyidianyu.BaseDemo.集合类.guigu;

import org.junit.Test;

import java.util.*;

/**
 * @Description TODO
 *
 *  1.集合,数组都是对多个数组进行存储操作的结构,简称JAVA容器
 *  说明:此时的存储,主要指的是内存层面的存储,不涉及到持久化的存储(.txt,jpg,数据库中)
 *
 *  2.1 数组在存储多个数据方面的特点:
 *      > 一旦初始化以后,其长度就确定了.
 *      > 数组一旦定义好,其元素的类型也就确定了.我们就只能操作指定类型的数据
 *      比如:String[] arr,int[] arr1;Object[] arr2
 *  2.2 数组在存储多个数据方面的缺点:
 *      > 一旦初始化后,其长度就不可修改
 *      > 数组中提供的方法非常有限,对于添加、删除、插入数据等操作,非常不便,同时效率不搞
 *      > 获取数组中实际元素的个数的需求,数组没有现成的属性和方法可用
 *      > 数组存储数据的特点: 有序,可重复 对于无序、不可重复的需求,不能满足
 *
 * 二.集合框架
 *      |----Collection接口:单列集合,用来存储一个个的对象
 *             |----List接口: 存储有序的、可重复的数据
 *                  |----ArrayList、LinkedList、Vector
 *             |----Set接口:存储无序的、不可重复的数据
 *                  |----HashSet、LinkedHashSet、TreeSet
 *      |----Map接口:双列集合,用来存储一对(Key - value)数据
 *             |----HashMap、LinkedHashMap、TreeMap、HashTable、Properties
 * 三.Collection接口中
 *
 *
 *
 *
 * @Author Qinnn丶
 * @Date 2021/6/29 23:18
 **/
public class CollectionTest {

    @Test
    public void testCollection(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("AAAA");
        strings.add("AAAA");
        strings.add("AAAA");
        strings.add("BBBB");
        strings.add("CCCC");
        strings.add("CCCC");
        strings.add("CCCC");
        strings.add("DDDD");
        strings.add("EEEE");
        strings.add("EEEE");
        System.out.println(strings);

        Collections.reverse(strings);
        System.out.println(strings);
        System.out.println("AAAA出现的次数:");
        System.out.println(Collections.frequency(strings,"AAAA"));
    }

    @Test
    public void Test01(){
        Collection<String> list = new ArrayList<>();

        list.add("123");
        list.add("456");
        list.add("789");
        list.add("AAA");

        System.out.println(list.size());

        Collection<String> list2 = new ArrayList<>();

        list2.add("123");
        list2.add("456");
        list2.add("789");
        list2.add("789");

        list.addAll(list2);
        System.out.println(list);

        System.out.println(list.isEmpty());
        //list.clear();
        System.out.println(list.isEmpty());

        list.contains("123");

        boolean b = list.remove("dddd");
        System.out.println(b);

        Collection<String> coll1 = Arrays.asList("AAA", "BBB", "CCC", "123");
        System.out.println("========================");
        System.out.println("list===>" + list);
        System.out.println("coll1====>" + coll1);
        //求交集,返回的是list中与coll1集合相交的部分
        list.retainAll(coll1);

        System.out.println(list);
    }

    @Test
    public void test01(){
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("333");
        list1.add("222");
        list1.add("111");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("111");
        list2.add("222");
        list2.add("333");

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("111");
        list3.add("222");
        list3.add("333");

        boolean b = list1.equals(list3);
        System.out.println(b);
        System.out.println(list1.hashCode());

        //集合 ---> 数组:toArray()
        Object[] objects = list1.toArray();
        for (Object o : objects) {
            System.out.println(o);
        }

        /*
            数组转集合  △
            这里使用的Arrays类的静态方法asList返回的数组是不具备add和remove的 因为没有实现collection接口
            这是一个静态内部类
        */
        List<String> list = Arrays.asList("123", "456", "789");
        list.forEach(System.out::println);

        List arr1 = Arrays.asList(new int[]{123,456});
        // 结果为1
        System.out.println(arr1.size());

        List arr2 = Arrays.asList(new Integer[]{123,456});
        //结果为2
        System.out.println(arr2.size());
        System.out.println("======== iterator迭代器 ============");
    }
}

package com.jiangnanyidianyu.BaseDemo.集合类.guigu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/6/30 10:32
 **/
/*
*  |----Collection接口:单列集合,用来存储一个个的对象 添加的对象所在的类必须重写equals()方法 比如在remove时,比较两个自定义对象是否相等
*      |----List接口: 存储有序的、可重复的数据  --->"动态数组",替换原有的数组
*          |----ArrayList:作为List接口的主要实现类,线程不安全,查询效率高;底层使用object[] elementData存储
*               如果想要保证线程安全,可以使用Collections.synchronizedList(List<T> list)方法返回线程安全类
*          |----LinkedList: 对于频繁的插入、删除操作效率比ArrayList效率高,底层使用的双向链表存储
*          |----Vector:作为List接口的古老实现类,线程安全,效率低;底层使用object[] elementData存储
*
*  ArrayList源码分析:
*   Jdk7:
*       new ArrayList()时,底层生成一个长度为10的Object[]数组elementData
*       elementData[0] = new Integer(123);
*       ...
*       list.add(11);//如果此次的添加导致底层elementData数组容量不够,则扩容
*       默认情况下,扩容为原来容量的1.5倍,同时需要将原有数组中的数据复制到新的数组中
*       结论:建议开发中使用带参的构造器:ArrayList list = new ArrayList(int Capacity)
*
*   Jdk8:
*       new ArrayList()时;底层object[] elementData{}并没有创建长度为10的数组
*       list.add(123);//第一次调用add()时,底层才创建了长度为10的数组,并将数据123添加到elementData[0]
*       ...
*       后续的添加和扩容操作与jdk7一样
*
*   小结:
*       jdk7中的ArrayList的对象创建类类似于单例的饿汉时,而Jdk8中的ArrayList的对象的创建类类似于单例的懒汉式,延迟了数组的创建,
*       节省内存
*
*  面试题: ArrayList,LinkedList,Vector三者的异同
*  相同点: 三个类都实现了List接口,存储数据的特点相同:存储有序的、可重复的数据
*
*
*   LinkedList源码分析:
*      new LinkedList();内部声明了Node类型的first和last属性,默认值为null
*      list.add(123);//将123封装到node中,创建了node对象
*
*      其中Node定义为:  体现了LinkedList的双向链表的说法
*       private static class Node<E> {
*           E item;
*           Node<E> next;
*           Node<E> prev;
*
*           Node(Node<E> prev,E element,Node<E> next){
*               this.item = element;
*               this.next = next;
*               this.prev = prev;
*       }
* }
*
*   Vector源码分析:
*       初始创建的数组长度为10,扩容时为原来的两倍
 */
public class ListTest {
    @Test
    public void test(){

        LinkedList<String> list = new LinkedList<String>();
        list.add("AAAA");
        list.add("BBBB");
        list.add("BBBB");
        list.add("CCCC");
        list.add("DDDD");
        list.add("DDDD");

//        String s = list.get(1);
//        System.out.println(s);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            if("BBBB".equals(s)){
                iterator.remove();
            }
        }
        System.out.println(list);;
    }

    @Test
    public void test_list(){
        ArrayList<String> list = new ArrayList<>(0);
        System.out.println(list);
    }
}

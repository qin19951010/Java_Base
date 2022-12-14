package com.jiangnanyidianyu.BaseDemo.集合类.guigu;

import org.junit.Test;

import java.util.*;
import java.util.Iterator;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/6/30 11:46
 **/

/*
*    |----Collection接口:单列集合,用来存储一个个的对象
*             |----Set接口:存储无序的、不可重复的数据
*                  |----HashSet:作为Set接口的主要实现类;线程不安全,可以存储null值
*                       |----LinkedHashSet:作为HashSet子类;遍历其内部数据时,可以按照添加的顺序遍历
*                           作为HashSet的子类,在添加数据的同时,每个数据还维护了两个引用(链表结构),记录此数据前一个和后一个数据
*                           优点: 对于频繁的遍历操作,LinkedHashSet效率高于HashSet
*
*                  |----TreeSet:可以按照添加对象指定属性进行排序
*
*
* */
public class SetTest {

    /*
    *   一.Set 存储无序的、不可重复的数据
    *   以HashSet为例说明:
    *   1.无序性:不等于随机性.存储的数组在底层数组中并非按照数组索引的顺序添加而是根据数据的哈希值决定的
    *
    *   2.不可重复性: 保证添加的元素按照equals()判断时,不能返回true,即:相同的元素只能添加一个
    *
    *   二.添加元素的过程: 以HashSet为例: [数组和链表](jdk7) HashMap(jdk8)
    *      1. 我们向HashSet中添加元素a,首先调用元素a所在类的hashCode()方法,计算元素a的哈希值
    *      2. 此Hash值接着通过某种算法计算出在HashSet底层数组中的存放位置(即为:索引位置),判断
    *       数组此位置上是否已经有元素;
    *       如果此位置上没有其他元素,则元素a添加成功
    *       如果此位置上有其他元素b(或以链表形式存在多个元素),则比较元素a与元素b的hash值:
    *           如果hash值不相同,则元素a添加成功
    *           如果hash值相同,进而需要调用元素a所在类的equalS()方法
    *                   equals()返回true,元素a添加失败
    *                   equals()返回false,则元素a添加成功.----> 情况2
    *
    *       对于添加成功的情况2和情况3而言:元素a与已经存在指定索引位置上数据以链表的方式存储
    *       jdk7 :元素a放到数组中,指向原来的元素.
    *       jdk8 :原来的元素在数组中,指向元素a
    *       总结:七上八下
    *
    *     1. Set接口中没有额外定义新的方法,使用的都是Collection中声明过的方法
    *
    *     2. 要求: 向Set中添加的数据,其所在的类一定要重写hashcode()和equals()方法
    *        重写的hashCode()和equals()方法尽可能保持一直性:相等的对象必须具有相等的散列码
    *        对象中用作equals()方法比较的Fiedl,都应该用来计算hashcode
    *
    *    TreeSet: 底层为TreeMap
    *       1.存在同一类的对象实例
    *       2.两种排序方式: 自然排序(实现Comparable接口) 和 定制排序(Comparator)
    *
    *       3.自然排序中,比较两个对象是否相同的标准为: compareTo()返回0,不再是equals()
    *
    *       =====底层是红黑树的结构========
    * */

    @Test
    public void treeSet(){
        TreeSet<Object> treeSet = new TreeSet<>();
        treeSet.add("AAA");
        treeSet.add("FFF");
        treeSet.add("123");
        treeSet.add("BBB");
        treeSet.add("DDSS");

        for (Object o : treeSet) {
            System.out.println(o);
        }
    }

    @Test
    public void Test(){
        Set hashSet = new HashSet();
        Set linkedHashSet = new LinkedHashSet();

        hashSet.add(123);
        hashSet.add(456);
        hashSet.add("AA");
        hashSet.add("BB");
        hashSet.add(true);

        linkedHashSet.add(123);
        linkedHashSet.add(456);
        linkedHashSet.add("AA");
        linkedHashSet.add("BB");
        linkedHashSet.add(true);

        Iterator IhashSet = hashSet.iterator();
        while (IhashSet.hasNext()){
            System.out.println(IhashSet.next());
        }

        System.out.println("===================");

        Iterator IlinkedSet = linkedHashSet.iterator();
        while (IlinkedSet.hasNext()){
            System.out.println(IlinkedSet.next());
        }
    }


}

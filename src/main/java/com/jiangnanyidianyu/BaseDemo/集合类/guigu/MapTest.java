package com.jiangnanyidianyu.BaseDemo.集合类.guigu;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/7/2 10:22
 **/
/*
*
*    /-----Map:双列数据,存储key-value对的数据, ---类似于函数:y=f(x)
*         |------HashMap:作为Map的主要实现类;线程不安全; 可以存储null的key和value
*               |------LinkedHashMap:保证在遍历map元素时,可以按照添加的顺序实现遍历
*                       原因:在原有的HashMap底层结构基础上,添加了一对指针,指向前一个和后一个元素
*                       对于频繁的遍历操作,此类执行效率高于HashMap
*
*         |------TreeMap:保证按照添加的key-value对进行排序,实现排序遍历.此时考虑key的自然排序或定制排序
*                        底层使用红黑树
*         |------HashTable:作为古老的实现类;线程安全,效率低; 不能存储null的key和value
*               |------Properties:常用来处理配置文件key和value都是String类型
*
*       HashMap的底层: 数组+链表 (jdk7之前)
*                     数组+链表+红黑树(jdk8)
*
*   面试题:
*   1. HashMap的底层实现原理
*   2. HashMap 和 HashTable的异同
*   3. CurrentHashMap 与 HashTable的 异同?
*
*
*   二.Map结构的理解:
*   Map中的key:无序的、不可重复的,使用set存储所有的key   ---> key所在的类要重写equals()和hashcode方法 (以Hashmap为例)
*   Map中的value:无序的、不可重复的,使用Collection存储所有的Value ----> value所在的类要重写equals()方法  (为了通过key找value)
*   一个键值对:key-value构成一个Entry对象
*   Map中的entry:无序、不可重复的,使用Set存储所有的entry
*
*   三. HashMap的底层实现原理?
*   JDK7 :
*       HashMap map = new HashMap();
*       在实例化以后,底层创建了长度是16的一维数组Entry[] table
*       ...可能已经执行过多次put...
*       map.put(key1,value1):
*         首先,调用key1所在类的hashCode()计算key1哈希值,此哈希值经过某种计算以后,得到entry数组中的存放位置
*         如果此位置上的数据为空,此时的key1-value1添加成功.  ---情况1
*         如果此位置上的数据不为空,(意味着此位置上存在一个或多个数据(以链表形式存在)),比较key1和已经存在的一个或多个数据哈希值
*             如果key1的哈希值与已经存在的数据的哈希值都不相同,此时key1-value1添加成功  --- 情况2
*             如果key1的哈希值和已经存在的某一个数据的哈希值相同,继续比较:调用key1所在类的euqals()方法,比较:
*                    如果equals()返回false:此时key1-value1添加成功  --- 情况3
*                    如果equals()返回true:使用value1替换相同key的value值
*
*       补充: 关于情况2和情况3: 此时key1-value1和原来的数据以链表的方式存储
*
*       在不断的添加过程中,会设计到扩容问题,当超出临界值(且要存放的位置非空)时,扩容.默认的扩容方式:扩容为原来容量的2倍,并将原有的数据赋值过来
*
*       JDK8 相较于JDK7在底层实现方面的不同:
*       1. new HashMap():底层没有创建一个长度16的数组
*       2. JDK8 底层的数组是:Node[],而非Entry[]
*       3. 首次调用put()方法时,底层创建长度为16的数组
*       4. jdk7底层结构只有:数组+链表. JDK8中底层结构: 数组+链表+红黑树
 *          当数组的某一个索引为值上的元素以链表形式存在的数据个数 > 8且当前数组的长度 > 64时
 *          此时此索引位置上的所有数据改为使用红黑树存储(提高效率)
 *
 *      HashMap默认初始化容量:16
 *      加载因子:0.75 (影响链表的长度,加载因子太小数组利用率低,加载因子过大链表的长度过长)
 *      临界值: 扩容的临界值 = 容量*填充因子
 *      Bucked中链表长度大于该默认值,转化为红黑树:8
 *      Bucked中的Node被树化时最小的hash表容量:64
 *
 *   四.LinkedHashMap底层实现原理
* */

public class MapTest {

    @Test
    public void metaOperation(){
        /*
        *   原视图操作方法:
        *   Set keySet():返回所有key构成的Set集合
        *   Colloection values: 返回所有value构成的Collection集合
        *   Set entrySet(): 返回所有key-value对构成的Set集合
        * */
        HashMap<String, String> map = new HashMap<>();
        map.put("AAA","111");
        map.put("aaa","111");

        map.put("BBB","222");
        map.put("CCC","333");
        map.put("DDD","444");
        map.put("EEE","555");
        map.put("eee","555");

        map.put("FFF","666");
        map.put("GGG","777");
        Set<String> setKeys = map.keySet();
        System.out.println("HashMap所有的key的Set");
        for (String key : setKeys) {
            System.out.println(key);
        }

        System.out.println("HashMap所有的Values");
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.println(value);
        }
        
        //遍历所有的key-value
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> entry : entrySet) {
            System.out.println("Key:" + entry.getKey() + ";" + "Value:" + entry.getValue() + "=====>" + entry);
        }
    }

    @Test
    public void testMap(){
        HashMap<String, String> map = new HashMap<>();
        map.put("A","1");
        map.put("B","2");
        map.put("C","3");
        map.put("D","4");
        map.put("E","5");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("E","5");
        map2.put("F","6");

        map.putAll(map2);
        System.out.println(map);

        map.remove("A");
        System.out.println(map);
        System.out.println(map.size());
        map.clear();
        System.out.println(map.size());
        System.out.println(map);
    }

    @Test
    public void testProperties() throws IOException {
        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        pros.load(fis);//加载流对应的文件
        String name = pros.getProperty("name");
        String age = pros.getProperty("age");
        System.out.println("[name=" + name + ";" + "age=" + age + "]");
    }
}

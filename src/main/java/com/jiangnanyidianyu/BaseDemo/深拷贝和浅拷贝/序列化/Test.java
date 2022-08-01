package com.jiangnanyidianyu.BaseDemo.深拷贝和浅拷贝.序列化;

import java.io.*;

/**
 * @ClassName Test
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/28 15:34
 */
public class Test {
    @org.junit.Test
    public void Test01()
    {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;

        try {
            //创建原始可序列化对象
            ColoredCircle cc = new ColoredCircle(100,100,new Color("绿色"));
            System.out.println("原始的对象 = " + cc);

            ColoredCircle cc2 = null;
            //通过序列化实现深拷贝
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            //序列化以及传递这个对象
            oos.writeObject(cc);
            oos.flush();
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ois = new ObjectInputStream(bais);
            //读取序列化返回新对象
            cc2 = (ColoredCircle) ois.readObject();
            //校验内容是否相同
            System.out.println("原对象 = " + cc2);
            System.out.println("复制对象 = " + cc);
            //修改原对象的引用类型属性
            cc.setColor(new Color("黄色"));
            //改变原对象引用类型属性后
            System.out.println("改变属性后的原类型 = " + cc);
            System.out.println("改变属性后的复制类型 = " + cc2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
    }
}

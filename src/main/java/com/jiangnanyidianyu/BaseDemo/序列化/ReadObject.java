package com.jiangnanyidianyu.BaseDemo.序列化;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @ClassName ReadObject
 * @Author: Qinnn、
 * @Description: TODO 反序列化
 * @Date: create in 2020/10/12 11:09
 */
public class ReadObject {

    public static void main(String[] args) {
        try (

            //创建一个ObjectInputStream输入流
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("teacher.txt"))) {
            Teacher brady = (Teacher) ois.readObject();
            System.out.println(brady);
            /**输出结果显示 反序列化时不会调用构造方法*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

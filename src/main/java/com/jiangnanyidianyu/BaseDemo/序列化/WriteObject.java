package com.jiangnanyidianyu.BaseDemo.序列化;

import java.io.*;

/**
 * @ClassName WriteObject
 * @Author: Qinnn、
 * @Description: TODO Person对象序列化
 * @Date: create in 2020/10/12 10:45
 */
public class WriteObject {
    public static void main(String[] args) {

//        try (//创建一个ObjectOutputStream输出流
//             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"))) {
//            //将对象序列化到文件s
//            Person person = new Person("Qinnn", 25);
//            oos.writeObject(person);
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
             ObjectInputStream ios = new ObjectInputStream(new FileInputStream("person.txt"))) {
            //第一次序列化person
            Person person = new Person("9龙", 23);
            oos.writeObject(person);
            System.out.println(person);

            //修改name
            person.setName("海贼王");
            System.out.println(person);
            //第二次序列化person
            oos.writeObject(person);

            //依次反序列化出p1、p2
            Person p1 = (Person) ios.readObject();
            Person p2 = (Person) ios.readObject();
            System.out.println(p1 == p2);
            System.out.println("p1.getName()" + p1.getName());
            System.out.println("p2.getName()" + p2.getName());
            System.out.println(p1.getName().equals(p2.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

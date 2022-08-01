package com.jiangnanyidianyu.BaseDemo.序列化;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @ClassName WriteTeacher
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2020/10/13 11:13
 */
public class WriteTeacher {

    public static void main(String[] args) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher.txt"))) {
            Person person = new Person("路飞", 20);
            Teacher t1 = new Teacher("雷利", person);
            Teacher t2 = new Teacher("红发香克斯", person);
            //依次将4个对象写入输入流
            oos.writeObject(t1);
            oos.writeObject(t2);
            oos.writeObject(person);
            oos.writeObject(t2);
        }
    }

}

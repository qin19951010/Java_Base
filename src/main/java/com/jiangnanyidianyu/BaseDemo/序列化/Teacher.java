package com.jiangnanyidianyu.BaseDemo.序列化;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @ClassName Teacher
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2020/10/12 11:25
 */
public class Teacher implements Serializable {

    private String name;
    private Person person;

    public Teacher(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public static void main(String[] args) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("teacher.txt"))) {
            Person person = new Person("路飞", 20);
            Teacher teacher = new Teacher("雷利", person);
            oos.writeObject(teacher);
        }
    }
}

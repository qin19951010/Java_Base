package com.jiangnanyidianyu.BaseDemo.序列化.Externalizable;

import java.io.*;

/**
 * @ClassName ExPerson
 * @Author: Qinnn、
 * @Description: TODO Externalizable：强制自定义序列化
 * @Date: create in 2020/10/13 14:40
 */
public class ExPerson implements Externalizable {

    private String name;
    private int age;

    //注意，必须加上pulic 无参构造器
    public ExPerson() {
    }

    public ExPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //将name反转后写入二进制流
        StringBuffer reverse = new StringBuffer(name).reverse();
        System.out.println(reverse.toString());
        out.writeObject(reverse);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        //将读取的字符串反转后赋值给name实例变量
        this.name = ((StringBuffer) in.readObject()).reverse().toString();
        System.out.println(name);
        this.age = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ExPerson.txt"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ExPerson.txt"))) {
            oos.writeObject(new ExPerson("brady", 23));
            ExPerson ep = (ExPerson) ois.readObject();
            System.out.println(ep);
        }
    }
}

package com.jiangnanyidianyu.BaseDemo.序列化;

import java.io.*;
import java.util.HashMap;

/**
 * @ClassName Person
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2020/10/12 10:45
 */
public class Person implements Serializable {

    private String name;

    private int age;

    //我不提供无参构造器
    public Person(String name, int age) {
        //System.out.println("反序列化，你调用我了吗？");
        this.name = name;
        this.age = age;
    }

//    private Object writeReplace() throws ObjectStreamException {
//        ArrayList<Object> list = new ArrayList<>(2);
//        list.add(this.name);
//        list.add(this.age);
//        return list;
//    }

    private Object readResolve() throws ObjectStreamException{
        HashMap<String, Integer> map = new HashMap<>();
        map.put("brady",23);
        return map;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +

                '}';
    }

//    private void writeObject(ObjectOutputStream out) throws IOException {
//        //将名字反转写入二进制流
//        out.writeObject(new StringBuffer(this.name).reverse());
//        out.writeInt(age);
//    }
//
//    private void readObject(ObjectInputStream ins) throws IOException,ClassNotFoundException{
//        //将读出的字符串反转恢复回来
//        this.name = ((StringBuffer)ins.readObject()).reverse().toString();
//        this.age = ins.readInt();
//    }

    public static void main(String[] args) throws Exception {
        try (
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));
            ObjectInputStream ios = new ObjectInputStream(new FileInputStream("person.txt"))) {
            Person person = new Person("9龙", 23);
            oos.writeObject(person);

//          ArrayList list = (ArrayList)ios.readObject();
//          System.out.println(list);

            HashMap map = (HashMap)ios.readObject();
            System.out.println(map);

        }

//        StringBuffer buffer = new StringBuffer("我爱你");
//        System.out.printf(buffer.reverse().toString());
    }
}


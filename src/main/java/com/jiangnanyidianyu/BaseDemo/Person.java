package com.jiangnanyidianyu.BaseDemo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/6/24 9:54
 **/
public class Person implements Serializable {

    private String userName;
    private String passWord;

    public Person() {
    }

    public Person(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //SerializableTest();
        //DeserializableTest();
        //asList();
        //reverse();

        //listRemove();
    }

    private static void listRemove() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; ++i) {
            list.add(i);
        }
        list.removeIf(filter -> filter == 3); /* 删除list中的所有偶数 */
        System.out.println(list); /* [1, 3, 5, 7, 9] */
    }

    private static void reverse() {
        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);
        s=list.toArray(new String[0]);//没有指定类型的话会报错
        for (String s1 : s) {
            System.out.println(s1);
        }
    }

    private static void asList() {
        int[] myArray = {1, 2, 3};
        List myList = Arrays.asList(myArray);
        System.out.println(myList.size());//1
        System.out.println(((int[]) myList.get(0))[0]);//数组地址值
        System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
        int[] array = (int[]) myList.get(0);
        System.out.println(array[0]);//1
    }

    private static void DeserializableTest() throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("Qinnn.txt"));
        Person person1 = (Person) inputStream.readObject();
        Person person2 = (Person) inputStream.readObject();
        System.out.println("person1 ==>" + person1);
        System.out.println("person2 ==>" + person2);
        System.out.println(person1==person2);

    }

    private static void SerializableTest() throws IOException {
        Person person1 = new Person("Qinnn", "123456");
        Person person2 = new Person("Qzlll", "AAAAAA");
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Qinnn.txt"));

        outputStream.writeObject(person1);
        outputStream.writeObject(person2);
    }
}

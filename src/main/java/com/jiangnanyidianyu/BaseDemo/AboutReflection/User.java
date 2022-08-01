package com.jiangnanyidianyu.BaseDemo.AboutReflection;


import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName User
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/11 10:32
 */
public class User {

    public static String staticMethod(String A,String B)
    {
        return "这是一个静态方法!" + A + "===>" + B;
    }

    private Integer id;

    private String userName;

    private String passWord;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String SayHello(String A,String B)
    {
        return "这是一个public的成员方法," + A + "==>" + B;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public User(){}

    public User(Integer id, String userName, String passWord) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
    }

    @SneakyThrows
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        User user = new User();

        //获取类的class对象

        //1.通过Class.forName获取全路径指定类名的class
        Class cUser1 = Class.forName("com.jiangnanyidianyu.BaseDemo.AboutReflection.User");
        //2.通过对象获取
        Class<? extends User> cUser2 = user.getClass();
        //3.通过类的class
        Class<User> cUser3 = User.class;

        //获取构造方法
        //1.无参构造方法
        Constructor<User> constructor = null;
        try {
            constructor = cUser3.getConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        User user1 = constructor.newInstance();
        //2.有参构造方法
        Constructor<User> constructor1 = cUser3.getConstructor(Integer.class, String.class, String.class);
        User user2 = constructor1.newInstance(111, "Qinnn", "123456");
        System.out.println(user2.toString());

        //获取属性成员方法
        //getFields:获取某个类的所有公共(public)字段,包括父类中的字段
        Field[] fields = cUser3.getFields();
        for (Field f:fields) {
            System.out.println(f.toString());
        }
        System.out.println("============================================================");
        //getDeclaredFields():获取某个类中所有声明的字段,包括public,protect,private,但不包括父类中的字段
        Field[] declaredFields = cUser3.getDeclaredFields();
        for (Field f:declaredFields) {
            System.out.println(f.toString());
        }

        //获取类的成员方法并调用
        Method method = cUser3.getMethod("SayHello",String.class,String.class);
        Object o = method.invoke(user1,"Qinnn","Zxmmm");
        String s = o==null ? "" : o.toString();
        System.out.println(o);

        //获取类的成员方法并调用
        Method method1 = cUser3.getDeclaredMethod("staticMethod", String.class, String.class);
        Object o1 = method1.invoke(cUser3, "Qinnn", "Zxmmmm");
        System.out.println(o1);

    }
}

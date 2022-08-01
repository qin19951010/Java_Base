package com.jiangnanyidianyu.BaseDemo.装箱拆箱;

/**
 * @ClassName test
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/12 11:23
 */
public class test {
    /**
     *     将基本数据类型转换成包装器类型 == > 装箱
     *     将包装器类型转换成基本数据类型 == > 拆箱
     */
    public static void main(String[] args) {
        //自动装箱
        Integer total = 99;
        //自动拆箱
        int totalprim = total;

        int intValue = total.intValue();
        /*
         *   public static Integer valueOf(int i) {
             return  i >= 128 || i < -128 ? new Integer(i) : SMALL_VALUES[i + 128];
             }
         **/
        //装箱
        Integer integer = Integer.valueOf(115);
        Integer integer1 = new Integer(115);
        //拆箱
        int totalprim1 = total;
        int value = integer.intValue();

        Integer Integer1 = new Integer(12);
        Integer Integer2 = new Integer(12);
        System.out.println(Integer1==Integer2?true:false);
        Integer Integer3 = new Integer(212);
        Integer Integer4 = new Integer(212);
        System.out.println(Integer3==Integer4?true:false);

        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1==i2);  //true
        System.out.println(i3==i4);  //false

        Double d1 = 100.0;
        Double d2 = 100.0;
        Double d3 = 200.0;
        Double d4 = 200.0;

        System.out.println(d1==d2); //false
        System.out.println(d3==d4); //false

        Integer num1 = 400;
        int num2 = 400;
        System.out.println(num1 == num2); //true
    }
}

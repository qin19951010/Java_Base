package com.jiangnanyidianyu.BaseDemo.Stream流.函数式接口;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FunctionTest {
    //函数式接口
//    public interface KiteFunction<T, R, S> {
//
//        /**
//         * 定义一个双参数的方法,函数式接口
//         * @param t
//         * @param s
//         * @return
//         */
//        R run(T t,S s);
//    }


    //定义了一个方法和函数式接口run对应
    public static String DateFormat(LocalDateTime dateTime, String partten) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(partten);
        return dateTime.format(dateTimeFormatter);
    }

    //用方法引用的方式调用
    public static void main(String[] args) {
        KiteFunction<LocalDateTime,String,String> functionDateFormat = FunctionTest::DateFormat;
        String dateString = functionDateFormat.run(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss");
        System.out.println("dateString ==>" + dateString);
        //====================②匿名内部类==========================//
        String dateString2 = new KiteFunction<LocalDateTime, String, String>() {
            @Override
            public String run(LocalDateTime localDateTime, String s) {
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(s);
                return localDateTime.format(dateTimeFormatter);
            }
        }.run(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss");
        System.out.println("dateString2 ==>" + dateString2);
        //====================③匿名内部类简写==========================//
        KiteFunction<LocalDateTime, String, String> functionDateFormat2 = (LocalDateTime dateTime, String partten) -> {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(partten);
            return dateTime.format(dateTimeFormatter);
        };
        String dateString3 = functionDateFormat.run(LocalDateTime.now(), "yyyy-MM-dd HH:mm:ss");
        System.out.println("dateString3 ==>" + dateString3);

    }
}


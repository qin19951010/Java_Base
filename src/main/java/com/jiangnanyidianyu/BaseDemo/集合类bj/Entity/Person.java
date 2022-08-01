package com.jiangnanyidianyu.BaseDemo.集合类bj.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Person
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/2/23 11:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Comparable<Person>{

    private String name;
    private int age;

    /*
    * 重写CompareTo方法实现按年龄排序
    * */
    @Override
    public int compareTo(Person o) {
        if(this.age > o.getAge()){
            return 1;
        }
        if(this.age < o.getAge()) {
            return -1;
        }
        return 0;
    }
}

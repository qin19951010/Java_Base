package com.jiangnanyidianyu.BaseDemo.AboutInner.静态内部类;

/**
 * @ClassName Other
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2020/10/13 16:53
 */
public class Other {

    public static void main(String[] args) {
        
        //访问静态内部类的静态方法，Inner类被加载,此时外部类未被加载，独立存在，不依赖于外围类。
        Outer.Inner.innerStaticShow();

        //访问静态内部类的成员方法
        Outer.Inner oi = new Outer.Inner();
        oi.innerShow();
    }
}

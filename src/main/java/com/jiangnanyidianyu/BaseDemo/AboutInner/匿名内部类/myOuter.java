package com.jiangnanyidianyu.BaseDemo.AboutInner.匿名内部类;

/**
 * @ClassName myOuter
 * @Author: Qinnn、
 * @Description: TODO 匿名内部类
 * @Date: create in 2020/10/14 11:14
 */
public class myOuter {
    public static JustDo justDo(final String name){
        return new JustDo() {
            @Override
            public void justdo() {
                System.out.println(name);
            }};
    }

    public static void main(String[] args) {
        myOuter.justDo("Qinnn尽管努力去做不留遗憾!").justdo();
    }
}

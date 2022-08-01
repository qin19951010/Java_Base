package com.jiangnanyidianyu.BaseDemo.Stream流.函数式接口;

@FunctionalInterface
public interface KiteFunction<T, R, S> {

    /**
     * 定义一个双参数的方法,函数式接口
     * @param t
     * @param s
     * @return
     */
    R run(T t,S s);
}


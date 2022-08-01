package com.jiangnanyidianyu.BaseDemo.测试包;

import org.junit.Test;

import java.util.HashMap;

/**
 * @Description TODO
 * @Author Qinnn丶
 * @Date 2021/7/5 20:41
 **/
public class test1 {
    //统计一个String中每个字符出现的次数
    @Test
    public void testString(){
        String s = "sada3213edcdseqwdczc_";
        char[] array = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : array) {
            if(map.containsKey(c)){
                Integer count = map.get(c);
                map.put(c,++count);
            }else
                map.put(c,1);
        }
        System.out.println(map);
    }
}

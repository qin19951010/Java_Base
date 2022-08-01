package com.jiangnanyidianyu.Java8.Stream;

import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author QinZhongliang
 * @date 2022年07月29日 2:51 PM
 */
public class toMap {

    @Test
    /** 
     * 一对一映射
     */
    public void toMap(){
        List<String> ids = Arrays.asList("205", "105", "308", "469", "627", "193", "111");
        // 使用流操作
        List<User> results = ids.stream()
                .map(id -> {
                    User user = new User();
                    user.setId(id);
                    return user;
                })
                .collect(Collectors.toList());
        System.out.println(results);
    }

    @Test
    public void toMap2(){
        List<String> ids = Arrays.asList("205", "105", "308", "469", "627", "193", "111");
        // 使用流操作
        ArrayList<User> list = new ArrayList<>();
        ids.stream().forEach(
                v->{
                    User user = new User();
                    user.setId(v);
                    list.add(user);
                }
        );
        System.out.println(list);
    }

    @Test
    public void stringToIntFlatmap() {
        List<String> sentences = Arrays.asList("hello world","Jia Gou Wu Dao");
        // 使用流操作
        List<String> results = sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .collect(Collectors.toList());
        System.out.println(results);
    }

    @Data
    class User{
        private String id;
    }
}

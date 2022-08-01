package com.jiangnanyidianyu.BaseDemo.IO相关;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName User
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/27 15:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private String userid;
    private String username;
    private String mark;
    private transient int weight;
}

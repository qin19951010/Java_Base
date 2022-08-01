package com.jiangnanyidianyu.BaseDemo.深拷贝和浅拷贝.序列化;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Color
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/28 15:58
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Color implements Serializable {
    private String name;
}

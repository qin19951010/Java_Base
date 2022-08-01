package com.jiangnanyidianyu.BaseDemo.深拷贝和浅拷贝.序列化;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName ColoredCircle
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/28 15:33
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColoredCircle implements Serializable {
    private int x;
    private int y;

    private Color color;
}

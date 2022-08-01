package com.jiangnanyidianyu.Java8.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author QinZhongliang
 * @date 2022年07月29日 10:03 AM
 */
@Data
@AllArgsConstructor
public class Employee {
    private String name;
    private String subCompany;
    private String department;
    private Integer age;
    private Integer salary;
}

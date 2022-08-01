package com.jiangnanyidianyu.BaseDemo.HTTP.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Response
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/3/10 13:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    //响应行
    //1.响应的协议
    private String protocolType;
    //2.响应码
    private String responseCode;
    //3.响应消息
    private String responseMsg;

    //响应头
    //1.响应类型
    private String repsonseType;
    //2.响应长度
    private Integer responseLength;

    //响应体
    private String responseBody;


}

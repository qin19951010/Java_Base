package com.jiangnanyidianyu.BaseDemo.HTTP.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @ClassName Request
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/3/10 10:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    //请求行的内容
    //1.请求方式
    private String requestType;
    //2.请求地址
    private String url;
    //3.请求的协议 http1.1 http2
    private String protocolType;
    //其他请求头中的参数
    private Map<String,String> header;
    //请求体
    private String requestBody;
}

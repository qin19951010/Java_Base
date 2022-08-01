package com.jiangnanyidianyu.BaseDemo.HTTP.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Response1
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/3/10 14:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response1 {

    private final String CRLF ="\r\n";

    private StringBuilder responseLine = new StringBuilder();
    private StringBuilder responseHeader = new StringBuilder();
    private StringBuilder responseBody = new StringBuilder();

    private String content;

    /*
    *   构建响应行
    **/
    private void buildResponseLine(int code){

        responseLine.append("HTTP/1.1").append(" ").append(code).append(" ");
        switch (code){
            case 404:
                responseLine.append("NOT FOUND");
                break;
            case 505:
                responseLine.append("SERVER ERROR");
                break;
            case 200:
                responseLine.append("OK");
                break;
        }
        responseLine.append(CRLF);
    }

    /*
    * 构建响应头
    **/
    private void buildResponseHeader(String contentType){
        responseHeader.append("Content-type:").append(contentType).append(";charset=utf-8").append(CRLF);
        responseHeader.append("Content-Length:").append(content.getBytes().length).append(CRLF);
        responseHeader.append(CRLF);
    }

    /*
     * 构建响应头
     **/
    private void buildResponseBody(){
        responseBody.append(content);
    }

    public String build(int code,String content,String contentType){
        setContent(content);
        buildResponseLine(code);
        buildResponseHeader(contentType);
        buildResponseBody();
        return responseLine.append(responseHeader).append(responseBody).toString();
    }
}

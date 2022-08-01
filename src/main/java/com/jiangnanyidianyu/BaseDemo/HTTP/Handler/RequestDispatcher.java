package com.jiangnanyidianyu.BaseDemo.HTTP.Handler;

import com.jiangnanyidianyu.BaseDemo.HTTP.Entity.Request;
import com.jiangnanyidianyu.BaseDemo.HTTP.Entity.Response1;
import com.jiangnanyidianyu.BaseDemo.HTTP.Socket_Demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @ClassName RequestDispatcher
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/3/10 15:35
 */
public class RequestDispatcher {
    public static String dispatch(Request request) throws IOException {
        //拼接响应消息
        String html = "<h1>%s</h1>";
        String url = request.getUrl();
        Map<String, String> header = request.getHeader();
        if(header.containsKey("type") && header.get("type").equals("login"))
        {
            InputStream stream = Socket_Demo.class.getClassLoader().getResourceAsStream("com/jiangnanyidianyu/BaseDemo/HTTP/Login.html");
            byte[] bytes = new byte[2048];
            int len = stream.read(bytes);
            html = new String(bytes,0,len);
        }
        else
        {
            html = String.format(html,url);
        }
        Response1 response = new Response1();
        String responseStr = response.build(200, html, "text/html");
        return responseStr;
    }
}

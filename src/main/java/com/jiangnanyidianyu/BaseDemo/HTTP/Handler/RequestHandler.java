package com.jiangnanyidianyu.BaseDemo.HTTP.Handler;

import com.jiangnanyidianyu.BaseDemo.HTTP.Entity.Request;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName RequestHandler
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/3/10 10:26
 */
public class RequestHandler {
    public static Request requestHandler(Socket socket) throws IOException {
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[2048];
        int len = inputStream.read(buffer);
        String request = new String(buffer,0,len);
        //获取请求行
        String[] headerAndBody = request.split("\r\n\r\n");
        String[] split = headerAndBody[0].split("\r\n");
        String[] typeSplit = split[0].split(" ");

        Request request1 = new Request();
        //设置请求方式
        request1.setRequestType(typeSplit[0]);
        //设置URL
        request1.setUrl(typeSplit[1]);
        //设置协议版本
        request1.setProtocolType(typeSplit[2]);

        Map<String, String> mapHeader = new HashMap<>();
        for (int i = 1; i < split.length; i++) {
            if(split[i] == null || "".equals(split[i])) {
                break;
            }
            String[] split1 = split[i].split(": ");
            mapHeader.put(split1[0],split1[1]);
        }
        request1.setHeader(mapHeader);
        //如果存在请求体
        if(headerAndBody.length == 2 && headerAndBody[1] != null && !"".equals(headerAndBody[1]))
        {
            request1.setRequestBody(headerAndBody[1].toString());
        }
        return request1;
    }
}

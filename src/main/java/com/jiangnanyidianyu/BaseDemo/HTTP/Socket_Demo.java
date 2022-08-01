package com.jiangnanyidianyu.BaseDemo.HTTP;

import com.jiangnanyidianyu.BaseDemo.HTTP.Entity.Request;
import com.jiangnanyidianyu.BaseDemo.HTTP.Handler.RequestDispatcher;
import com.jiangnanyidianyu.BaseDemo.HTTP.Handler.RequestHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName Socket_Demo
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/3/10 9:48
 */
public class Socket_Demo {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket();
        //绑定端口，等待8888端口接收到消息
        socket.bind(new InetSocketAddress(8888));
        //阻塞,等待客户端访问

        while (true)
        {
            Socket accept = socket.accept();
            //处理请求信息
            Request request = RequestHandler.requestHandler(accept);
            //请求信息处理,返回响应内容
            String dispatch = RequestDispatcher.dispatch(request);
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write(dispatch.getBytes());
            outputStream.flush();
            outputStream.close();
        }
//        inputStream.close();
    }
}

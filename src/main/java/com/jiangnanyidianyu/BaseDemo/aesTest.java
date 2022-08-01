package com.jiangnanyidianyu.BaseDemo;

import cn.hutool.core.date.DateUtil;
import org.joda.time.LocalDateTime;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author QinZhongliang
 * @date 2022年07月06日 4:23 PM
 */
public class aesTest {

    public static void main(String[] args) {
        System.out.println(imgToBase64("http://xp-shop.oos-cn.ctyunapi.cn/other/2022/05/24/c2326bc88779449081a5619353dc83bf.png"));
    }

//    public static String NetImageToBase64(String netImagePath) {
//        final ByteArrayOutputStream data = new ByteArrayOutputStream();
//        String strNetImageToBase64 = "";
//        try {
//            // 创建URL
//            URL url = new URL(netImagePath);
//            final byte[] by = new byte[1024];
//            // 创建链接
//            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setConnectTimeout(5000);
//            InputStream is = conn.getInputStream();
//            // 将内容读取内存中
//            int len = -1;
//            while ((len = is.read(by)) != -1) {
//                data.write(by, 0, len);
//            }
//            // 对字节数组Base64编码
//            BASE64Encoder encoder = new BASE64Encoder();
//            strNetImageToBase64 = encoder.encode(data.toByteArray());
//            System.out.println("网络图片转换Base64:" + strNetImageToBase64);
//            // 关闭流
//            is.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return strNetImageToBase64;
//    }

    public Integer test(){
        int i = 0;
        return i;
    }

    public static String imgToBase64(String path){
        byte[] data = null;
        InputStream in = null;
        ByteArrayOutputStream out = null;
        try{
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            in = connection.getInputStream();
            out = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int len = 0;
            while((len =in.read(b)) != -1){
                out.write(b,0,len);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(in != null ){
                    in.close();
                }
            }catch (IOException e){
                e.getStackTrace();
            }
        }
        System.out.println("转换后的图片大小："+out.toByteArray().length/1024);
        BASE64Encoder base = new BASE64Encoder();
        return base.encode(out.toByteArray());
    }

}

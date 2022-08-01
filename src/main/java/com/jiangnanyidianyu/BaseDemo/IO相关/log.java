package com.jiangnanyidianyu.BaseDemo.IO相关;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName log
 * @Author: Qinnn、
 * @Description: TODO
 * @Date: create in 2021/1/27 10:55
 */
public class log {

    private static final String RfilePath = "C:\\Users\\Administrator\\Desktop\\Qinnn.log";

    private static final String WfilePath = "C:\\Users\\Administrator\\Desktop\\Qinnn2.log";

    @Test
    //一个字节一个字节的读取
    public void FileRead2() throws IOException {
        int count=0;//读取次数
        FileInputStream fis = new FileInputStream(RfilePath);
        int len;
        //一个字节一个字节的读取，读完返回-1
        while ((len = fis.read()) != -1) {
            System.out.print((char)len);
            count++;
        }
        System.out.println("读取次数:"+count);
        fis.close();
    }

    @Test
    //一次多个字节的读取
    public void FileRead() throws IOException {
        int count=0;//读取次数
        FileInputStream fis = new FileInputStream(RfilePath);
        byte[] n=new byte[1024];
        int len;
        //一个字节一个字节的读取，读完返回-1
        while ((len = fis.read(n)) != -1) {
            //new String(byte[] bytes, int offset, int length) 通过使用平台的默认字符集解码指定的 byte 子数组，构造一个新的 String
            System.out.println(new String(n,0,len));
            count++;
        }
        System.out.println("读取次数:"+count);
        fis.close();
    }

    //文件写入
    @Test
    public void FileWriter() throws IOException {
        FileOutputStream  fos = new FileOutputStream (RfilePath);
        //写入单个字节
        fos.write(98);
        //写入多个字节
        fos.write(",Hello World!".getBytes());
        fos.close();
    }

    //文件拷贝
    @Test
    public void fileCopy() throws IOException {
        FileOutputStream fos = new FileOutputStream (WfilePath);
        FileInputStream fis = new FileInputStream(RfilePath);

        byte[] bs = new byte[2048];
        int i;
        while(( i= fis.read(bs)) != -1)
        {
            fos.write(bs,0,i);
        }
        fis.close();
        fos.close();
    }

    //BuffereInputStream和BuffereOutputStream
    //缓冲流拷贝
    @Test
    public void fileBufferCopy() throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(RfilePath));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(WfilePath));

        byte[] bytes = new byte[2048];
        int i;
        while ((i=bis.read(bytes)) != -1) {
            bos.write(bytes,0,i);
        }
        bos.close();
        bis.close();
    }

    //InputStreamReader和OutputStreamWriter
    //带有中文的拷贝
    @Test
    public void fileBufferCopy2() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(RfilePath));
        BufferedWriter bw = new BufferedWriter(new FileWriter(WfilePath));

        char[] chars = new char[1024];
        int i;
        while ((i = br.read(chars)) != -1)
        {
            bw.write(chars,0,i);
        }
        bw.close();
        br.close();
    }

    @Test
    public void ObjectTest() throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(WfilePath));
        oos.writeObject(new User("0011","Qinnn","测试",110));
        oos.close();
    }

    @Test
    public void ObjectTest2() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(WfilePath));
        byte[] bytes = new byte[1024];
        Object o = ois.readObject();
        System.out.println(o);
        ois.close();
    }
}

package com.jiangnanyidianyu.BaseDemo.序列化2;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;

/**
 * @ClassName Message
 * @Author: Qinnn、
 * @Description: TODO jackson类
 * @Date: create in 2020/12/25 16:39
 */

/**
 @JsonIgnoreProperties({"MsgDate","Msg"}) 类注解
 屏蔽当前类中不需要序列化的字段

 @JsonProperty("Msg") 属性注解

 @JsonPropertyOrder
 和 @JsonProperty 的index属性类似，指定属性在序列化时 json 中的顺序,
 示例：@JsonPropertyOrder({ "birth_Date", "name" })

 @JsonAnySetter
 用于属性或者方法，设置未反序列化的属性名和值作为键值存储到 map 中 :
 @JsonAnySetter
 public void set(String key, Object value){
 map.put(key, value);}

 @JsonAnyGetter
 用于方法,获取所有未序列化的属性 :
 @JsonAnyGetter
 public Map<String, Object> any() {
 return map;}

 @JsonNaming
 类注解。序列化的时候该注解可将驼峰命名的字段名转换为下划线分隔的小写字母命名方式。
 反序列化的时候可以将下划线分隔的小写字母转换为驼峰命名的字段名。
 示例：@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)

 @JsonRootName
 类注解。需开启mapper.enable(SerializationFeature.WRAP_ROOT_VALUE)，
 用于序列化时输出带有根属性名称的 JSON 串，
 形式如 {"root_name":{"id":1,"name":"zhangsan"}}。
 但不支持该 JSON 串反序列化。

 */
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
//@JsonRootName(value = "Data")
public class Message<T> {
    /**@JsonProperty 序列化改变属性名称 */
    @JsonProperty("MsgDate")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date date;

    @JsonProperty("Msg")
    private String msg;

    @JsonProperty("MsgStatus")
    private int status;

    @JsonProperty("MsgData")
    private T data;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

//    @JsonCreator
//    public Message(@JsonProperty("date") Date date, @JsonProperty("msg") String msg, @JsonProperty("status") int status,@JsonProperty("data") T data) {
//        this.date = date;
//        this.msg = msg;
//        this.status = status;
//        this.data = data;
//    }

    public Message(Date date,String msg,int status,T data) {
        this.date = date;
        this.msg = msg;
        this.status = status;
        this.data = data;
    }

    public Message() {
    }

//    @JsonAnySetter
//    public void set(String key, Object value) { map.put(key, value); }

    @Override
    public String toString() {
        return "Message{" +
                "date=" + date +
                ", msg='" + msg + '\'' +
                ", status=" + status +
                ", data=" + data +
                '}';
    }
}
package com.jiangnanyidianyu.BaseDemo.序列化2;

public enum Response {

    SUCCESS(1,"成功","成功数据"),
    FAIL(0,"失败","失败数据");

    private final String Data;
    private final int Code;
    private final String Msg;

    Response(int Code,String Msg,String Data)
    {
        this.Data = Data;
        this.Code = Code;
        this.Msg = Msg;
    }

    public static void main(String[] args) {
        System.out.println(Response.SUCCESS.toString());
    }

    public String getData() {
        return Data;
    }

    public int getCode() {
        return Code;
    }

    public String getMsg() {
        return Msg;
    }
}

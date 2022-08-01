package com.jiangnanyidianyu.BaseDemo;
/*
 * TODO: 枚举
 * @author Qinnn丶
 * @date 2021/6/24 11:34
 * @param null
 * @return null
*/
public enum PizzaStatus {
    ORDERED,
    READY,
    DELIVERED;

    public static void main(String[] args) {
        System.out.println(PizzaStatus.ORDERED.name());//ORDERED
        System.out.println(PizzaStatus.ORDERED);//ORDERED
        System.out.println(PizzaStatus.ORDERED.name().getClass());//class java.lang.String
        System.out.println(PizzaStatus.ORDERED.getClass());//class shuang.kou.enumdemo.enumtest.PizzaStatus
    }
}

class Pizza {

    private PizzaStatus status;

    public enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED;
    }

    public boolean isDeliverable() {
        return getStatus() == PizzaStatus.READY;
    }

    public PizzaStatus getStatus() {
        return status;
    }

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }
}


package com.jiangnanyidianyu.多线程.JUC;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;

/**
 * @author QinZhongliang
 * @date 2022年08月02日 11:38 AM
 */
public class ProAndConsuModel {
    public static void main(String[] args) throws InterruptedException {
        MessageQueue queue = new MessageQueue(10);

        // 三个生产者向队列里存值
        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(() -> {
                queue.put(new Message(id, "值" + id));
            }, "生产者" + i).start();
        }

        Thread.sleep(1000);

        // 一个消费者不停的从队列里取值
        new Thread(() -> {
            while (true) {
                queue.take();
            }
        }, "消费者").start();
    }
}

// 消息队列被生产者和消费者持有
class MessageQueue {
    private LinkedList<Message> list = new LinkedList<>();

    // 容量
    private int capacity;

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 生产
     */
    public void put(Message message) {
        synchronized (list) {
            while (list.size() == capacity) {
                System.out.println("队列已满，生产者等待");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.addLast(message);
            System.out.println("生产消息:" + message);
            // 生产后通知消费者
            list.notifyAll();
        }
    }
    
    /** 
     * 消费
     */
    public Message take() {
        synchronized (list) {
            while (list.isEmpty()) {
                System.out.println("队列已空，消费者等待");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message message = list.removeFirst();
            System.out.println("消费消息:" + message);
            // 消费后通知生产者
            list.notifyAll();
            return message;
        }
    }
}
// 消息
@Data
@AllArgsConstructor
class Message {
    private int id;

    private Object value;
}

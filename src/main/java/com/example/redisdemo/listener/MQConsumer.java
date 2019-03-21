package com.example.redisdemo.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: redis-demo
 * @description: MQ消费者
 * @author: Eyki
 * @create: 2019-03-21 12:12
 **/
@Component
public class MQConsumer {

    @JmsListener(destination = "my_msg")
    public void readMsg(String text) {
        System.out.println("接收到消息：" + text);
    }

    @JmsListener(destination = "my_map")
    public void readMap(Map map) {
        System.out.println(map);
    }
}

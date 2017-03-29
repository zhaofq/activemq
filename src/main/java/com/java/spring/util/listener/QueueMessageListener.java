package com.java.spring.util.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.jms.listener.adapter.MessageListenerAdapter;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年3月28日 下午1:35:43
* 类说明
*/
public class QueueMessageListener implements MessageListener {
	public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("QueueMessageListener监听到了文本消息：\t"+ tm.getText());
            //do something ...
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

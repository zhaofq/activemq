package com.java.spring.serviceImpl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.java.spring.service.ProducerService;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年3月28日 上午10:19:15
* 类说明
*/
@Service
public class ProducerServiceImpl implements ProducerService{
	private static Logger loger = Logger.getLogger(ProducerServiceImpl.class.getName());
	
	//指定消息目的地的发送方法
	@Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;
	public void sendMessage(Destination destination,final String msg){
        System.out.println(Thread.currentThread().getName()+" 向队列"+destination.toString()+"发送消息---------------------->"+msg);
        loger.info(Thread.currentThread().getName()+" 向队列"+destination.toString()+"发送消息---------------------->"+msg);
        jmsTemplate.send(destination,new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }
	
	//默认消息目的地的方法
    public void sendMessage(final String msg){
        Destination destination = jmsTemplate.getDefaultDestination();
        System.out.println(Thread.currentThread().getName()+" 向队列"+destination+"发送消息---------------------->"+msg);
        loger.info(Thread.currentThread().getName()+" 向队列"+destination+"发送消息---------------------->"+msg);
        jmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
     }
}

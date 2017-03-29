package com.java.spring.service;

import javax.jms.Destination;

import org.springframework.stereotype.Service;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年3月28日 上午10:19:15
* 类说明
*/
@Service
public interface ProducerService {
	
	public void sendMessage(Destination destination,final String msg);
	
	 public void sendMessage(final String msg);

}

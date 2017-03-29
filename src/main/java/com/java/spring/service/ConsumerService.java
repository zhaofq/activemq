package com.java.spring.service;

import javax.jms.Destination;
import javax.jms.TextMessage;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年3月28日 上午10:29:24
* 类说明
*/
public interface ConsumerService {
	
	
	 public TextMessage receive();
}

package com.java.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.spring.service.ConsumerService;
import com.java.spring.service.ProducerService;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年3月28日 上午10:51:48
* 类说明
*/
@Controller
public class MessageController {
	


	@Autowired(required=false)
	ProducerService producerService;
	
	@Autowired(required=false)
	ConsumerService consumerService;
	
	
	@RequestMapping(value="/sendMessage",method=RequestMethod.GET)
	public @ResponseBody void send(String msg) {
		msg="helloActiveMq";
		producerService.sendMessage(msg);
	}
	
	@RequestMapping(value="/receiveMessage",method=RequestMethod.GET)
	public @ResponseBody void receive() {
		consumerService.receive();
		
	}
	
}

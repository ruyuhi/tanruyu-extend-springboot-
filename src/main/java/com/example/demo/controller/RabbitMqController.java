/*
 * @(#)RabbitMqController.java V2.0 2017年12月21日
 * 摩贝化学品电商综合服务平台	版权所有
 * 
 * 文件描述...
 *
 * @Title: RabbitMqController.java 
 * @Package com.molbase.simple.controller 
 * @author ruyu.tan
 * @date 2017年12月21日 下午5:01:27
 * @version
 * 	【2017年12月21日】 创建文件   by 谭如余
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.mq.para.MQParam;
import com.example.demo.mq.util.SendUtil;

/** 
 * rabbit mq 控制类
 * 
 * @ClassName: RabbitMqController 
 * @author ruyu.tan
 * @date 2017年12月21日 下午5:01:27
 * @version V2.0 
 *  
 */
@Controller
@RequestMapping("/rabbitMq/")
public class RabbitMqController {
	
	@Autowired
	private SendUtil sendUtil;
	
	/**
	 * 方法描述：   发送信息到MQ中
	 * @Title: sendMessage2Mq 
	 * @date 2017年12月21日 下午5:02:16
	 * @author ruyu.tan
	 * @modifier 
	 * @modifydate 
	 * @return
	 */
	@RequestMapping(value="sendMessage2Mq",method=RequestMethod.POST)
	@ResponseBody
	public Object sendMessage2Mq(@RequestBody String msg){
		sendUtil.send(msg);
		return "success";
	}
	
	/**
	 * 方法描述：   发送信息到Exchange中
	 * @Title: sendMessage2Mq 
	 * @date 2017年12月21日 下午5:02:16
	 * @author ruyu.tan
	 * @modifier 
	 * @modifydate 
	 * @return
	 */
	@RequestMapping(value="sendMessage2Exchange",method=RequestMethod.POST)
	@ResponseBody
	public Object sendMessage2Exchange(@RequestBody MQParam param){
		sendUtil.send(param.getRoutingKey(), param.getMsg());;
		return "success";
	}
	
	/**
	 * 方法描述：   发送信息到Exchange中
	 * @Title: sendMessage2Mq 
	 * @date 2017年12月21日 下午5:02:16
	 * @author ruyu.tan
	 * @modifier 
	 * @modifydate 
	 * @return
	 */
	@RequestMapping(value="sendMessage2FanoutExchange",method=RequestMethod.POST)
	@ResponseBody
	public Object sendMessage2FanoutExchange(@RequestBody MQParam param){
		sendUtil.send(param.getExchangeName(),param.getRoutingKey(), param.getMsg());;
		return "success";
	}
	
	

}

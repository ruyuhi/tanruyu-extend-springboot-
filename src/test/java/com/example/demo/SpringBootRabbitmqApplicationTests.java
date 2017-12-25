package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.mq.util.MQReceiveUtil;
import com.example.demo.mq.util.SendUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRabbitmqApplicationTests {

	@Autowired
	private SendUtil sendUtil;
	
//	@Autowired
//	private MQReceiveUtil receiveUtil;
	
	@Test
	public void contextLoads() {
		
	}
	
	@Test
	public void sendMessage2MQ() {
		sendUtil.send("这是我的发给rabbit mq 队列的第一条消息");
	}
	
	@Test
	public void sendMessage2Exchange() {
		sendUtil.send("test.customer.#", "这是我发给exchange 中的第一条消息");
	}
	
	

}

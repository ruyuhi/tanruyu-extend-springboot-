package com.example.demo.mq.util;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** 
 * 监听MQ中的信息
 * 
 * @ClassName: MQReceiveUtil 
 * @author ruyu.tan
 * @date 2017年12月21日 下午5:26:08
 * @version V2.0 
 *  
 */
@Component
public class MQReceiveUtil {
	
	@Value("${customer.receiver.queue.name}")
	private String receiveQueueName;
	
	@Value("${provider.send.queue.name}")
	private String receiveQueueName2;

	@RabbitListener(queues="${customer.receiver.queue.name}")
	public void receiveMqMessage(String str){
		System.out.println("test.customer.queue 监听到的信息是:"+str);
	}
	
	@RabbitListener(queues="${provider.send.queue.name}")
	public void receiveMqMessage2(String str){
		System.out.println("test.provider.queue 监听到的信息是:"+str);
	}
	
	
	
}

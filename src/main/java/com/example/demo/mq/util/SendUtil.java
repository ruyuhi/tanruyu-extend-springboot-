package com.example.demo.mq.util;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** 
 * 发送消息到MQ中
 * 
 * @ClassName: SendUtil 
 * @author ruyu.tan
 * @date 2017年12月21日 下午4:59:36
 * @version V2.0 
 *  
 */
@Component
public class SendUtil {

	@Autowired
    private AmqpTemplate template;
	
	@Value("${provider.send.queue.name}")
	private String providerQueueName;
	
	@Value("${toptic.exchange.name}")
	private String exchangeName;
    
    /**
     * 方法描述：   发送消息给队列
     * @Title: send 
     * @date 2017年12月22日 上午10:21:38
     * @author ruyu.tan
     * @modifier 
     * @modifydate 
     * @param msg
     */
    public void send(String msg) {
    	template.convertAndSend(providerQueueName,msg);
    }
    
    /**
     * 方法描述：   发送消息给交换机
     * @Title: send 
     * @date 2017年12月22日 上午10:21:38
     * @author ruyu.tan
     * @modifier 
     * @modifydate 
     * @param msg
     */
    public void send(String routingKey,String msg) {
    	template.convertAndSend(exchangeName,routingKey,msg);
    }
    
    /**
     * 方法描述：   发送消息给交换机
     * @Title: send 
     * @date 2017年12月22日 上午11:31:51
     * @author ruyu.tan
     * @modifier 
     * @modifydate 
     * @param exchangeName 交换机名称
     * @param routingKey 路由规则
     * @param msg 发送的消息
     */
    public void send(String exchangeName,String routingKey,String msg) {
    	template.convertAndSend(exchangeName,routingKey,msg);
    }
 
	
}

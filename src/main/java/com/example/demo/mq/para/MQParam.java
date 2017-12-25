package com.example.demo.mq.para;

/** 
 * MQ请求入参
 * 
 * @ClassName: MQParam 
 * @author ruyu.tan
 * @date 2017年12月22日 上午10:55:03
 * @version V2.0 
 *  
 */
public class MQParam {
	
	/** 
	 * @Fields msg : 发送队列的消息
	 */
	private String msg;
	
	/** 
	 * @Fields routingKey : 路由规则
	 */
	private String routingKey;
	
	/** 
	 * @Fields exchangeName : 交换机名称 
	 */
	private String exchangeName;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRoutingKey() {
		return routingKey;
	}

	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}

	public String getExchangeName() {
		return exchangeName;
	}

	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}
	
	

}

package com.order;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.dto.OrderProducer;
import com.order.dto.FulfillmentOrder;


@Component
public class QueueSender {
	@Autowired
	AmqpTemplate xmlAmqpTemplate;

	@Autowired
	AmqpTemplate jsonAmqpTemplate;

	@Autowired
	private Queue jsonQueue;

	@Autowired
	private Queue xmlQueue;

	public void send(FulfillmentOrder fulfillmentOrder) throws AmqpException {
	jsonAmqpTemplate.convertAndSend(xmlQueue.getName(), fulfillmentOrder);
	}

	public void send(OrderProducer orderMessageJson) throws AmqpException {
	xmlAmqpTemplate.convertAndSend(jsonQueue.getName(), orderMessageJson);
	}
}

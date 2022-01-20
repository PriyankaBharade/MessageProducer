package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.QueueSender;
import com.order.dto.OrderProducer;
import com.order.dto.FulfillmentOrder;
import com.order.services.OrderProduceService;


import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("order/producer")
public class OrderProduceController {
	
//	@Autowired
//	private RabbitTemplate template;
//	@Autowired
//	private RabbitTemplate xmltTemplate;
	@Autowired
	OrderProduceService orderProduceService;
	@Autowired
	QueueSender queueSender;

	@ApiOperation(value = "Produce JSON data over the RabbitMQ server.")
	@PostMapping(value = "/create/order", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<OrderProducer> getOrder(@RequestBody OrderProducer orderProducer) {
		queueSender.send(orderProducer);
	//	template.convertAndSend(MQProducer.EXCHNAGE, MQProducer.RoutingKey,orderProducer);
		return new ResponseEntity<>(orderProduceService.produceMessageOrder(orderProducer), HttpStatus.OK);
	}

	
	@ApiOperation(value = "Produce XML data over the RabbitMQ server.")
	@PostMapping(value = "/create/xml/order", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	ResponseEntity<FulfillmentOrder> addXMLOrder(@RequestBody FulfillmentOrder fulfillmentOrder) {
		System.out.println("FulFillData" + fulfillmentOrder.toString());
		queueSender.send(fulfillmentOrder);
		//xmltTemplate.convertAndSend(MQProducer.EXCHNAGE, MQProducer.RoutingKey,fulfillmentOrder);
		return new ResponseEntity<>(orderProduceService.produceMessageOrderXML(fulfillmentOrder), HttpStatus.OK);
	}
	
	
}

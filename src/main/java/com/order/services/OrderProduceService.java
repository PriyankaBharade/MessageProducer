package com.order.services;

import com.order.dto.OrderProducer;
import com.order.dto.FulfillmentOrder;

public interface OrderProduceService {

	public OrderProducer produceMessageOrder(OrderProducer orderProducer);

	public FulfillmentOrder produceMessageOrderXML(FulfillmentOrder fulfillmentOrder);
}

package com.order.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dto.OrderProducer;
import com.order.dto.FulfillmentOrder;
import com.order.entity.OrderProducerEntity;
import com.order.repo.OrderProduceRepository;

@Service
public class OrderProduceServiceImpl implements OrderProduceService {
	@Autowired
	OrderProduceRepository orderProduceRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public OrderProducer produceMessageOrder(OrderProducer orderProducer) {
		//System.out.println("Request Data" + orderProducer);
		//OrderProducerEntity orderProducerEntity = modelMapper.map(orderProducer, OrderProducerEntity.class);
		//orderProduceRepository.save(orderProducerEntity);
		return orderProducer;
	}

	@Override
	public FulfillmentOrder produceMessageOrderXML(FulfillmentOrder fulfillmentOrder) {
		System.out.println("Request Data" + fulfillmentOrder);
		//OrderProducerEntity orderProducerEntity = modelMapper.map(orderProducer, OrderProducerEntity.class);
		//orderProduceRepository.save(orderProducerEntity);
		return fulfillmentOrder;
	}

	

}

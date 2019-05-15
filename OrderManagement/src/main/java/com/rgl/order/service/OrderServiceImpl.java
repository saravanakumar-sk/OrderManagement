package com.rgl.order.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgl.order.dao.OrderDAO;
import com.rgl.order.model.Order;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO orderDAO;

	public static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

	

	@Override
	public List<Order> getOrder(int id) throws Exception {
		LOGGER.info("Entering getOrder<<");
		try{
		List<Order> payments = orderDAO.getOrder(id);
		LOGGER.info("Exiting getOrder>>");
		return payments;
		}
		catch(Exception e){
			LOGGER.error("Exception in getting order",e.getMessage());
			throw new Exception();
		}
	}



	@Override
	public int deleteOrder(int id) throws Exception {
		LOGGER.info("Entering deleteOrder<<");
		try{
		return  orderDAO.deleteOrder(id);
		}
		catch(Exception e){
			LOGGER.error("Exception in deleting order",e.getMessage());
			throw new Exception();
		}
	}



	@Override
	public int updateOrder(int id, Order order) throws Exception {
		LOGGER.info("Entering updateOrder<<");
		try{
		return  orderDAO.updateOrder(id,order);
		}
		catch(Exception e){
			LOGGER.error("Exception in updating order",e.getMessage());
			throw new Exception();
		}
	}

	@Override
	public int createOrder( Order order) throws Exception {
		LOGGER.info("Entering updateOrder<<");
		try{
		return  orderDAO.createOrder(order);
		}
		catch(Exception e){
			LOGGER.error("Exception in updating order",e.getMessage());
			throw new Exception();
		}
	}
	

	

}

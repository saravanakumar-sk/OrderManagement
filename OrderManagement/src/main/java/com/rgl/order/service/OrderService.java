package com.rgl.order.service;


import java.util.List;

import com.rgl.order.model.Order;

public interface OrderService {
	
	public List<Order> getOrder(int id) throws Exception;

	public int deleteOrder(int id) throws Exception;

	public int updateOrder(int id, Order order)throws Exception;

	public int createOrder(Order order) throws Exception;
	
}

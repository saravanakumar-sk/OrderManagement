package com.rgl.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rgl.order.dao.OrderDAO;
import com.rgl.order.model.Order;
import com.rgl.order.service.OrderService;
import com.rgl.order.util.CustomErrorType;

@RestController
@RequestMapping("/api/Order")
public class OrderRestController {

	public static final Logger LOGGER = LoggerFactory.getLogger(OrderRestController.class);

	@Autowired
	OrderService orderService;

	@Autowired
	OrderDAO orderDAO;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Order>> getOrdersResponse() {
		LOGGER.info("Entering getOrder API<<");
		LOGGER.info("Id : ");
		List<Order> order;
		try {

			order = orderService.getOrders();

		} catch (Exception e) {
			LOGGER.error("Order not found.");
			return new ResponseEntity(new CustomErrorType("Order not found." + " Please try with valid id."),
					HttpStatus.NOT_FOUND);
		}

		LOGGER.info("Exiting getOrder API>>");
		return new ResponseEntity<List<Order>>(order, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Order>> getOrderResponse(@PathVariable int id) {
		LOGGER.info("Entering getOrder API<<");
		LOGGER.info("Id : "+id);
		List<Order> order;
		try {

			order = orderService.getOrder(id);

		} catch (Exception e) {
			LOGGER.error("Order not found.");
			return new ResponseEntity(new CustomErrorType("Order not found." + " Please try with valid id."),
					HttpStatus.NOT_FOUND);
		}

		LOGGER.info("Exiting getOrder API>>");
		return new ResponseEntity<List<Order>>(order, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity deleteOrderResponse(@PathVariable int id) {
		LOGGER.info("Entering deleteOrder API<<");
		LOGGER.info("Id : "+id);
		List<Order> order;
		int number;
		try {

			order = orderService.getOrder(id);
			if (order == null) {
				return new ResponseEntity(new CustomErrorType("Order not found"), HttpStatus.NOT_FOUND);
			}
			number = orderService.deleteOrder(id);
			if (number > 1) {
				LOGGER.info("Exiting deleteOrder API>>");
				return new ResponseEntity(HttpStatus.OK);
			}
			throw new Exception();
		} catch (Exception e) {
			LOGGER.error("Order not found.");
			return new ResponseEntity(new CustomErrorType("Order not found" + "Please try with valid id."),
					HttpStatus.NOT_FOUND);
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity updateOrderResponse(@PathVariable int id, @RequestBody Order order) {
		LOGGER.info("Entering updateOrder API<<");
		LOGGER.info("Id : "+id+ " Order : "+order);

		int number;
		try {

			number = orderService.updateOrder(id, order);
			if (number > 1) {
				LOGGER.info("Exiting updateOrder API>>");
				return new ResponseEntity(HttpStatus.OK);
			}
			throw new Exception();
		} catch (Exception e) {
			LOGGER.error("Order not found.");
			return new ResponseEntity(new CustomErrorType("Order not found" + "Please try with valid id."),
					HttpStatus.NOT_FOUND);
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity createOrderResponse(@RequestBody Order order) {
		LOGGER.info("Entering updateOrder API<<");
		LOGGER.info("Order : "+order);

		int number;
		try {

			number = orderService.createOrder(order);
			if (number > 1) {
				LOGGER.info("Exiting createOrder API>>");
				return new ResponseEntity(HttpStatus.OK);
			}
			throw new Exception();
		} catch (Exception e) {
			LOGGER.error("Order not found.");
			return new ResponseEntity(new CustomErrorType("Order not found" + "Please try with valid id."),
					HttpStatus.NOT_FOUND);
		}

	}

}
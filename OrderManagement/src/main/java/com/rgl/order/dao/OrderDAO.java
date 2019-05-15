package com.rgl.order.dao;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.rgl.order.model.Order;
import com.rgl.order.util.DateUtil;

@Service("orderDAO")
public class OrderDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderDAO.class);
	private static boolean isDebugEnabled = LOGGER.isDebugEnabled();

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public List<Order> getOrders() throws Exception {
		LOGGER.info("Entering getOrder<<");
		
		try {
			Map<String, Integer> paramsMap = new HashMap<>();
			

			if (isDebugEnabled) {
				LOGGER.debug("SQL for getPayments is : " + SQLConstants.getOrder);
			}

			List<Order> orders = new ArrayList<Order>();
			List<Map<String, Object>> rows = namedJdbcTemplate.queryForList(SQLConstants.getOrders,paramsMap);

			for (Map<String, Object> row : rows) {
				Order order = new Order();
				order.setOrderNo((int) row.get("ORDER_NO"));
				order.setItemId((int) row.get("ITEM_NO"));
				order.setCustomerId((int) row.get("CUSTOMER_ID"));
				order.setQuantity((int) row.get("QUANTITY"));
				order.setStatus((String) row.get("STATUS"));
				order.setOrderDate(row.get("CREATED_TS").toString());
				order.setUpdatedDate(row.get("UPDATED_TS").toString());
				order.setPrice((float) row.get("PRICE"));

				orders.add(order);
			}

			if (isDebugEnabled) {
				LOGGER.debug("Orders fetched : " + orders);
			}

			LOGGER.info("Exiting getOrder>>");
			return orders;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in getOrder", e.getMessage());
			throw new Exception();
		}
	}

	public List<Order> getOrder(int id) throws Exception {
		LOGGER.info("Entering getOrder<<");
		LOGGER.info("Id : " + id);
		try {
			Map<String, Integer> paramsMap = new HashMap<>();
			paramsMap.put("id", id);

			if (isDebugEnabled) {
				LOGGER.debug("SQL for getPayments is : " + SQLConstants.getOrder);
			}

			List<Order> orders = new ArrayList<Order>();
			List<Map<String, Object>> rows = namedJdbcTemplate.queryForList(SQLConstants.getOrder, paramsMap);

			for (Map<String, Object> row : rows) {
				Order order = new Order();
				order.setOrderNo((int) row.get("ORDER_NO"));
				order.setItemId((int) row.get("ITEM_NO"));
				order.setCustomerId((int) row.get("CUSTOMER_ID"));
				order.setQuantity((int) row.get("QUANTITY"));
				order.setStatus((String) row.get("STATUS"));
				order.setOrderDate(row.get("CREATED_TS").toString());
				order.setUpdatedDate(row.get("UPDATED_TS").toString());
				order.setPrice((float) row.get("PRICE"));

				orders.add(order);
			}

			if (isDebugEnabled) {
				LOGGER.debug("Orders fetched : " + orders);
			}

			LOGGER.info("Exiting getOrder>>");
			return orders;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in getOrder", e.getMessage());
			throw new Exception();
		}
	}

	public int deleteOrder(int id) throws Exception {
		LOGGER.info("Entering getPayments<<");
		LOGGER.info("Id : " + id);
		int number = 0;
		try {
			Map<String, Integer> paramsMap = new HashMap<>();
			paramsMap.put("id", id);
			number = namedJdbcTemplate.update(SQLConstants.deleteOrder, paramsMap);

			if (isDebugEnabled) {
				LOGGER.debug("SQL for deletePayments is : " + SQLConstants.deleteOrder);
			}
			LOGGER.info("Exiting deleteOrder>>");
			return number;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in deletePayments", e.getMessage());
			throw new Exception();
		}
	}

	public int updateOrder(int id, Order order) throws Exception{
		LOGGER.info("Entering getPayments<<");
		LOGGER.info("Id : " + id);
		int number = 0;
		try {
			Map<String, Object> paramsMap = new HashMap<>();
			paramsMap.put("id", id);
			paramsMap.put("quantity",order.getQuantity());
			paramsMap.put("price",order.getPrice());
			paramsMap.put("updatedTs",Instant.now());
			number = namedJdbcTemplate.update(SQLConstants.updateOrder, paramsMap);

			if (isDebugEnabled) {
				LOGGER.debug("SQL for updateOrder is : " + SQLConstants.updateOrder);
			}
			LOGGER.info("Exiting updateOrder>>");
			return number;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in updateOrder", e.getMessage());
			throw new Exception();
		}
	}

	public int createOrder(Order order) throws Exception{
		LOGGER.info("Entering createPayments<<");
		LOGGER.info("Order : " + order);
		int number = 0;
		try {
			Map<String, Object> paramsMap = new HashMap<>();
			paramsMap.put("itemId", order.getItemId());
			paramsMap.put("quantity",order.getQuantity());
			paramsMap.put("customerId",order.getCustomerId());
			paramsMap.put("price",order.getPrice());
			paramsMap.put("status","CREATED");
			paramsMap.put("createdTs",Instant.now() );
			paramsMap.put("updatesTs",Instant.now() );
			number = namedJdbcTemplate.update(SQLConstants.createOrder, paramsMap);

			if (isDebugEnabled) {
				LOGGER.debug("SQL for updateOrder is : " + SQLConstants.createOrder);
			}
			LOGGER.info("Exiting updateOrder>>");
			return number;
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Error in updateOrder", e.getMessage());
			throw new Exception();
		}
	}

	


	/*
	 * public List<Payments> getPayments(String fromDate, String toDate, int page,
	 * int size) { System.out.println("From Date :::::::::::::::::::::::::" +
	 * fromDate); System.out.println("To Date :::::::::::::::::::::::::" + toDate);
	 * try { Map<String, Object> paramsMap = new HashMap<String, Object>();
	 * paramsMap.put("fromDate", dateUtil.parseDate(fromDate));
	 * paramsMap.put("toDate", dateUtil.parseDate(toDate)); paramsMap.put("page",
	 * page-1); paramsMap.put("size", size);
	 * 
	 * List<Payments> payments = new ArrayList<Payments>(); List<Map<String,
	 * Object>> rows =
	 * namedJdbcTemplate.queryForList(SQLConstants.getPaymentsWithPage, paramsMap);
	 * 
	 * for (Map<String, Object> row : rows) { Payments payment = new Payments();
	 * payment.setId((int) row.get("ID")); payment.setBeneName((String)
	 * row.get("BENE_NAME")); payment.setBeneAccount((String)
	 * row.get("BENE_ACCOUNT")); payment.setCreditorName((String)
	 * row.get("CREDITOR_NAME")); payment.setCreditorAccount((String)
	 * row.get("CREDITOR_ACCOUNT")); payment.setAmount(new
	 * BigDecimal(row.get("AMOUNT").toString()));
	 * payment.setDate(row.get("DATE").toString());
	 * 
	 * payments.add(payment); } return payments; } catch (Exception e) {
	 * e.printStackTrace(); return null; } }
	 */
}

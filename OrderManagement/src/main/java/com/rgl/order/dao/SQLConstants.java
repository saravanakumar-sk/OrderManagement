package com.rgl.order.dao;

public class SQLConstants {

	public static final String getOrder = "Select * from ORDER_MGMT.ORDER where order_no = :id";
	public static final String deleteOrder = "Delete from ORDER_MGMT.ORDER where order_no = :id";
	public static final String updateOrder = "Update ORDER_MGMT.ORDER Set (PRICE,QUANTITY,UPDATED_TS) values (:price,:quantity,:updatedTs) where order_no = :id";
	public static final String createOrder = "Insert into ORDER_MGMT.ORDER Set(ORDER_NO,ITEM_NO,CUSTOMER_ID,QUANTITY,STATUS,CREATED_TS,UPDATED_TS,PRICE)"
			+ "values (select max(order_no) from ORDER_MGMT.ORDER+1, :itemId,customerId,:quantity,:status,:createdTs,:updatesTs,:price)";
}

package com.rgl.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rgl.order.requestBody.OrderRequest;

@FeignClient(name = "inventory", url="http://localhost:8070/inventory")
public interface InventoryService {
	@RequestMapping(method = RequestMethod.PUT, value="/inventory/updateStock" )
	public String updateStock(OrderRequest order);
}

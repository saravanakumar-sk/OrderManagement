package com.rgl.order;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

public class OrderRestTestClient {

	public static final String REST_SERVICE_URI = "http://localhost:8080/PaymentsRestAPI/api";

	/* GET */
	@SuppressWarnings("unchecked")
	private static void listAllPayments() {
		System.out.println("Testing API-----------");

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> paymentsMap = restTemplate
				.getForObject(REST_SERVICE_URI + "/getPayments/2000-01-01/2010-12-31", List.class);

		if (paymentsMap != null) {
			for (LinkedHashMap<String, Object> map : paymentsMap) {
				System.out.println("Payments : id=" + map.get("id") 
								+ ", BeneName=" + map.get("beneName")
								+ ", BeneAccount="+ map.get("beneAccount")
								+ ", CreditorName=" + map.get("creditorName")
								+ ", CreditorAccount="+ map.get("creditorAccount")
								+ ", Amount="+map.get("amount"));
				
			}
		} else {
			System.out.println("No payments exist----------");
		}
	}

	public static void main(String args[]) {
		listAllPayments();
	}
}
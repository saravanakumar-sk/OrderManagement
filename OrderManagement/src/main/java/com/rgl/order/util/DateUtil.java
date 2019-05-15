package com.rgl.order.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rgl.order.dao.OrderDAO;

@Service("dateUtil")
public class DateUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderDAO.class);

	private static boolean isDebugEnabled = LOGGER.isDebugEnabled();
	
	private static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	
	public Date parseDate(String strDate) throws Exception {
	if(isDebugEnabled){
		LOGGER.debug("Parsing date :"+strDate);
	}
		Date date = new Date();
		try {
			dateFormatter.setLenient(false);
			date =dateFormatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.error("Error in parsing date.",e);
			throw new Exception();
		}
		if(isDebugEnabled){
			LOGGER.debug("Parsing date :"+strDate);
		}
		return date;
	}

}

package com.test;

import java.util.Calendar;
import java.util.Date;

import com.util.date.CommonUtilDate;

public class Test {
	
	public static void main(String[] args) {
		
		String string = "";
		Date date = null;
		boolean isTrue = false;
		int day = 0;
		long second = 0;
		
		string = CommonUtilDate.getNowDateString("yyyy-MM-dd HH:mm:ss");
		System.out.println("getNowDateString = "+string);
		
		string = CommonUtilDate.getDateString(new Date(), "yyyy-MM-dd HH:mm:ss");
		System.out.println("getDateString = "+string);
		
		date = CommonUtilDate.parseToDate("2017-08-08 12:30:45", "yyyy-MM-dd HH:mm:ss");
		System.out.println("parseToDate = "+date);
		
		isTrue = CommonUtilDate.isToday(new Date());
		System.out.println("isToday = "+isTrue);
		
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 7, 1, 0, 0, 0); // 2017-08-01 00:00:00
		
		isTrue = CommonUtilDate.isPastDay(cal.getTime());
		System.out.println("isPastDay = "+isTrue);
		
		day = CommonUtilDate.getDiffDay(cal.getTime(), new Date());
		System.out.println("getDiffDay = "+day);
		
		second = CommonUtilDate.getDiffSecond(cal.getTime(), new Date());
		System.out.println("getDiffSecond = "+second);
		
		date = CommonUtilDate.getAddDayDate(new Date(), 5);
		System.out.println("getAddDayDate = "+date);
		
		second = CommonUtilDate.getPastSecond(cal.getTime());
		System.out.println("getPastSecond = "+second);
		
		isTrue = CommonUtilDate.isOverSecond(cal.getTime(), 100);
		System.out.println("isOverSecond = "+isTrue);  
		
	}
	
}

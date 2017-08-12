package com.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonUtilDate {
	
	// 현재의 유닉스 타임 반환
	public static long getNowUnixTime() {
		return new Date().getTime();
	}
	
	// 지정한 날짜의 시간의 유닉스 타임 반환
	public static long getUnixTime(Date date) {
		return date.getTime();
	}
	
	// 현재 날짜를 지정한 패턴으로 반환
	public static String getNowDateString(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String dateString = sdf.format(new Date());
		return dateString;
	}
	
	// 특정 날짜를 지정한 패턴으로 반환
	public static String getDateString(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern); // "yyyy-MM-dd HH:mm:ss"
		String dateString = sdf.format(date);
		return dateString;
	}
	
	// 텍스트로 된 날짜를 Date로 변환후 반환
	public static Date parseToDate(String dateString, String pattern) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			date = sdf.parse(dateString);
		} catch( Exception e ) {
			e.printStackTrace();
		}
		return date;
	}
	
	// 입력한 날짜가 오늘인지 여부를 반환
	public static boolean isToday(Date date) {
		SimpleDateFormat dailyFormat = new SimpleDateFormat("yyyy-MM-dd");
		String sTargetDate = dailyFormat.format(date);
		String sNowDate = dailyFormat.format(new Date());
		return sTargetDate.equals(sNowDate);
	}
	
	// 입력한 날짜가 지난 날짜인지 여부를 반환
	public static boolean isPastDay(Date date) {
		long nowTime = getNowUnixTime();
		long targetTime = date.getTime();
		
		return nowTime > targetTime;
	}
	
	// 두 날짜의 차(일) 구하기. secondDate - firstDate
	public static int getDiffDay(Date firstDate, Date secondDate) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String sFirstDate = sdf.format(firstDate);
		String sSecondDate = sdf.format(secondDate);

		int diffDays = 0;
		try {
			Date beginDate = sdf.parse(sFirstDate);
			Date endDate = sdf.parse(sSecondDate);

			long diff = endDate.getTime() - beginDate.getTime();
			diffDays = (int) (diff / (24 * 60 * 60 * 1000));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return diffDays;
	}
	
	// 두 날짜의 차(초) 구하기. secondDate - firstDate
	public static long getDiffSecond(Date firstDate, Date secondDate) {
		long firstTime = firstDate.getTime();
		long secondTime = secondDate.getTime();
		
		return (long) Math.ceil( ( secondTime - firstTime ) / 1000 );
	}
	
	// 임의의 날짜에서 +N일 더한 Date를 반환
	public static Date getAddDayDate(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, n);
		return cal.getTime();
	}

	// 입력한 날짜로부터 경과한 시간을 초(second)로 반환
	public static long getPastSecond(Date startDate) {
		long differTime = (long) Math.ceil((getNowUnixTime() - startDate.getTime()) / 1000.0); // 소수점은 버림
		if (differTime < 0)
			differTime = 0;
		return differTime;
	}
	
	// 입력한 날짜로부터 경과한 시간(초)이 입력한 특정시간(초)을 넘겼는지 여부를 반환
	public static boolean isOverSecond(Date date, int second) {
		return getPastSecond(date) > second;
	}
	
}

package com.util.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommonUtilDate {
	
	// ������ ���н� Ÿ�� ��ȯ
	public static long getNowUnixTime() {
		return new Date().getTime();
	}
	
	// ������ ��¥�� �ð��� ���н� Ÿ�� ��ȯ
	public static long getUnixTime(Date date) {
		return date.getTime();
	}
	
	// ���� ��¥�� ������ �������� ��ȯ
	public static String getNowDateString(String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String dateString = sdf.format(new Date());
		return dateString;
	}
	
	// Ư�� ��¥�� ������ �������� ��ȯ
	public static String getDateString(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern); // "yyyy-MM-dd HH:mm:ss"
		String dateString = sdf.format(date);
		return dateString;
	}
	
	// �ؽ�Ʈ�� �� ��¥�� Date�� ��ȯ�� ��ȯ
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
	
	// �Է��� ��¥�� �������� ���θ� ��ȯ
	public static boolean isToday(Date date) {
		SimpleDateFormat dailyFormat = new SimpleDateFormat("yyyy-MM-dd");
		String sTargetDate = dailyFormat.format(date);
		String sNowDate = dailyFormat.format(new Date());
		return sTargetDate.equals(sNowDate);
	}
	
	// �Է��� ��¥�� ���� ��¥���� ���θ� ��ȯ
	public static boolean isPastDay(Date date) {
		long nowTime = getNowUnixTime();
		long targetTime = date.getTime();
		
		return nowTime > targetTime;
	}
	
	// �� ��¥�� ��(��) ���ϱ�. secondDate - firstDate
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
	
	// �� ��¥�� ��(��) ���ϱ�. secondDate - firstDate
	public static long getDiffSecond(Date firstDate, Date secondDate) {
		long firstTime = firstDate.getTime();
		long secondTime = secondDate.getTime();
		
		return (long) Math.ceil( ( secondTime - firstTime ) / 1000 );
	}
	
	// ������ ��¥���� +N�� ���� Date�� ��ȯ
	public static Date getAddDayDate(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, n);
		return cal.getTime();
	}

	// �Է��� ��¥�κ��� ����� �ð��� ��(second)�� ��ȯ
	public static long getPastSecond(Date startDate) {
		long differTime = (long) Math.ceil((getNowUnixTime() - startDate.getTime()) / 1000.0); // �Ҽ����� ����
		if (differTime < 0)
			differTime = 0;
		return differTime;
	}
	
	// �Է��� ��¥�κ��� ����� �ð�(��)�� �Է��� Ư���ð�(��)�� �Ѱ���� ���θ� ��ȯ
	public static boolean isOverSecond(Date date, int second) {
		return getPastSecond(date) > second;
	}
	
}

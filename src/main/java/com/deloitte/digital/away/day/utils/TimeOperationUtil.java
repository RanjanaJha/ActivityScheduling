package com.deloitte.digital.away.day.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Ranjana
 *
 */
public class TimeOperationUtil {

	/**
	 * @param time in the specified date format ("hh:mm a")
	 * @param mins non negative number
	 * @return String version of the time
	 */
	public static String addMinsToTime(String time,int mins) {
		Date date = dateForDateFormat(time, Constants.DATE_FORMAT);
		
		Calendar newTime = Calendar.getInstance();
		newTime.setTime(date);
		newTime.add(Calendar.MINUTE, mins);
		
		return formatSimpleDate(newTime.getTime(), Constants.DATE_FORMAT);
	}
	
	private static Date dateForDateFormat(String time,String dateFormat) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		Date date = null;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
	}
	
	private static String formatSimpleDate(Date time,String dateFormat) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		
		return format.format(time);
	}
	
	public static long timeDifferenceInMins(String startTime,String endTime) {
		Date firstDate = dateForDateFormat(startTime, Constants.DATE_FORMAT);
		Date secondDate = dateForDateFormat(endTime, Constants.DATE_FORMAT);
		
		long difference = (secondDate.getTime() - firstDate.getTime())/(60*1000);
		
		return difference;
	}
	
	public static boolean compareTime(String firstTime,String secondTime,String dateFormat) {
		Date firstDate = dateForDateFormat(firstTime, dateFormat);
		Date secondDate = dateForDateFormat(secondTime, dateFormat);
		
		boolean isEarlyTime = firstDate.before(secondDate);
		
		return isEarlyTime;
	}
}
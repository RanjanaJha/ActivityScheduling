package com.deloitte.digital.away.day.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.deloitte.digital.away.day.exception.SchedulerException;

/**
 * @author Ranjana Utility Class for operation on time
 */
public class TimeOperationUtil {

	/**
	 * @param time in the specified date format ("hh:mm a")
	 * @param mins non negative number
	 * @return String version of the time
	 */
	public static String addMinsToTime(String time, int mins, String dateFormat) {
		Date date = dateForDateFormat(time, dateFormat);

		Calendar newTime = Calendar.getInstance();
		newTime.setTime(date);
		newTime.add(Calendar.MINUTE, mins);

		return formatSimpleDate(newTime.getTime(), dateFormat);
	}

	/**
	 * @param time
	 * @param dateFormat
	 * @return Date
	 */
	private static Date dateForDateFormat(String time, String dateFormat) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		Date date = null;
		try {
			date = format.parse(time);
		} catch (ParseException e) {
			throw new SchedulerException(Constants.INCORRECT_DATE_FORMAT);
		}

		return date;
	}

	/**
	 * @param time
	 * @param dateFormat
	 * @return String formatted date
	 */
	private static String formatSimpleDate(Date time, String dateFormat) {
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);

		return format.format(time);
	}

	/**
	 * @param startTime
	 * @param endTime
	 * @return long time difference
	 */
	public static long timeDifferenceInMins(String startTime, String endTime, String dateFormat) {
		Date firstDate = dateForDateFormat(startTime, dateFormat);
		Date secondDate = dateForDateFormat(endTime, dateFormat);

		long difference = (secondDate.getTime() - firstDate.getTime()) / (60 * 1000);

		return difference;
	}

	/**
	 * @param firstTime
	 * @param secondTime
	 * @param dateFormat
	 * @return boolean comparison result
	 */
	public static boolean compareTime(String firstTime, String secondTime, String dateFormat) {
		Date firstDate = dateForDateFormat(firstTime, dateFormat);
		Date secondDate = dateForDateFormat(secondTime, dateFormat);

		boolean isEarlyTime = firstDate.before(secondDate);

		return isEarlyTime;
	}
}
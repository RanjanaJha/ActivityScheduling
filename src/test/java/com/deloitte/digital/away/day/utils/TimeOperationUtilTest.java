package com.deloitte.digital.away.day.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.deloitte.digital.away.day.exception.SchedulerException;

public class TimeOperationUtilTest {
	
	@Test
	public void testAddMinsToTimeCheckCorrectFormat() {
		String newTime = TimeOperationUtil.addMinsToTime(Constants.START_TIME, 45,Constants.DATE_FORMAT);
		String expectedTime = "09:45 AM";
		assertTrue(expectedTime.equals(newTime));
	}
	
	@Test
	public void testTimeDifferenceInMins() {
		long newTime = TimeOperationUtil.timeDifferenceInMins(Constants.START_TIME, Constants.LUNCH_START_RANGE,Constants.DATE_FORMAT);
		assertTrue(150==newTime);
		long endTimeDuration = TimeOperationUtil.timeDifferenceInMins(Constants.START_TIME, Constants.LUNCH_END_RANGE,Constants.DATE_FORMAT);
		assertTrue(240==endTimeDuration);
	}
	
	@Test
	public void testCompareTime() {
		String firstTime = "03:55 PM";
		String secondTime = "04:00 PM";
		boolean isEalryTime = TimeOperationUtil.compareTime(firstTime, secondTime, Constants.DATE_FORMAT);
		assertTrue(isEalryTime);
	}
	
	@Test(expected = SchedulerException.class)
	public void testIncorrectDateFormat() {
		String firstTime = "03:55";
		String secondTime = "04:00 PM";
		TimeOperationUtil.compareTime(firstTime, secondTime, Constants.DATE_FORMAT);
	}

}

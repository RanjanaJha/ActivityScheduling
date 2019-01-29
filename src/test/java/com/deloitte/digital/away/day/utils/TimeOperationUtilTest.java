package com.deloitte.digital.away.day.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeOperationUtilTest {

	@Test
	public void testAddMinsToTimeCheckCorrectFormat() {
		String newTime = TimeOperationUtil.addMinsToTime(Constants.START_TIME, 45);
		String expectedTime = "09:45 AM";
		assertTrue(expectedTime.equals(newTime));
	}
	
	@Test
	public void compareTime() {
		String firstTime = "03:55 PM";
		String secondTime = "04:00 PM";
		boolean isEalryTime = TimeOperationUtil.compareTime(firstTime, secondTime, Constants.DATE_FORMAT);
		assertTrue(isEalryTime);
	}

}

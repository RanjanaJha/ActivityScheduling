package com.deloitte.digital.away.day.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.deloitte.digital.away.day.utils.Constants;

public class ScheduleTest {

	@Test
	public void testToString() {
		List<Activity> activities = new ArrayList<>();
		activities.add(createActivityData("Duck Herding", 45));
		activities.add(createActivityData("Archery", 60));
		
		Schedule schedule = new Schedule(activities);
	
		StringBuffer expected = new StringBuffer();
		expected.append(Constants.START_TIME);
		expected.append(Constants.BLANK_SPACE);
		expected.append(Constants.COLON);
		expected.append(Constants.BLANK_SPACE);
		expected.append(activities.get(0));
		expected.append(Constants.NEW_LINE);
		expected.append("09:45 AM");
		expected.append(Constants.BLANK_SPACE);
		expected.append(Constants.COLON);
		expected.append(Constants.BLANK_SPACE);
		expected.append(activities.get(1));
		expected.append(Constants.NEW_LINE);
		
		assertTrue(expected.toString().equals(schedule.toString()));
	}
	
	private Activity createActivityData(String name,int duration) {
		Activity activity = new Activity();
		activity.setName(name);
		activity.setDuration(duration);
		activity.setType(name.equals("Lunch Break")?ActitvityType.LUNCH :ActitvityType.NORMAL);
		
		return activity;
	}

}

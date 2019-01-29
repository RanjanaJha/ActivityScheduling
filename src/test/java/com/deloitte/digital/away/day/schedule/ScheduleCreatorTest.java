package com.deloitte.digital.away.day.schedule;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.deloitte.digital.away.day.model.ActitvityType;
import com.deloitte.digital.away.day.model.Activity;
import com.deloitte.digital.away.day.model.Schedule;

public class ScheduleCreatorTest {

	@Test
	public void testGetAllSubsetsOfTheList() {
		
		
		List<Activity> activities = new ArrayList<>();
		activities.add(createActivityData("Duck Herding", 45));
		activities.add(createActivityData("Archery", 60));
		activities.add(createActivityData("Learning Magic Tricks", 45));
		activities.add(createActivityData("Laser Clay Shooting", 60));
		activities.add(createActivityData("Lunch Break", 60));
		
		ScheduleCreator schedule = new ScheduleCreator(activities);
		
		Map<Integer, Schedule> mapOfSchedule = schedule.getMapOfTeamsAndActivities(60,140);
		
		assertNotNull(mapOfSchedule);
		assertTrue(mapOfSchedule.size()>0);
		
	}
	
	private Activity createActivityData(String name,int duration) {
		Activity activity = new Activity();
		activity.setName(name);
		activity.setDuration(duration);
		activity.setType(name.equals("Lunch Break")?ActitvityType.LUNCH :ActitvityType.NORMAL);
		
		return activity;
	}

}

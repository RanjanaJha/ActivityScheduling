package com.deloitte.digital.away.day.schedule;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import org.junit.Test;

import com.deloitte.digital.away.day.model.Schedule;
import com.deloitte.digital.away.day.utils.Constants;
import com.deloitte.digital.away.day.utils.FileReaderUtil;

public class ScheduleCreatorTest {

	@Test
	public void testMapOfTeamsAndActivitiesPositiveCaseWithLessActivities() throws URISyntaxException {

		Path filePath = Paths.get(ClassLoader.getSystemResource("testActivitiesCorrectFile.txt").toURI());
		FileReaderUtil reader = new FileReaderUtil();
		ScheduleCreator schedule = new ScheduleCreator(reader.readFile(filePath));

		Map<Integer, Schedule> mapOfSchedule = schedule.getMapOfTeamsAndActivities(300,330,Constants.START_TIME,Constants.LUNCH_START_RANGE,Constants.LUNCH_END_RANGE,Constants.DATE_FORMAT);

		System.out.println(mapOfSchedule.size());
		assertNotNull(mapOfSchedule);
		assertTrue(mapOfSchedule.size() < (2^8));

	}
	
	@Test
	public void testMapOfTeamsAndActivitiesPositiveCaseWithCompleteActivities() throws URISyntaxException {

		Path filePath = Paths.get(ClassLoader.getSystemResource("testActivities.txt").toURI());
		FileReaderUtil reader = new FileReaderUtil();
		ScheduleCreator schedule = new ScheduleCreator(reader.readFile(filePath));

		Map<Integer, Schedule> mapOfSchedule = schedule.getMapOfTeamsAndActivities(300,330,Constants.START_TIME,Constants.LUNCH_START_RANGE,Constants.LUNCH_END_RANGE,Constants.DATE_FORMAT);

		System.out.println(mapOfSchedule.size());
		assertNotNull(mapOfSchedule);
		assertTrue(mapOfSchedule.size() >0);

	}
}

package com.deloitte.digital.away.day.utils;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import com.deloitte.digital.away.day.exception.SchedulerException;
import com.deloitte.digital.away.day.model.Activity;

public class FileReaderUtilTest {

	@Test
	public void testReadFilePositiveCase() throws URISyntaxException{
		FileReaderUtil reader = new FileReaderUtil();
		Path filePath = Paths.get(ClassLoader.getSystemResource("testActivities.txt").toURI());
		
		List<Activity> activities = reader.readFile(filePath);
		
		assertNotNull(activities);
		assertTrue(activities.size()==21);
		
	}
	
	@Test(expected = SchedulerException.class)
	public void testReadFileNegativeCaseNumberFormat() throws URISyntaxException{
		FileReaderUtil reader = new FileReaderUtil();
		
		Path filePath = Paths.get(ClassLoader.getSystemResource("testActivitiesIncorrectFile1.txt").toURI());
		
		reader.readFile(filePath);
	}
	
	@Test(expected = Exception.class)
	public void testReadFileNegativeCase(){
		FileReaderUtil reader = new FileReaderUtil();
		
		String path = "/DeloitteDigitalAwayDay/src/test/resources/Activities.txt";
		Path filePath = Paths.get(path);
		
		reader.readFile(filePath);
	}
	
	@Test(expected = SchedulerException.class)
	public void testReadFileNegativeCaseIncorrectTimeUnit() throws URISyntaxException{
		FileReaderUtil reader = new FileReaderUtil();
		
		Path filePath = Paths.get(ClassLoader.getSystemResource("testActivitiesIncorrectFile2.txt").toURI());
		
		reader.readFile(filePath);
	}

}

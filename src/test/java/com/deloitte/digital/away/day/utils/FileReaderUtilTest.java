package com.deloitte.digital.away.day.utils;

import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import com.deloitte.digital.away.day.model.Activity;

public class FileReaderUtilTest {

	@Test
	public void testReadFile(){
		FileReaderUtil reader = new FileReaderUtil();
		
		String path = "/DeloitteDigitalAwayDay/src/test/resources/Activities.txt";
		Path filePath = Paths.get(path);
		
		List<Activity> activities = reader.readFile(filePath);
		
		assertNotNull(activities);
		assertTrue(activities.size()==21);
		
	}

}

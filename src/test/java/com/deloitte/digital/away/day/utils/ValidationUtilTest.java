package com.deloitte.digital.away.day.utils;

import static org.junit.Assert.*;

import java.nio.file.Path;
import java.util.Optional;

import org.junit.Test;

import com.deloitte.digital.away.day.exception.SchedulerException;

public class ValidationUtilTest {
	
	@Test(expected = SchedulerException.class)
	public void testCheckFilePathExistsNegativeCaseNullName() {
		Optional<String> fileName = Optional.ofNullable(null);
		ValidationUtil.checkFilePathExists(fileName);
	}
	
	@Test(expected = SchedulerException.class)
	public void testCheckFilePathExistsNegativeCaseEmptyName() {
		Optional<String> fileName = Optional.empty();
		ValidationUtil.checkFilePathExists(fileName);
	}

	@Test(expected = SchedulerException.class)
	public void testCheckFileDoesNotExist() {
		Optional<String> fileName =Optional.of("/DeloitteDigitalAwayDay/src/test/resources/Activities.txt");
		Path filePath = ValidationUtil.checkProperFilePath(fileName);
		assertNotNull(filePath);
	}
	
	@Test(expected = SchedulerException.class)
	public void testCheckProperFilePathNegativeCase() {
		Optional<String> fileName = Optional.of("* \" ?");
		ValidationUtil.checkProperFilePath(fileName);
	}

}

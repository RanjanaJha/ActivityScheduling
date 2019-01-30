package com.deloitte.digital.away.day.utils;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import com.deloitte.digital.away.day.exception.SchedulerException;

/**
 * @author Ranjana Utility Class for Validating Input
 */
public class ValidationUtil {

	/**
	 * @param fileName
	 */
	public static void checkFilePathExists(Optional<String> fileName) {
		if (!fileName.isPresent()) {
			throw new SchedulerException(Constants.SPECIFY_FILE_PATH);
		}
		
	}
	
	public static void checkFileExists(Path fileName) {
		if (!fileName.toFile().exists()) {
			throw new SchedulerException(Constants.FILE_DOES_NOT_EXISTS);
		}
		
	}

	/**
	 * @param activitiesFileName
	 * @return Path filePath
	 */
	public static Path checkProperFilePath(Optional<String> activitiesFileName) {
		Path filePath = null;
		try {
			checkFilePathExists(activitiesFileName);
			filePath = Paths.get(activitiesFileName.get());
			checkFileExists(filePath);
		} catch (InvalidPathException e) {
			throw new SchedulerException(Constants.INVALID_FILE_PATH);
		}
		return filePath;
	}
}

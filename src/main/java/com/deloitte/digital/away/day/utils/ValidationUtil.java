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

	/**
	 * @param activitiesFileName
	 * @return Path filePath
	 */
	public static Path checkProperFilePath(Optional<String> activitiesFileName) {
		Path filePath = null;
		try {
			checkFilePathExists(activitiesFileName);
			filePath = Paths.get(activitiesFileName.get());
		} catch (InvalidPathException e) {
			throw new SchedulerException(Constants.INVALID_FILE_PATH);
		}
		return filePath;
	}
}

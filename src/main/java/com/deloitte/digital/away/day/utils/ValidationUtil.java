package com.deloitte.digital.away.day.utils;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.deloitte.digital.away.day.exception.SchedulerException;

/**
 * @author Ranjana Utility Class for Validating Input
 */
public class ValidationUtil {
	
	private static final Logger log = Logger.getLogger(ValidationUtil.class.getName());
	
	/**
	 * @param fileName
	 */
	public static void checkFilePathExists(Optional<String> fileName) {
		if (!fileName.isPresent()) {
			log.log(Level.SEVERE,Constants.SPECIFY_FILE_PATH,new SchedulerException(Constants.SPECIFY_FILE_PATH));
			throw new SchedulerException(Constants.SPECIFY_FILE_PATH);
		}
		
	}
	
	public static void checkFileExists(Path fileName) {
		if (!fileName.toFile().exists()) {
			log.log(Level.SEVERE,Constants.FILE_DOES_NOT_EXISTS,new SchedulerException(Constants.FILE_DOES_NOT_EXISTS));
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
			log.log(Level.SEVERE,Constants.INVALID_FILE_PATH,new SchedulerException(Constants.INVALID_FILE_PATH));
			throw new SchedulerException(Constants.INVALID_FILE_PATH);
		}
		return filePath;
	}
}

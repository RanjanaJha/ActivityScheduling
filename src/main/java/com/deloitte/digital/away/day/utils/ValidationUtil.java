package com.deloitte.digital.away.day.utils;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.deloitte.digital.away.day.exception.SchedulerException;

public class ValidationUtil {
	
	
	public static void checkFilePathExists(String activitiesFileName) {
		if (activitiesFileName.isEmpty()) {
			throw new SchedulerException(Constants.SPECIFY_FILE_PATH);
		}
	}
	
	
	public static Path checkProperFilePath(String activitiesFileName) {
		Path filePath = null;
		try {
			filePath = Paths.get(activitiesFileName);
		}catch(InvalidPathException e) {
			throw new SchedulerException(Constants.INVALID_FILE_PATH);
		}
		return filePath;
	}
	
/*	public static void checkTeamsExist(String teams){
		if (teams.isEmpty()) {
			throw new SchedulerException(Constants.SPECIFY_TEAM);
		}
	}
	
	public static int checkProperTeam(String teams){
		int teamNumber = 0;
		try {
			teamNumber = Integer.parseInt(teams);
		}catch(NumberFormatException e) {
			throw new SchedulerException(Constants.IMPROPER_TEAM_NUMBER);
		}
		return teamNumber;
	}*/

}

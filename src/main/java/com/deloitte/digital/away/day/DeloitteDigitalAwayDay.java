package com.deloitte.digital.away.day;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.nio.file.Path;
import java.time.Instant;
import java.util.Map;
import java.util.Optional;

import com.deloitte.digital.away.day.model.Schedule;
import com.deloitte.digital.away.day.schedule.ScheduleCreator;
import com.deloitte.digital.away.day.utils.Constants;
import com.deloitte.digital.away.day.utils.FileReaderUtil;
import com.deloitte.digital.away.day.utils.ValidationUtil;

/**
 * @author Ranjana Main class for activity scheduling
 */
public class DeloitteDigitalAwayDay {

	public static void main(String[] args) throws FileNotFoundException {

		// get activities from command line
		final Optional<String> activitiesFileName = Optional.ofNullable(args[0]);

		// verify path is proper
		Path filePath = ValidationUtil.checkProperFilePath(activitiesFileName);

		// Collect activities as list
		// Create Schedule
		FileReaderUtil reader = new FileReaderUtil();
		ScheduleCreator schedule = new ScheduleCreator(reader.readFile(filePath));

		printSchedule(schedule.getMapOfTeamsAndActivities(schedule.getMaxDuration(), schedule.getMinDuration(),
				Constants.START_TIME, Constants.LUNCH_START_RANGE, Constants.LUNCH_END_RANGE, Constants.DATE_FORMAT));

	}

	/**
	 * @param mapOfSchedule
	 * @throws FileNotFoundException
	 */
	private static void printSchedule(Map<Integer, Schedule> mapOfSchedule) throws FileNotFoundException {
		PrintStream out = new PrintStream(new File("schedule_" + Instant.now().getEpochSecond() + ".txt"));
		System.setOut(out);
		mapOfSchedule.forEach((key, value) -> System.out
				.println(Constants.TEAM + key.intValue() + Constants.COLON + Constants.NEW_LINE + value));
	}
}
package com.deloitte.digital.away.day.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.deloitte.digital.away.day.exception.SchedulerException;
import com.deloitte.digital.away.day.model.ActitvityType;
import com.deloitte.digital.away.day.model.Activity;
import com.deloitte.digital.away.day.model.TimeUnit;

public class FileReaderUtil {

	public List<Activity> readFile(Path filePath) {

		List<Activity> activities = new ArrayList<>();

		// read file into a Stream using try-with-resources
		try (Stream<String> fileStream = Files.lines(filePath)) {

			// collect the contents to be read to a list
			List<String> collected = fileStream.collect(Collectors.toList());

			// verify the format of the contents
			verifyFormat(collected);

			// create activity list
			createActivityList(collected, activities);

			// add lunch to the activity list
			addLunchToActivityList(activities);

		} catch (IOException e) {
			throw new SchedulerException(Constants.FILE_READ_ERROR);
		} catch (NumberFormatException e) {
			throw new SchedulerException(Constants.IMPROPER_TIME_FORMAT);
		} catch (Exception e) {
			throw new SchedulerException(Constants.IMPROPER_TIME_FORMAT);
		}

		return activities;
	}

	/**
	 * @param contents
	 * @throws SchedulerException
	 */
	public void verifyFormat(List<String> contents) {
		// loop over the contents to check whether each row ends with SPRINT/MIN
		for (int i = 0; i < contents.size(); i++) {
			contents.set(i, contents.get(i).trim());
			if (!(contents.get(i).endsWith(TimeUnit.MIN.getTimeUnitValue())
					|| contents.get(i).endsWith(TimeUnit.SPRINT.getTimeUnitValue()))) {
				throw new SchedulerException(Constants.IMPROPER_ACTIVITY_FORMAT);
			}

		}
	}

	public void createActivityList(List<String> contents, List<Activity> activities) {
		for (String activity : contents) {
			Activity act = new Activity();
			String name = activity.substring(0, activity.lastIndexOf(Constants.BLANK_SPACE));
			int duration = 0;
			if (activity.endsWith(TimeUnit.SPRINT.getTimeUnitValue())) {
				duration = Constants.SPRINT_VALUE;
			} else {
				duration = Integer.parseInt(activity.substring(activity.lastIndexOf(Constants.BLANK_SPACE) + 1,
						activity.indexOf(TimeUnit.MIN.getTimeUnitValue())));
			}

			act.setName(name);
			act.setDuration(duration);
			act.setType(ActitvityType.NORMAL);

			activities.add(act);
		}
	}

	/**
	 * @param activities
	 */
	public void addLunchToActivityList(List<Activity> activities) {
		// Add lunch break to the activity list
		Activity act = new Activity();
		act.setName(ActitvityType.LUNCH.getActivityType());
		act.setDuration(Constants.LUNCH_TIME);
		act.setType(ActitvityType.LUNCH);

		activities.add(act);
	}
}

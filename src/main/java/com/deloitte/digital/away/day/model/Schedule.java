package com.deloitte.digital.away.day.model;

import java.util.List;

import com.deloitte.digital.away.day.utils.Constants;
import com.deloitte.digital.away.day.utils.TimeOperationUtil;

/**
 * @author Ranjana
 *
 */
public class Schedule {

	private List<Activity> activities;

	public Schedule(List<Activity> activities) {
		this.activities = activities;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	@Override
	public String toString() {

		StringBuffer schedule = new StringBuffer();
		String time = Constants.START_TIME;
		for (Activity activity : activities) {
			schedule.append(time);
			schedule.append(Constants.BLANK_SPACE);
			schedule.append(Constants.COLON);
			schedule.append(Constants.BLANK_SPACE);
			schedule.append(activity);
			schedule.append(Constants.NEW_LINE);
			time = TimeOperationUtil.addMinsToTime(time, activity.getDuration(), Constants.DATE_FORMAT);
		}

		return schedule.toString();
	}
}

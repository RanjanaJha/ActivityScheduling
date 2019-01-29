/**
 * 
 */
package com.deloitte.digital.away.day.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deloitte.digital.away.day.model.ActitvityType;
import com.deloitte.digital.away.day.model.Activity;
import com.deloitte.digital.away.day.model.Schedule;
import com.deloitte.digital.away.day.utils.Constants;
import com.deloitte.digital.away.day.utils.TimeOperationUtil;

/**
 * @author Ranjana
 *
 */
public class ScheduleCreator {

	private final List<Activity> activities;

	private final long maxDuration;

	private final long minDuration;

	private Map<Integer, Schedule> mapOfSchedule = new HashMap<>();

	public ScheduleCreator(List<Activity> activities) {
		this.activities = activities;
		this.maxDuration = TimeOperationUtil.timeDifferenceInMins(Constants.START_TIME, Constants.END_TIME);
		this.minDuration = TimeOperationUtil.timeDifferenceInMins(Constants.START_TIME, Constants.MIN_END_TIME);
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public long getMaxDuration() {
		return maxDuration;
	}

	public long getMinDuration() {
		return minDuration;
	}

	public Map<Integer, Schedule> getMapOfTeamsAndActivities(long maxDuration, long minDuration) {

		List<Activity> activities = this.getActivities();
		List<List<Activity>> subsetOfActivities = new ArrayList<>();
		int size = activities.size();
		int teamCounter = 0;

		// Get all the subsets for the list
		for (int i = 0; i < (1 << size); i++) {
			List<Activity> subset = new ArrayList<>();
			for (int j = 0; j < size; j++) {
				if ((i & (1 << j)) > 0) {
					subset.add(activities.get(j));
				}
			}
			// Filter the subsets based --
			// Total duration is between max duration and min duration
			// Non empty subset
			// subset size > 1
			// subset has lunch as one of the activity
			if (!checkSubsetEmpty(subset) && subset.size() > 1
					&& subsetToBeAddedOrNot(maxDuration, minDuration, subset)) {
				subset.add(createMotivationActivity());
				subsetOfActivities.add(subset);
				mapOfSchedule.put(++teamCounter, new Schedule(subset));
			}
		}

		return mapOfSchedule;
	}

	private boolean subsetToBeAddedOrNot(long maxDuration, long minDuration, List<Activity> subset) {

		int sum = 0;
		boolean isLunchPresent = false;
		boolean subsetToBeAdded = false;

		for (Activity activity : subset) {
			sum = sum + activity.getDuration();
			isLunchPresent = ActitvityType.LUNCH.equals(activity.getType());
		}

		// check if the subset satisfies the following filter
		// Lunch should be a part of the subset &&
		// Combined duration of all the activities should be between the min and max
		// allowed duration
		if (isLunchPresent && sum >= minDuration && sum <= maxDuration) {
			subsetToBeAdded = true;
		}

		return subsetToBeAdded;
	}

	private boolean checkSubsetEmpty(List<Activity> subset) {
		return subset.isEmpty();
	}
	
	private Activity createMotivationActivity() {
		
		Activity act = new Activity();
		act.setName(ActitvityType.MOTIVATION.getActivityType());
		act.setType(ActitvityType.MOTIVATION);

		return act;
	}
}

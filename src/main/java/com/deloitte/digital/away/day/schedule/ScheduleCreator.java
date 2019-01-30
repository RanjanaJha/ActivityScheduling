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
 * @author Ranjana Class for creating schedule
 */
public class ScheduleCreator {

	private final List<Activity> activities;

	private final long maxDuration;

	private final long minDuration;

	private Map<Integer, Schedule> mapOfSchedule = new HashMap<>();

	public ScheduleCreator(List<Activity> activities) {
		this.activities = activities;
		this.maxDuration = TimeOperationUtil.timeDifferenceInMins(Constants.START_TIME, Constants.END_TIME,
				Constants.DATE_FORMAT);
		this.minDuration = TimeOperationUtil.timeDifferenceInMins(Constants.START_TIME, Constants.MIN_END_TIME,
				Constants.DATE_FORMAT);
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

	/**
	 * @param maxDuration
	 * @param minDuration
	 * @param startTime
	 * @param lunchStartRange
	 * @param lunchEndRange
	 * @param dateFormat
	 * @return
	 */
	public Map<Integer, Schedule> getMapOfTeamsAndActivities(long maxDuration, long minDuration, String startTime,
			String lunchStartRange, String lunchEndRange, String dateFormat) {

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
			if (!checkSubsetEmpty(subset) && subset.size() > 1 && subsetToBeAddedOrNot(subset, maxDuration, minDuration,
					startTime, lunchStartRange, lunchEndRange, dateFormat)) {
				subset.add(createMotivationActivity());
				subsetOfActivities.add(subset);
				mapOfSchedule.put(++teamCounter, new Schedule(subset));
			}
		}

		return mapOfSchedule;
	}

	/**
	 * @param subset
	 * @param maxDuration
	 * @param minDuration
	 * @param startTime
	 * @param lunchStartRange
	 * @param lunchEndRange
	 * @param dateFormat
	 * @return
	 */
	private boolean subsetToBeAddedOrNot(List<Activity> subset, long maxDuration, long minDuration, String startTime,
			String lunchStartRange, String lunchEndRange, String dateFormat) {

		int sum = 0;
		boolean isLunchPresent = false;
		boolean subsetToBeAdded = false;
		int indexToSwapLunchWith = -1;
		int lunchIndex = -1;
		int currentIndex = -1;
		long lunchStartDuration = getLunchStartDuration(startTime, lunchStartRange, dateFormat);
		long lunchEndDuration = getLunchEndDuration(startTime, lunchEndRange, dateFormat);

		for (Activity activity : subset) {
			++currentIndex;
			sum = sum + activity.getDuration();
			isLunchPresent = ActitvityType.LUNCH.equals(activity.getType());
			lunchIndex = isLunchPresent ? currentIndex : -1;
			if (sum >= lunchStartDuration && sum <= lunchEndDuration) {
				indexToSwapLunchWith = currentIndex;
			}
		}

		// check if the subset satisfies the following filter
		// Lunch should be a part of the subset &&
		// Combined duration of all the activities should be between the min and max
		// allowed duration
		if (isLunchPresent && sum == maxDuration) {
			Activity other = subset.get(indexToSwapLunchWith);
			subset.set(indexToSwapLunchWith, subset.get(lunchIndex));
			subset.set(lunchIndex, other);
			subsetToBeAdded = true;
		}

		return subsetToBeAdded;
	}

	/**
	 * @param subset
	 * @return
	 */
	private boolean checkSubsetEmpty(List<Activity> subset) {
		return subset.isEmpty();
	}

	/**
	 * @param startTime
	 * @param lunchStartRange
	 * @param dateFormat
	 * @return
	 */
	private long getLunchStartDuration(String startTime, String lunchStartRange, String dateFormat) {
		return TimeOperationUtil.timeDifferenceInMins(startTime, lunchStartRange, dateFormat);
	}

	/**
	 * @param startTime
	 * @param lunchEndRange
	 * @param dateFormat
	 * @return
	 */
	private long getLunchEndDuration(String startTime, String lunchEndRange, String dateFormat) {
		return TimeOperationUtil.timeDifferenceInMins(startTime, lunchEndRange, dateFormat);
	}

	private Activity createMotivationActivity() {

		Activity act = new Activity();
		act.setName(ActitvityType.MOTIVATION.getActivityType());
		act.setType(ActitvityType.MOTIVATION);

		return act;
	}
}

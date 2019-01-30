package com.deloitte.digital.away.day.utils;

/**
 * @author Ranjana
 *
 */
public final class Constants {

	private Constants() {
	}

	public static final int SPRINT_VALUE = 15;
	public static final String DATE_FORMAT = "hh:mm a";
	public static final String START_TIME = "09:00 AM";
	public static final String END_TIME = "05:00 PM";
	public static final String MIN_END_TIME = "04:00 PM";
	public static final String BLANK_SPACE = " ";
	public static final String COLON = ":";
	public static final String NEW_LINE = "\n";
	public static final int LUNCH_TIME = 60;
	public static final String LUNCH_START_RANGE = "11:30 AM";
	public static final String LUNCH_END_RANGE = "01:00 PM";
	public static final String TEAM = "Team";

	public static final String IMPROPER_ACTIVITY_FORMAT = "The list of activities are not in the proper format";
	public static final String FILE_READ_ERROR = "Error while reading file.";
	public static final String IMPROPER_TIME_FORMAT = "The time for each activity shoulde be a number and in mins";
	public static final String SPECIFY_FILE_PATH = "Please specify file path.";
	public static final String INVALID_FILE_PATH = "Please specify proper file path.";
	public static final String SPECIFY_TEAM = "Please specify number of teams.";
	public static final String IMPROPER_TEAM_NUMBER = "Teams should be a number.";
	public static final String TEAMS_VS_SUBSET = "Total number of teams is greater than the possible subsets.";
	public static final String INCORRECT_DATE_FORMAT = "The expected date format is \"hh:mm a\".Please specify the correct format.";
	public static final String INTERNAL_ERROR = "Unexpected Error.";

}

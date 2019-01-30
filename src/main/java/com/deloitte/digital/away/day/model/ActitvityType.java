package com.deloitte.digital.away.day.model;

public enum ActitvityType {

	LUNCH("Lunch Break"), NORMAL("Normal"), MOTIVATION("Staff Motivation Presentation");

	private String activityType;

	public String getActivityType() {
		return activityType;
	}

	private ActitvityType(String activityType) {
		this.activityType = activityType;
	}

}

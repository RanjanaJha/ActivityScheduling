package com.deloitte.digital.away.day.model;

/**
 * @author Ranjana
 *
 */
public class Activity {

	private String name;
	private int duration;
	private ActitvityType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public ActitvityType getType() {
		return type;
	}

	public void setType(ActitvityType type) {
		this.type = type;
	}

	@Override
	public String toString() {

		StringBuffer activity = new StringBuffer();
		activity.append(this.name);
		activity.append(duration == 15 ? " " + TimeUnit.SPRINT : " " + this.duration + TimeUnit.MIN);

		return activity.toString();
	}

}

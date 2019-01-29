/**
 * 
 */
package com.deloitte.digital.away.day.model;

/**
 * @author Ranjana
 *
 */
public enum TimeUnit {
	
	MIN("min"),
	SPRINT("sprint");
	
	private String timeUnitValue;
	
	public String getTimeUnitValue() {
		return timeUnitValue;
	}
	
	private TimeUnit(String timeUnitValue) {
		this.timeUnitValue = timeUnitValue;
	}
}
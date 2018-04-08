package com.onkar.test;

import java.util.HashMap;
import java.util.Map;

// Abstract Base class to instantiate all 
//types of driving modes.
public abstract class AbstractDrivingMode {

	int currentSpeed = 20;
	String currentEventNumber = "0";
	int initialSpeed = 20;
	int emergencyTurboCount = 0;
	Map eventCountMap = initializeEventCounts();

	public abstract String getCurrentEvent();

	public abstract int getCurrentSpeed();

	public abstract String getCurrentMode();

	public abstract Map getDrivingMap();

	public abstract int getEmergencyTurboCount();

	public abstract Map getEventCounts();

	public abstract void setCurrentEventNumber(String eventId);

	public abstract void setCurrentSpeed(int speedValue);

	public abstract void setEmergencyTurboCount(int count);

	public abstract void setEventCount(String eventId, int count);

	public static Map initializeEventCounts() {
		Map<String, Integer> eventCounts = new HashMap<String, Integer>();
		eventCounts.put("1", 0);
		eventCounts.put("2", 0);
		eventCounts.put("3", 0);
		eventCounts.put("4", 0);
		eventCounts.put("5", 0);
		eventCounts.put("6", 0);
		eventCounts.put("7", 0);
		return eventCounts;
	}
}

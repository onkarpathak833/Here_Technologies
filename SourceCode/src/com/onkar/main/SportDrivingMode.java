package com.onkar.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
 * Extends AbstractDrivingMode class
 * And populates properties for 
 * Sport driving modes.
 * 
 * */

public class SportDrivingMode extends AbstractDrivingMode {

	static final String safeDrivingPropertiesFile = "SportDrivingProperties.properties";
	String currentMode = null;
	Map<Object, Object> drivingMap = new HashMap<Object, Object>();
	Properties props = new Properties();
	InputStream input = null;
	Map eventCountMap = null;

	public SportDrivingMode(String mode) {
		super();
		this.currentMode = mode;
		this.eventCountMap = super.eventCountMap;
		try {
			input = SafeDrivingMode.class.getResourceAsStream(safeDrivingPropertiesFile);
			props.load(input);
			this.drivingMap = props;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driving Properties Not foind for Safe Driving Mode.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error Reading Properties file for Safe Driving Mode.");
			e.printStackTrace();
		}
	}

	@Override
	public String getCurrentEvent() {
		// TODO Auto-generated method stub
		return this.currentEventNumber;
	}

	@Override
	public int getCurrentSpeed() {
		// TODO Auto-generated method stub
		return this.currentSpeed;
	}

	@Override
	public String getCurrentMode() {
		// TODO Auto-generated method stub
		return this.currentMode;

	}

	@Override
	public Map getDrivingMap() {
		return this.drivingMap;
	}

	public String getCurrentEventNumber() {
		return currentEventNumber;
	}

	public void setCurrentEventNumber(String currentEventNumber) {
		this.currentEventNumber = currentEventNumber;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	@Override
	public int getEmergencyTurboCount() {
		// TODO Auto-generated method stub
		return this.emergencyTurboCount;
	}

	@Override
	public void setEmergencyTurboCount(int count) {
		// TODO Auto-generated method stub
		this.emergencyTurboCount = count;
	}

	@Override
	public Map getEventCounts() {
		// TODO Auto-generated method stub
		return this.eventCountMap;
	}

	@Override
	public void setEventCount(String eventId, int count) {
		// TODO Auto-generated method stub
		eventCountMap.put(eventId, count);
	}

}

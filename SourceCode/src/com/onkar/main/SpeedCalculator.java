package com.onkar.main;

import java.util.Map;
/*
 * Generic class
 * to do speed calculations
 * for types of driving modes
 * based on their properties and event types
 * */
public class SpeedCalculator {

	private static SpeedCalculator calc = null;

	private SpeedCalculator() {

	}

	public static SpeedCalculator getCalculatorInstance() {
		if (calc == null) {
			return new SpeedCalculator();
		} else {
			return calc;
		}

	}

	public int calculateNextSpeedValue(String incOrDecrease, int currentSpeed, int speedValue) {

		if (incOrDecrease.equals("+")) {
			currentSpeed = currentSpeed + speedValue;
		}
		if (incOrDecrease.equals("-")) {
			currentSpeed = currentSpeed - speedValue;
		}

		return currentSpeed;
	}

	public int getNextSpeed(AbstractDrivingMode mode, String eventId) throws Exception {

		int currentSpeed = mode.getCurrentSpeed();
		String currentId = mode.getCurrentEvent();
		Map drivingMap = mode.getDrivingMap();
		int currentTurboCount = mode.getEmergencyTurboCount();
		Map eventCounts = mode.getEventCounts();
		String nextValues = "";
		int speedValue = 0;
		String incOrDecrease = "";
		int nextEventId = Integer.valueOf(eventId);
		mode.setCurrentEventNumber(eventId);
		if (drivingMap.containsKey(eventId)) {
			nextValues = (String) drivingMap.get(eventId);
			speedValue = Integer.valueOf(nextValues.split(",")[0]);
			incOrDecrease = nextValues.split(",")[1];
			if (eventId.equals("2")) {

				if (!currentId.equals("1")) {
					System.out.println("Cannot clear traffic as current mode is not traffic.");
					mode.setCurrentEventNumber(currentId);
					mode.setCurrentSpeed(currentSpeed);
				} else if ((int) eventCounts.get(eventId) == 1) {
					System.out.println("Event cannot be applied more than once unless it is cleared");
				} else {
					currentSpeed = calculateNextSpeedValue(incOrDecrease, currentSpeed, speedValue);
					mode.setEventCount("1", 0);
					mode.setEventCount("2", 1);
					mode.setCurrentEventNumber(eventId);
					mode.setCurrentSpeed(currentSpeed);
				}

			} else if (eventId.equals("4")) {

				if (!currentId.equals("3")) {
					System.out.println("Cannot apply Weather clear as Weather rainy doesnt exist currently.");
					mode.setCurrentEventNumber(currentId);
					mode.setCurrentSpeed(currentSpeed);
				} else if ((int) eventCounts.get(eventId) == 1) {
					System.out.println("Event cannot be applied more than once unless it is cleared");
				} else {
					currentSpeed = calculateNextSpeedValue(incOrDecrease, currentSpeed, speedValue);
					mode.setEventCount("4", 1);
					mode.setEventCount("3", 0);
					mode.setCurrentEventNumber(eventId);
					mode.setCurrentSpeed(currentSpeed);
				}
			} else if (eventId.equals("6") && !currentId.equals("5")) {

				if (!currentId.equals("5")) {
					System.out.println("Cannot apply Slippery Clear road as Slippery Road doesnt exist currently.");
					mode.setCurrentEventNumber(currentId);
					mode.setCurrentSpeed(currentSpeed);
				} else if ((int) eventCounts.get(eventId) == 1) {
					System.out.println("Event cannot be applied more than once unless it is cleared");
				} else {
					currentSpeed = calculateNextSpeedValue(incOrDecrease, currentSpeed, speedValue);
					mode.setEventCount("6", 1);
					mode.setEventCount("5", 0);
					mode.setCurrentEventNumber(eventId);
					mode.setCurrentSpeed(currentSpeed);
				}

			} else if (eventId.equals("7") && currentId.equals("5")) {
				System.out.println("Emergency Turbo cannot be applied on Slippery Road.");
				mode.setCurrentEventNumber(currentId);
				mode.setCurrentSpeed(currentSpeed);
			} else if (eventId.equals("10")) {
				mode.setEmergencyTurboCount(0);
				currentSpeed = calculateNextSpeedValue(incOrDecrease, currentSpeed, speedValue);
				mode.setCurrentEventNumber(eventId);
				mode.setCurrentSpeed(currentSpeed);

			}

			else if (eventId.equals("7") && currentTurboCount == 1) {
				System.out.println("Emergency Turbo Cannot be applied more than once.");
				mode.setCurrentEventNumber(eventId);
				mode.setCurrentSpeed(currentSpeed);

			} else if (eventId.equals("7") && currentTurboCount == 0) {
				mode.setEmergencyTurboCount(1);
				currentSpeed = calculateNextSpeedValue(incOrDecrease, currentSpeed, speedValue);
				mode.setCurrentEventNumber(eventId);
				mode.setCurrentSpeed(currentSpeed);

			} else {
				if ((int) eventCounts.get(eventId) == 0) {

					currentSpeed = calculateNextSpeedValue(incOrDecrease, currentSpeed, speedValue);
					mode.setEventCount(eventId, 1);
					mode.setCurrentEventNumber(eventId);
					mode.setCurrentSpeed(currentSpeed);
				}

			}
		} else if (nextEventId > 10 && nextEventId <= 100) {
			nextValues = (String) drivingMap.get("10");
			speedValue = Integer.valueOf(nextValues.split(",")[0]);
			incOrDecrease = nextValues.split(",")[1];
			mode.setCurrentEventNumber(eventId);
			currentSpeed = calculateNextSpeedValue(incOrDecrease, nextEventId, speedValue);
			mode.setCurrentEventNumber(eventId);
			mode.setCurrentSpeed(currentSpeed);
			mode.setEmergencyTurboCount(0);
		} else if (nextEventId > 100) {
			System.out.println("Invalid Event.");
			throw new Exception("Invalid Scenario");
		}

		if (currentSpeed < 10) {
			currentSpeed = 10;
		}

		return currentSpeed;
	}

}

package com.onkar.main;

// Factory class to generate all required objects.
public class DrivingModeFactory {

	public static AbstractDrivingMode getDrivingMode(String mode) {

		if (mode.equalsIgnoreCase("SAFE")) {
			return new SafeDrivingMode(mode);
		} else if (mode.equalsIgnoreCase("SPORT")) {
			return new SportDrivingMode(mode);
		} else if (mode.equalsIgnoreCase("NORMAL")) {
			return new NormalDrivingMode(mode);
		}

		return null;
	}

	public static SpeedCalculator getCalculatorInstance() {
		return SpeedCalculator.getCalculatorInstance();
	}

}

package com.onkar.test;

import java.util.Scanner;


/*
 * Controller 
 * class for Driving Simulator
 * Make use of Factory classes to generate generic objects
 * Makes use of singleton SpeedCalculator class
 * to do calculations for all types of driving modes
 * */
public class DrivingSimulator {
	SpeedCalculator calculator = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Driving Simulator.");
		System.out.println("Enter the driving mode : ");
		Scanner sc = new Scanner(System.in);
		String drivingModeValue = sc.next();
		System.out.println("Autonomous Driving Mode : " + drivingModeValue);
		try {
			AbstractDrivingMode drivingMode = DrivingModeFactory.getDrivingMode(drivingModeValue);
			if (drivingMode != null) {
				System.out.println("Started with speed : " + drivingMode.getCurrentSpeed());
			}
			while (true) {
				System.out.println("Enter Event ID :");
				String eventId = sc.next();
				try {
					System.out.println("Current Speed : "
							+ DrivingModeFactory.getCalculatorInstance().getNextSpeed(drivingMode, eventId));
				} catch (Exception e) {
					System.out.println(e);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

}

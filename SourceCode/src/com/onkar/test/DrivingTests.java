package com.onkar.test;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.onkar.main.AbstractDrivingMode;
import com.onkar.main.DrivingModeFactory;
import com.onkar.main.DrivingSimulator;

public class DrivingTests {
	
	static AbstractDrivingMode mode = null;
	public static String drivingMode = null;
	String eventIDs[] = {"1","2","5","7","10","100","60"};
	int normalModeOutput[] = {10,20,10,10,10,100,60};
	int sportModeOutput[] = {15,20,10,10,10,105,65};
	int safeModeOutput[] = {10,20,10,10,10,95,55};
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//DrivingSimulator simulator = new DrivingSimulator();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		mode = null;
		drivingMode = null;
		System.gc();
	}

	@Before
	public void setUp() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the driving mode : ");
		 drivingMode = sc.next();
		 mode = DrivingModeFactory.getDrivingMode(drivingMode);
		
	}

	@Test
	public void testGetNextSpeed() {
		int outputArray[] = new int[eventIDs.length];
		for(int i=0;i<eventIDs.length;i++){
			
			try {
				int nextSpeed = DrivingModeFactory.getCalculatorInstance().getNextSpeed(mode,eventIDs[i]);
				outputArray[i] = nextSpeed;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("Exception Occurred while calculating next speed for "+mode.getCurrentMode());
			}
			
			//assertArrayEquals(expecteds, actuals);
		}
		
		if(drivingMode.equalsIgnoreCase("normal")){
			assertArrayEquals(normalModeOutput, outputArray);
		}
		else if(drivingMode.equalsIgnoreCase("sport")){
			assertArrayEquals(sportModeOutput, outputArray);
		}
		else if(drivingMode.equalsIgnoreCase("safe")){
			assertArrayEquals(safeModeOutput, outputArray);
		}
		
	}

}

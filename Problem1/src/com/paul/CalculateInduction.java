package com.paul;

import java.lang.Math;
import javax.swing.*;

public class CalculateInduction extends Object {
	
	
	private static double MAGNETIC_FIELD_CONSTANT = 1.257 * Math.pow(10, -6);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String current = JOptionPane.showInputDialog("Current: ");
		String meterFromAntennae = JOptionPane.showInputDialog("Distance from antennae (m):");
		Double currentDbl = Double.parseDouble(current);
		Double meterFromAntennaeDbl = Double.parseDouble(meterFromAntennae);
		System.out.println(getInduction(currentDbl, meterFromAntennaeDbl));
	}
	
	/**
	 * @param current Measured in amperes
	 * @param distanceFromAntennae Measured in meters.
	 * @return double 
	 */
	public static double getInduction(double current, double meterFromAntennae) {
		
		double magneticInduction;
		magneticInduction = (MAGNETIC_FIELD_CONSTANT * current) / (2 * Math.PI * meterFromAntennae);
		return magneticInduction;
	}

}

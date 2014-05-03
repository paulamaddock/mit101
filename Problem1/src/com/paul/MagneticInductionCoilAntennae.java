package com.paul;

import javax.swing.JOptionPane;

public class MagneticInductionCoilAntennae {

	private static double MAGNETIC_FIELD_CONSTANT = 1.257 * Math.pow(10, -6);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String current = JOptionPane.showInputDialog("Current: ");
		String numberOfWindings = JOptionPane.showInputDialog("Number of Windings: ");
		String radius = JOptionPane.showInputDialog("Coil Radius (m): ");
		String meterFromCenterCoil = JOptionPane.showInputDialog("Distance from center coil (m):");
		Double radiusDbl = Double.parseDouble(radius);
		Double numberOfWindingsDbl = Double.parseDouble(numberOfWindings);
		Double currentDbl = Double.parseDouble(current);
		Double meterFromCenterCoilDbl = Double.parseDouble(meterFromCenterCoil);
		System.out.println(getInduction(currentDbl, meterFromCenterCoilDbl, radiusDbl, numberOfWindingsDbl));
	}
	
	/**
	 * 
	 * @param current
	 * @param meterFromCenterCoil
	 * @param radius
	 * @param numberOfWindings
	 * @return magneticInduction
	 */
	public static double getInduction(double current, double meterFromCenterCoil, double radius, double numberOfWindings) {
	
		double magneticInduction;
		magneticInduction = ((MAGNETIC_FIELD_CONSTANT * current * numberOfWindings * Math.pow(radius, 2))) / (2 * Math.sqrt(Math.pow(Math.pow(radius, 2) + Math.pow(meterFromCenterCoil, 2), 3)));
		return magneticInduction;
	}

}

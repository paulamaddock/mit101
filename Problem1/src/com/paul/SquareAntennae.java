package com.paul;

import javax.swing.JOptionPane;

public class SquareAntennae {

	private static double MAGNETIC_FIELD_CONSTANT = 1.257 * Math.pow(10, -6);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String current = JOptionPane.showInputDialog("Current: ");
		String numberOfWindings = JOptionPane.showInputDialog("Number of Windings: ");
		String width = JOptionPane.showInputDialog("Coil width (m): ");
		String height = JOptionPane.showInputDialog("Coil height (m): ");
		String distanceFromAntennae = JOptionPane.showInputDialog("Distance from antennae (m):");
		
		Double widthDbl = Double.parseDouble(width);
		Double heightDbl = Double.parseDouble(height);
		Double numberOfWindingsDbl = Double.parseDouble(numberOfWindings);
		Double currentDbl = Double.parseDouble(current);
		Double distanceFromAntennaeDbl = Double.parseDouble(distanceFromAntennae);
		System.out.println(getInduction(currentDbl, distanceFromAntennaeDbl, widthDbl, heightDbl, numberOfWindingsDbl) + " amperes");
	}
	
	/**
	 * 
	 * @param current
	 * @param distanceFromAntennae
	 * @param width
	 * @param height
	 * @param numberOfWindings
	 * @return
	 */
	public static double getInduction(double current, double distanceFromAntennae, double width, double height, double numberOfWindings) {
	
		double magneticInduction;
		magneticInduction = ((MAGNETIC_FIELD_CONSTANT * current * numberOfWindings * width * height ) / 
				(4 * Math.PI * Math.sqrt( Math.pow(width/2, 2) + Math.pow(height/2, 2) + Math.pow(distanceFromAntennae, 2)) 
				* ((1 / Math.pow(height/2, 2) + Math.pow(distanceFromAntennae, 2)) + (1 / Math.pow(width/2, 2) + Math.pow(distanceFromAntennae, 2)))));
		return magneticInduction;
	}

}

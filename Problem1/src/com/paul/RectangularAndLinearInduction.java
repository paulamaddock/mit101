package com.paul;

import javax.swing.JOptionPane;

public class RectangularAndLinearInduction {

	private static double MAGNETIC_FIELD_CONSTANT = 1.257 * Math.pow(10, -6);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String distanceBetweenAntennae = JOptionPane.showInputDialog("Distance between Antennae: ");
		Double dimADbl = .3;
		Double dimBDbl = .2;
		Double distanceBetweenAntennaeDbl = Double.parseDouble(distanceBetweenAntennae);
		
		System.out.println(getInduction(distanceBetweenAntennaeDbl, dimADbl, dimBDbl) + " amperes");
	}
	
	/**
	 * 
	 * @param distanceBetweenAntennae
	 * @param dimA
	 * @param dimB
	 * @return
	 */
	public static double getInduction(double distanceBetweenAntennae, double dimA, double dimB) {
	
		double magneticInduction;
		magneticInduction = ((MAGNETIC_FIELD_CONSTANT * dimA) / (2 * Math.PI)) * Math.log( (distanceBetweenAntennae + dimB) / distanceBetweenAntennae);
		return magneticInduction;
	}

}

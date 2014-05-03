import javax.swing.JOptionPane;


public class CoilMutualIndunctance {

	private static double MAGNETIC_FIELD_CONSTANT = 1.257 * Math.pow(10, -6);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String current = JOptionPane.showInputDialog("Current: ");
		String numberOfWindingsA = JOptionPane.showInputDialog("Number of Windings (A): ");
		String radiusA = JOptionPane.showInputDialog("Coil Radius (A) (m): ");
		String numberOfWindingsB = JOptionPane.showInputDialog("Number of Windings (B): ");
		String radiusB = JOptionPane.showInputDialog("Coil Radius (B) (m): ");
		String distanceBetweenCoil = JOptionPane.showInputDialog("Distance between coil antennae (m):");
		
		Double radiusADbl = Double.parseDouble(radiusA);
		Double numberOfWindingsADbl = Double.parseDouble(numberOfWindingsA);
		Double radiusBDbl = Double.parseDouble(radiusB);
		Double numberOfWindingsBDbl = Double.parseDouble(numberOfWindingsB);
		Double currentDbl = Double.parseDouble(current);
		Double distanceBetweenCoilDbl = Double.parseDouble(distanceBetweenCoil);
		
		System.out.println(getInduction(currentDbl,distanceBetweenCoilDbl, radiusADbl, numberOfWindingsADbl, radiusBDbl, numberOfWindingsBDbl) + " amperes");
	}
	
	/**
	 * 
	 * @param current
	 * @param meterFromCenterCoil
	 * @param radius
	 * @param numberOfWindings
	 * @return magneticInduction
	 */
	public static double getInduction(double current, double meterFromCenterCoil, double radiusA, double numberOfWindingsA, double radiusB, double numberOfWindingsB) {
	
		double magneticInduction;
		magneticInduction = ((MAGNETIC_FIELD_CONSTANT * current * numberOfWindingsA * Math.pow(radiusA, 2) * numberOfWindingsB * Math.pow(radiusB, 2) * Math.PI)) / (2 * Math.sqrt(Math.pow(Math.pow(radiusB, 2) + Math.pow(meterFromCenterCoil, 2), 3)));
		return magneticInduction;
	}


}

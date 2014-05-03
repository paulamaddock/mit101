package com.paul;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InductionPrompt extends JFrame implements WindowListener,
		ActionListener {

	String[] antennaeType = { "Linear", "Rectangular", "Coil" };
	JLabel minDistanceLabel = new JLabel(
			"Minimum distance between antennae (m)");
	JLabel maxDistanceLabel = new JLabel(
			"Maximum distance between antennae (m)");
	JTextField minDistanceField = new JTextField(20);
	JTextField maxDistanceField = new JTextField(20);
	JComboBox antennaeTypeCbBx = new JComboBox(antennaeType);
	JTextArea inductionOutput;
	JScrollPane scrollPane;
	JButton calculateInductionButton = new JButton("Calculate");
	JButton clearButton = new JButton("Clear");

	String imgURL = "./img/tower16x16.png";

	Double current = 3.0;
	Double distanceFromAntennae;
	Double width = .3;
	Double height = .4;
	Integer numberOfWindings = 20;
	Double radius = .3;
	Double meterFromCenterCoil = 2.3;
	Integer numberOfWindingsB = 13;
	Double radiusB = .5;

	/**
	 * ""
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InductionPrompt inductionPrompt = new InductionPrompt(
				"Choose the induction type.");
		inductionPrompt.setSize(500, 300);
		inductionPrompt.setVisible(true);

	}

	public InductionPrompt(String title) {
		super(title);
		setLayout(new FlowLayout());
		super.setIconImage(new ImageIcon(imgURL).getImage());
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculateInductionButton.setMnemonic(KeyEvent.VK_C);
		inductionOutput = new JTextArea(10, 20);
		scrollPane = new JScrollPane(inductionOutput);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(450, 110));
		minDistanceLabel.setEnabled(false);
		maxDistanceLabel.setEnabled(false);
		minDistanceField.setEnabled(false);
		maxDistanceField.setEnabled(false);
		inductionOutput.setEditable(false);
		add(minDistanceLabel);
		add(minDistanceField);
		add(maxDistanceLabel);
		add(maxDistanceField);
		add(antennaeTypeCbBx);
		add(calculateInductionButton);
		add(clearButton);
		add(scrollPane, inductionOutput);
		antennaeTypeCbBx.addActionListener(this);
		calculateInductionButton.addActionListener(this);
		clearButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source == antennaeTypeCbBx) {
			String inductionSelection = (String)antennaeTypeCbBx.getSelectedItem();
			
			if  (inductionSelection == "Linear") {
				minDistanceLabel.setEnabled(false);
				minDistanceField.setEnabled(false);
				maxDistanceLabel.setEnabled(false);
				maxDistanceField.setEnabled(false);
			} else {
				minDistanceLabel.setEnabled(true);
				minDistanceField.setEnabled(true);
				maxDistanceLabel.setEnabled(true);
				maxDistanceField.setEnabled(true);
			} 
		}
		
		if (source == calculateInductionButton) {
			String inductionSelection = (String)antennaeTypeCbBx.getSelectedItem();
			
			String output;
			if  (inductionSelection == "Linear") {
				output = String.valueOf(CalculateInduction.getInduction(current, 2.0));
				inductionOutput.append("Linear Antenna: " + output + " mA\n");
			} else if (inductionSelection == "Coil"){
				if (minDistanceField.getText().length() == 0 || maxDistanceField.getText().length() == 0){
					JOptionPane.showMessageDialog(this, "Min distance must be a decimal point number.");
				} else {
					Double minDistance = Double.parseDouble(minDistanceField.getText());
					Double maxDistance = Double.parseDouble(maxDistanceField.getText());
					Double distanceIncrement = .05;
					System.out.print("Here");
					for ( Double distance = minDistance; distance < maxDistance; distance += distanceIncrement) {
						System.out.print("Here");
						output = String.valueOf(MagneticInductionCoilAntennae.getInduction(current, meterFromCenterCoil, radius, numberOfWindings));
						inductionOutput.append(distance + " m: \n");
						inductionOutput.append("Single: " + output + " mA...\n");
						output = String.valueOf(CoilMutualIndunctance.getInduction(current, distance, radius, numberOfWindings, radiusB, numberOfWindingsB));
						inductionOutput.append("Mutual: " + output + " mA...\n");
					}
				}
			} else {
				if (minDistanceField.getText().length() == 0 || maxDistanceField.getText().length() == 0){
					JOptionPane.showMessageDialog(this, "Min distance must be a decimal point number.");
				} else if ( Double.parseDouble(minDistanceField.getText()) < 0 || Double.parseDouble(maxDistanceField.getText()) < 0){
					JOptionPane.showMessageDialog(this, "You entered a negative number for a distance field. Distance fields must be positive.");
				} else {
					Double minDistance = Double.parseDouble(minDistanceField.getText());
					Double maxDistance = Double.parseDouble(maxDistanceField.getText());
					Double distanceIncrement = .05;
					for ( Double distance = minDistance; distance < maxDistance; distance += distanceIncrement) {
						output = String.valueOf(SquareAntennae.getInduction(current, distance, width, height, numberOfWindings));
						inductionOutput.append(distance + " m: \n");
						inductionOutput.append("Single: " + output + " mA...\n");
						output = String.valueOf(RectangularAndLinearInduction.getInduction(distance, width, height));
						inductionOutput.append("Mutual: " + output + " mA...\n");
					}
				}
			}
		}
		
		if (source == clearButton){
			inductionOutput.setText("");
		}
	}

	public void windowClosing(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

}

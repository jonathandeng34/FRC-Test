package edu.wpi.first.wpilibj;

/*
 *  This file is part of frcjcss.
 *
 *  frcjcss is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  frcjcss is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with frcjcss.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

import frctest.EmulatorMain;

/**
 * FRC Servo simulation.
 * @author Nick DiRienzo
 * @version 11.23.2010.0
 */
public class Servo {
	//TODO: Implement angle. The servo angle is linear to the PWM value (assumed by FIRST).
	//			Check the Servo FRC documentation regarding angles.
	
	private double position;
	
	private JFrame frame;
	private JLabel posLabel;
	
	public Servo(int channel) {
		position = 0;
		
		if(EmulatorMain.enableGUI)
		{
			frame = new JFrame("Servo Simulator: " + channel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setPreferredSize(new Dimension(300, 100));
			frame.setLayout(new BorderLayout());
	        frame.setIconImage(EmulatorMain.appIcon);
			
			posLabel = new JLabel("Position: " + position);
			frame.add(posLabel, BorderLayout.NORTH);
			
			frame.pack();
			frame.setVisible(true);
		}
	}
	
	/**
	 * Sets the position. Position ranges from 0.0 (full left) to 1.0 (full right).
	 * @param value Position ranging from 0.0 to 1.0.
	 */
	public void set(double value) {
		position = limit(value);
		
		if(EmulatorMain.enableGUI)
		{
			posLabel.setText("Position: " + position); 
		}
	}
	
	/**
	 * Gets the position.
	 */
	public double get() {
		return position;
	}
	
	/**
	 * Limits to 0 and 1.0.
	 * @param value The value that needs to be limited.
	 * @return The limited value if greater than 1.0 or less than 0, otherwise the original value.
	 */
	private double limit(double value) {
		if(value > 1.0) {
			value = 1.0;
		}
		else if(value < 0) {
			value = 0;
		}
		return value;
	}
	
	  /**
	   * Get the servo angle.
	   *
	   * Assume that the servo angle is linear with respect to the PWM value (big
	   * assumption, need to test).
	   *$
	   * @return The angle in degrees to which the servo is set.
	   */
	public double getAngle()
	{
		return position * 180;
	}
	
	  /**
	   * Set the servo angle.
	   *
	   * Assume that the servo angle is linear with respect to the PWM value (big
	   * assumption, need to test).
	   *
	   * Servo angles that are out of the supported range of the servo simply
	   * "saturate" in that direction In other words, if the servo has a range of (X
	   * degrees to Y degrees) than angles of less than X result in an angle of X
	   * being set and angles of more than Y degrees result in an angle of Y being
	   * set.
	   *
	   * @param degrees The angle in degrees to set the servo.
	   */
	public void setAngle(double angle)
	{
		set(angle / 180.0);
	}
}

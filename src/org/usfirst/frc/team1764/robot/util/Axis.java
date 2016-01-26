package org.usfirst.frc.team1764.robot.util;

import edu.wpi.first.wpilibj.Joystick;

public class Axis {
	protected final Joystick joystick;
	protected final int axis;
	
	public Axis(Joystick joystick, int axis) {
		this.joystick = joystick;
		this.axis = axis;
	}
	
	public double getValue() {
		double val = joystick.getRawAxis(axis);
		return val;
	}
}

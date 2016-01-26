package org.usfirst.frc.team1764.robot.util;

import edu.wpi.first.wpilibj.Joystick;

public class ExponentialAxis extends Axis {

	public ExponentialAxis(Joystick joystick, int axis) {
		super(joystick, axis);
	}
	
	@Override
	public double getValue() {
		double val = joystick.getRawAxis(axis);
		return (0.5 * Math.pow(val, 3)) + (0.5 * val);
	}

}

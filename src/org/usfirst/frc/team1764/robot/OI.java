package org.usfirst.frc.team1764.robot;


import org.usfirst.frc.team1764.robot.commands.DriveWithGamepadRightStick;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	Joystick pilotJoy = new Joystick(0);
	
	public static final int GUITAR_BUTTON_ORANGE = 5;
	public static final int GUITAR_BUTTON_BLUE = 4;
	public static final int GUITAR_BUTTON_YELLOW = 3;
	public static final int GUITAR_BUTTON_RED = 2;
	public static final int GUITAR_BUTTON_GREEN = 1;
	public static final int GUITAR_BUTTON_STRUM_DOWN = 6;
	public static final int GUITAR_BUTTON_STRUM_UP = 7;
	public static final int GUITAR_BUTTON_START = 8;
	public static final int GUITAR_BUTTON_SELECT = 9;
	
	public static final int LOGITECH_EXTREME3D_AXIS_X = 0;
	public static final int LOGITECH_EXTREME3D_AXIS_Y = 1;
	public static final int LOGITECH_EXTREME3D_AXIS_Z = 2;
	public static final int LOGITECH_EXTREME3D_AXIS_SLIDER = 3;
	public static final int LOGITECH_EXTREME3D_BUTTON_TRIGGER = 1;
	public static final int LOGITECH_EXTREME3D_BUTTON_THUMB = 2;
	
	public static final int LOGITECH_F510_AXIS_LEFT_STICK_X = 0;
	public static final int LOGITECH_F510_AXIS_LEFT_STICK_Y = 1;
	public static final int LOGITECH_F510_AXIS_RIGHT_STICK_X = 4;
	public static final int LOGITECH_F510_AXIS_RIGHT_STICK_Y = 5;
	public static final int LOGITECH_F510_AXIS_LEFT_TRIGGER = 2;
	public static final int LOGITECH_F510_AXIS_RIGHT_TRIGGER = 3;
	public static final int LOGITECH_F510_BUTTON_A = 1;
	public static final int LOGITECH_F510_BUTTON_B = 2;
	public static final int LOGITECH_F510_BUTTON_X = 3;
	public static final int LOGITECH_F510_BUTTON_Y = 4;
	public static final int LOGITECH_F510_BUTTON_LEFT_BUMPER = 5;
	public static final int LOGITECH_F510_BUTTON_RIGHT_BUMPER = 6;
	public static final int LOGITECH_F510_BUTTON_BACK = 7;
	public static final int LOGITECH_F510_BUTTON_SELECT = 8;
	public static final int LOGITECH_F510_BUTTON_LEFT_CLICK = 9;
	public static final int LOGITECH_F510_BUTTON_RIGHT_CLICK = 10;
	
	public double getPilotAxis(int axis) {
		return pilotJoy.getRawAxis(axis);
	}
	
	public double getPOVAxisX()
	{
		return pilotJoy.getRawAxis(4);
	}
	public double getPOVAxisY()
	{
		return pilotJoy.getRawAxis(5);
		
	}
	
	// NORTH: 0
	// NORTH-EAST: 45
	// EAST: 90
	// SOUTH-EAST: 135
	// SOUTH: 180
	// SOUTH-WEST: 225
	// WEST: 270
	// NORTH-WEST: 315
	
	public int getPOV()
	{
		return pilotJoy.getPOV();
	}
	public boolean getPilotButton(int button) {
		return pilotJoy.getRawButton(button);
	}
}


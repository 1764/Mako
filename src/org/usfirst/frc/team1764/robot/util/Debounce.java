package org.usfirst.frc.team1764.robot.util;

import edu.wpi.first.wpilibj.Joystick;

public class Debounce {
	boolean lastState = false;
	
	final int button;
	final Joystick joystick;
	
	
	public Debounce(Joystick joystick, int button)
	{
		this.joystick = joystick;
		this.button = button;
	}
	
	public void update()
	{
		lastState = joystick.getRawButton(button);
	}
	
	public boolean getValue()
	{
		return lastState;
	}
	
	public boolean getFall()
	{
		if(!joystick.getRawButton(button) && lastState)
		{
			lastState = false;
			return true;
		}
		return false;
	}
	
	public boolean getRise()
	{
		if(!lastState && joystick.getRawButton(button))
		{
			lastState = true;
			return true;
		}
		return false;
	}
	
	public boolean getChange()
	{
		return getFall() || getRise();
	}
}
package org.usfirst.frc.team1764.robot.subsystems;

import org.usfirst.frc.team1764.robot.RobotMap;
import org.usfirst.frc.team1764.robot.commands.DriveTrainIdle;
import org.usfirst.frc.team1764.robot.commands.DriveWithExponentialJoystick;
import org.usfirst.frc.team1764.robot.commands.DriveWithGamepadRightStick;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	
	Talon leftMotor, rightMotor;
	int dir = 1;
	
	public DriveTrain() {
		super();
		leftMotor = new Talon(RobotMap.leftMotorPort);
		rightMotor = new Talon(RobotMap.rightMotorPort);
	}
	
	public void reverse() {
		dir = -dir;
	}
	
	//Setter for left motor speed
	public void setLeft(double speed)
	{
		if(dir > 0) {
			leftMotor.set(speed * (dir));
		} else {
			rightMotor.set(-(speed * dir));
		}
	}
	
	//Setter for right motor speed
	public void setRight(double speed)
	{
		if(dir > 0) {
			rightMotor.set(speed * (-dir));
		} else {
			leftMotor.set(-(speed* (-dir)));
		}
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveTrainIdle());
	}

}

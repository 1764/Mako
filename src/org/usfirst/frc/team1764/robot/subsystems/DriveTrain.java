package org.usfirst.frc.team1764.robot.subsystems;

import org.usfirst.frc.team1764.robot.RobotMap;
import org.usfirst.frc.team1764.robot.commands.DriveTrainIdle;
import org.usfirst.frc.team1764.robot.commands.DriveWithExponentialJoystick;
import org.usfirst.frc.team1764.robot.commands.DriveWithGamepadRightStick;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	
	Talon leftMotor, rightMotor;
	
	public DriveTrain() {
		super();
		leftMotor = new Talon(RobotMap.leftMotorPort);
		rightMotor = new Talon(RobotMap.rightMotorPort);
	}
	
	//Setter for left motor speed
	public void setLeft(double speed)
	{
		leftMotor.set(speed);
	}
	
	//Setter for right motor speed
	public void setRight(double speed)
	{
		rightMotor.set(-speed);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new DriveTrainIdle());
	}

}

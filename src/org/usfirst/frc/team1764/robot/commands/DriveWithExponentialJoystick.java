package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.OI;
import org.usfirst.frc.team1764.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/* 
 * Author: Bobby Plubell
 * This class uses an exponential curve to control the robot 
 * which allows for greater sensitivityin the center of the 
 * joystick and greater speed at the edges.
 * 
*/

public class DriveWithExponentialJoystick extends Command {
	
	
	public DriveWithExponentialJoystick()
	{
		this.requires(Robot.chassis);
	}
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		double joyY = Robot.oi.getPilotAxis(Robot.oi.LOGITECH_EXTREME3D_AXIS_Y);
		double joyZ = Robot.oi.getPilotAxis(Robot.oi.LOGITECH_EXTREME3D_AXIS_Z);
		double a = 0.5;
		
		;;;;;;;  ;;;;;;;  ;;;;;;;  ;;   ;;  ;;;;;;;    ;;; ;;;  ;;;;;;;
		;;;        ;;;    ;;   ;;  ;;   ;;    ;;;      ;; ; ;;  ;;
		;;;;;;;    ;;;    ;;       ;;;;;;;    ;;;      ;; ; ;;  ;;;;;;;
		;;;        ;;;    ;;  ;;;  ;;;;;;;    ;;;      ;;   ;;  ;;;;;;;
		;;;        ;;;    ;;   ;;  ;;   ;;    ;;;      ;;   ;;  ;;
		;;;      ;;;;;;;  ;;;;;;;  ;;   ;;    ;;;      ;;   ;;  ;;;;;;;
		
		//Make joysticks exponential...
		joyZ = curverooni(joyZ, a);
		joyY = curverooni(joyY, a);
		joyZ = joyZ*((-0.3 * Math.abs(joyY)) + 1);
		//Limit twist to 0.5
		joyZ *= 0.5;
		
		//Create and set values for speed of motors
		double left = (joyY) + joyZ;
		double right = (joyY) - joyZ;
		
		// Apply values to motors
		Robot.chassis.setLeft(left);
		Robot.chassis.setRight(right);
	}

	private double curverooni(double joy, double a) {
		return a * Math.pow(joy, 3) + (1-a) * joy;
	}

	@Override
	protected boolean isFinished() {
		//Lasts the entire teleop mode
		return false;
	}

	@Override
	protected void end() {
		//Stop motors if for some reason it finishes
		Robot.chassis.setLeft(0);
		Robot.chassis.setRight(0);
	}

	@Override
	protected void interrupted() {
		//Stop motors if for some reason it is interrupted
		Robot.chassis.setLeft(0);
		Robot.chassis.setRight(0);
	}

}

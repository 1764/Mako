package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithGamepadRightStick extends Command {

    public DriveWithGamepadRightStick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double a = 0.5;
    	double x = Robot.oi.getPilotAxis(Robot.oi.LOGITECH_F510_AXIS_RIGHT_STICK_X);
    	double y = Robot.oi.getPilotAxis(Robot.oi.LOGITECH_F510_AXIS_LEFT_STICK_Y);
    	x = 0.5*((a * Math.pow(x, 3)) + ((1-a) * x));
    	y = a * Math.pow(y, 3) + (1-a) * y;
    	double left =  y + x;
		double right = y - x;
		
		// Apply values to motors
		Robot.chassis.setLeft(left);
		Robot.chassis.setRight(right);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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

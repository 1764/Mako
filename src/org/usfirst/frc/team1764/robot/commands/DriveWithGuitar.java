package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithGuitar extends Command {
	double forward,left,right = 0;

    public DriveWithGuitar() {
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!Robot.oi.getPilotButton(Robot.oi.GUITAR_BUTTON_STRUM_DOWN)) {
    		forward += 0.1;
    	} else if(!Robot.oi.getPilotButton(Robot.oi.GUITAR_BUTTON_STRUM_UP)) {
    		forward -= 0.1;
    	} else {
    		forward = 0;
    	}
    	
    	if(!Robot.oi.getPilotButton(Robot.oi.GUITAR_BUTTON_GREEN)) {
    		if(left < 0.5 && right > -0.5) {
    			left += 0.1;
    			right -= 0.1;
    		}
    	} else if(!Robot.oi.getPilotButton(Robot.oi.GUITAR_BUTTON_RED)) {
    		if(left > -0.5 && right < 0.5) {
    			left -= 0.1;
    			right += 0.1;
    		}
    	} else {
    		left = 0;
    		right = 0;
    	}
    	
    	Robot.chassis.setLeft(forward + left);
    	Robot.chassis.setRight(forward + right);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

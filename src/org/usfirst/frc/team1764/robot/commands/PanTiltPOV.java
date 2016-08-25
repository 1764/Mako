package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PanTiltPOV extends Command {

	
	
    public PanTiltPOV() {
        requires(Robot.panTilt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(Robot.oi.getPilotButton(4))
    	{
    		Robot.panTilt.setPan(0.5);
    		Robot.panTilt.setTilt(0.5);
    	}
    	
    	if(Robot.oi.getPOV() == 0) {
    		Robot.panTilt.setTilt(Robot.panTilt.getTilt()+0.1);
    	} else if(Robot.oi.getPOV() == 180) {
    		Robot.panTilt.setTilt(Robot.panTilt.getTilt()-0.1);
    	}
    	
    	if(Robot.oi.getPOV() == 90) {
    		Robot.panTilt.setPan(Robot.panTilt.getPan()+0.1);
    	} else if(Robot.oi.getPOV()==270) {
    		Robot.panTilt.setPan(Robot.panTilt.getPan()-0.1);
    	}
    	
    	SmartDashboard.putNumber("Pan", Robot.panTilt.getPan());
    	SmartDashboard.putNumber("Tilt", Robot.panTilt.getTilt());
    	SmartDashboard.putNumber("POV", Robot.oi.getPOV());
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

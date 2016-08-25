package org.usfirst.frc.team1764.robot.commands;

import org.usfirst.frc.team1764.robot.Robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CameraStream extends Command {
	CameraServer server;
	
    public CameraStream() {
    	//requires(Robot.cameras);
    }

    protected void initialize() {
    	server = CameraServer.getInstance();
    	server.setQuality(75);
    }

    protected void execute() {
    	//server.setImage(Robot.cameras.getImage());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}

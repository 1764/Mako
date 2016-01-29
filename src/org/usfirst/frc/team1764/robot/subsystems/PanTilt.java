package org.usfirst.frc.team1764.robot.subsystems;

import org.usfirst.frc.team1764.robot.RobotMap;
import org.usfirst.frc.team1764.robot.commands.PanTiltPOV;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PanTilt extends Subsystem {
	
	Servo pan,tilt;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public PanTilt() {
		pan = new Servo(RobotMap.panPort);
		tilt = new Servo(RobotMap.tiltPort);
	}
	
	public void setPan(double panVal) {
		pan.set(panVal);
	}
	
	public void setTilt(double tiltVal) {
		tilt.set(tiltVal);
	}

	public double getPan() {
		return pan.getPosition();
	}
	
	public double getTilt() {
		return tilt.getPosition();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new PanTiltPOV());
    }
}


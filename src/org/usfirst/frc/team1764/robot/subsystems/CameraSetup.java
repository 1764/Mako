package org.usfirst.frc.team1764.robot.subsystems;

import org.usfirst.frc.team1764.robot.commands.CameraStream;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 *
 */
public class CameraSetup extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private static USBCamera front;
	private Image image;
	
	public CameraSetup() {
		super();
		front = new USBCamera("cam0");
		front.openCamera();
		front.setFPS(25);
		front.updateSettings();
		front.startCapture();
		image = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	}
	
	public Image getImage() {
		front.getImage(image);
		return image;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new CameraStream());
    }
}



package org.usfirst.frc.team1764.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1764.robot.commands.DriveWithExponentialJoystick;
import org.usfirst.frc.team1764.robot.commands.DriveWithGamepadRightStick;
import org.usfirst.frc.team1764.robot.subsystems.AccelerometerGyroscope;
import org.usfirst.frc.team1764.robot.subsystems.CameraSetup;
import org.usfirst.frc.team1764.robot.subsystems.DriveTrain;

public class Robot extends IterativeRobot {

	public static DriveTrain chassis;
	public static CameraSetup cameras;
	public static AccelerometerGyroscope acg;
	public static OI oi;

    Command autonomousCommand;
    Command teleopCommand;
    LiveWindow lw;
    SendableChooser controllerChooser;

    public void robotInit() {
		oi = new OI();
		cameras = new CameraSetup();
		chassis = new DriveTrain();
		acg = new AccelerometerGyroscope();
		lw = new LiveWindow();
		//CameraServer.getInstance().startAutomaticCapture("cam0");
		
		controllerChooser = new SendableChooser();
    	controllerChooser.addDefault("Extreme 3D Joystick", new DriveWithExponentialJoystick());
    	controllerChooser.addObject("F510 Gamepad", new DriveWithGamepadRightStick());
    	SmartDashboard.putData("Controller Chooser", controllerChooser);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
        teleopCommand = (Command) controllerChooser.getSelected();
        teleopCommand.start();
    }

    public void disabledInit(){

    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}

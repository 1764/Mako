package org.usfirst.frc.team1764.robot.subsystems;

import org.usfirst.frc.team1764.robot.RobotMap;
import org.usfirst.frc.team1764.robot.commands.AccelerometerPrinter;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

/**
 *
 */
public class AccelerometerGyroscope extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Accelerometer accel = new BuiltInAccelerometer(Accelerometer.Range.k4G);
	private Gyro gyro = new Gyro(RobotMap.gyroPort);
	
    public void initDefaultCommand() {
    	setDefaultCommand(new AccelerometerPrinter());
    }
    
    public double getX() {
    	return accel.getX();
    }
    
    public double getY() {
    	return accel.getY();
    }
    
    public double getZ() {
    	return accel.getZ();
    }
    
    public double getAngle() {
    	//return compFilter();
    	return gyro.getAngle();
    }
    
    public double compFilter()
    {
    	double integAngle = gyro.getAngle();
       	double turnAccel = Math.atan2(getX(), getY()) * 180/Math.PI;
    	
    	integAngle = integAngle * 0.98 + turnAccel * 0.02;
    	
    	return integAngle;
    }
    //knock knock, leadscrew
    public void resetGyro() {
    	gyro.reset();
    }
}



package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.JoystickDrive;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;

/**
 *
 * @author Lauren Dierker and Jessie Adkins
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    //THESE ARE NOT CORRECT PORT NUMBERS!!!
    //they are set to PIMP's #'s
    public Jaguar leftFront = new Jaguar(1);
    public Jaguar leftRear = new Jaguar(2);
    public Jaguar rightFront = new Jaguar(4);
    public Jaguar rightRear = new Jaguar(3);
    
    Encoder testEncoder = new Encoder(RobotMap.testEncoderA, RobotMap.testEncoderB);
    public Gyro gyro = new Gyro(RobotMap.gyro);
    
    public RobotDrive drive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
    
    public DriveTrain(){
        gyro.reset();
        gyro.setSensitivity(0.007);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand( new JoystickDrive());
    }
    
    public double getTestEncoder() {
        return testEncoder.getDistance();
    }
    
    public void startTestEncoder() {
        testEncoder.start();
    }
    
    public double getGyroAngle(){
        return gyro.getAngle();
    }
    
    public void resetGyro(){
        gyro.reset();
    }
}


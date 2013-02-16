
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;


/**
 *
 * @author Lauren Dierker and Jessie Adkins
 */
public class JoystickDrive extends CommandBase {

    Timer timer;
    
    public JoystickDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        driveTrain.startTestEncoder();
        //driveTrain.resetGyro();
        
        //for some reason, when the timer is in use, the joysticks stop actually
        //driving the robot.  I don't know why, but we should remember this
        //for future reference, so we don't screw up a class later on.  
        //timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //Brad Miller things
        //originally, the documentation for mecanumDrive_Cartesian had the parameters listed in the wrong order
        //it seems to be okay now
        //not sure why
        //look into this matter later, might need to change some source code
        driveTrain.drive.mecanumDrive_Cartesian(oi.getSideSpeed(), oi.getForwardSpeed(), oi.getTwistSpeed(), 0);
        
        //System.out.println("Time: " + timer.get() + "miliseconds");
        System.out.println("encoder: " + driveTrain.getTestEncoder());
        System.out.println("gyro: " + driveTrain.getGyroAngle());
        System.out.println("Left Throttle: " + oi.getLeftStickThrottle());
        
        /**
        //forward = leftFront
        //works
        //backward
        
        if(oi.getForwardSpeed() > 0.1){
            driveTrain.leftFront.set(.5);
        }
        
        //backward = leftRear
        //full speed back runs left rear
        //backward
        if(oi.getForwardSpeed() < -0.1){
            driveTrain.leftRear.set(.5);
        }
        
        //twist left = rightFront
        //works
        //backwards 
        if(oi.getTwistSpeed() > 0.1){
            driveTrain.rightFront.set(.5);
        }
        
        //twist right = rightRear
        //works
        //backwards 
        if(oi.getTwistSpeed() < -0.1){
            driveTrain.rightRear.set(.5);
        }
         */
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

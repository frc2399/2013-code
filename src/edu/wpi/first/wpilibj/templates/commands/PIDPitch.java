
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.templates.PIDOutputTranslator;


/**
 * Makes a PID that controls the pitch of the robot.
 * @author Jessie
 */
public class PIDPitch extends CommandBase {

    double angle;
    PIDController controller;
    PIDOutputTranslator translator;
    
    public PIDPitch(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(pitch);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        translator = new PIDOutputTranslator();
        controller = new PIDController(0.0001, 0, 0, pitch.pitchEncoder, translator);
        
        //controller.setSetpoint(pitch.getEncoder() + angle);
        //controller.setPercentTolerance(1);
        
        //THIS IS NOT THE RIGHT RANGE
        //I made it this way so that we would not break the robot
        //we need to test the range of the encoder
        //we need to find where zero is
        //then we can update this input range!
        //controller.setInputRange(0, 1);
        //controller.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //pitch.setSpeed(translator.getValue());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //return controller.onTarget();
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        controller.disable();
        controller.free();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}


package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.templates.PIDOutputTranslator;


/**
 *
 * @author Jessie
 */
public class PIDYawTest extends CommandBase {
    
    PIDController controller;
    PIDOutputTranslator translator;
    double angle;

    public PIDYawTest(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveTrain);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
        translator = new PIDOutputTranslator();
        
        controller = new PIDController((oi.getDriveyStickThrottle() + 1.0) / 20.0, 0, 0, driveTrain.gyro, translator);
        // P = 0.00546875
        controller.setSetpoint(driveTrain.getGyroAngle() + angle);
        controller.setPercentTolerance(1);
        controller.setInputRange(-360, 360);
        controller.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.println("Translator: " + translator.getValue() + "P " + controller.getP());
        
        driveTrain.drive.mecanumDrive_Cartesian(0, 0, -translator.getValue(), 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return controller.onTarget();
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

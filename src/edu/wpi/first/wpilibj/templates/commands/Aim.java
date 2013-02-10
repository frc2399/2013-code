
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.NetworkTableKeyNotDefined;
import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 * @author Lauren Dierker
 */
public class Aim extends CommandBase {
    //measured from ground to top of target
    //These are NOT actually 0!!!
    final double topHeightFromGround = 0;
    final double middleHeightFromGround = 0;
    final double pyramidHeightFromGround = 0;
    
    
    final double topWidth = 0;
    final double middleWidth = 0;
    final double pyramidWidth = 0;
    
    final double topHeight = 0;
    final double middleHeight = 0;
    final double pyramidHeight = 0;
    
    final double cameraHeight = 0;
    

    public Aim() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(pitch);
        requires(vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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

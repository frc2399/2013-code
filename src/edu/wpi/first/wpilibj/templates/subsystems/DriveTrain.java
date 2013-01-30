
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.JoystickDrive;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;

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
    
    public RobotDrive drive = new RobotDrive( leftFront, leftRear, rightFront, rightRear);
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand( new JoystickDrive());
    }
}



package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Pitch extends PIDSubsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Pitch(){
        super(.1, .1, .1);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}



package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.AnalogChannel;

/**
 *
 * @author Jessie
 */
public class Loader extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public Jaguar loadMot1 = new Jaguar(RobotMap.loadMot1);
    public Jaguar loadMot2 = new Jaguar(RobotMap.loadMot2);
    
    public AnalogChannel loadEncoder1 = new AnalogChannel(RobotMap.loadEncoder1);
    public AnalogChannel loadEncoder2 = new AnalogChannel(RobotMap.loadEncoder2);
    
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


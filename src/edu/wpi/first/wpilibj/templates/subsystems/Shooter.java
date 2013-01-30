
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem; 
import edu.wpi.first.wpilibj.Jaguar;

/**
 *
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    //might be correct port #
    //if this fails, ask electrical if it is actually plugged into this port
    //might not be a Jag
    public Jaguar shootMot = new Jaguar(5);

    //not setting a default command at the moment
    //there is no default in 2012 code
    //not sure why, no comments
    //might make never ending things happen!
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setShooterSpeed(double speed){
        shootMot.set(speed);
    }
    
    public double getShooterSpeed(){
        return shootMot.getSpeed();
    }
}


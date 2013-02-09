package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj.templates.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.templates.subsystems.Shooter;
import edu.wpi.first.wpilibj.templates.subsystems.Vision;
import edu.wpi.first.wpilibj.templates.subsystems.Pitch;
import edu.wpi.first.wpilibj.templates.subsystems.Trigger;
import edu.wpi.first.wpilibj.templates.subsystems.Loader1;
import edu.wpi.first.wpilibj.templates.subsystems.Loader2;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Lauren Dierker and Jessie Adkins
 */
public abstract class CommandBase extends Command {
    

    public static OI oi;
    public static DriveTrain driveTrain;
    // Create a single static instance of all of your subsystems
    public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    public static Shooter shooter;
    public static Vision vision;
    public static Pitch pitch;
    public static Trigger trigger;
    public static Loader1 loader1;
    public static Loader2 loader2;
    

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        
        driveTrain = new DriveTrain();
        shooter = new Shooter();
        vision = new Vision();
        pitch = new Pitch();
        trigger = new Trigger();
        loader1 = new Loader1();
        loader2 = new Loader2();

        //leave oi at the bottom and apart from the other initialized things
        //if it is initialized before the subsytems, it throws some null pointer exceptions
        //those are not fun
        //please leave it here
        oi = new OI();
        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}

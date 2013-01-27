
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Lauren Dierker
 */
public class TestVision extends CommandBase {
    
    AxisCamera camera;
    CriteriaCollection cc;
    

    public TestVision() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
        camera = AxisCamera.getInstance();
        
        //I don't thinnk we have to currently set any criteria
        //do we need to set resolution now? We will probably need to for image analysis 
        
        //cc = new CriteriaCollection();
        //cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 20, 400, false);
        //cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 15, 400, false);
        //camera.writeResolution(AxisCamera.ResolutionT.k320x240);
        
        try {
            ColorImage image = camera.getImage();
            
            //we will be using def value this year!
            //probably be using same stuff though
            
            BinaryImage greenThreshold = image.thresholdRGB(0, 187, 189, 255, 0, 225);
            //BinaryImage convexHullImage = greenThreshold.convexHull(false);
            //BinaryImage noSmallParticles = convexHullImage.removeSmallObjects(false, 5);
            //BinaryImage foundParticles = noSmallParticles.particleFilter(cc);

            /* what to do with ParticleAnalysisReport:
             * want center of particles, number of particles
             * we'll just print it for now
             */
            ParticleAnalysisReport[] reports = greenThreshold.getOrderedParticleAnalysisReports();  // get list of results
            System.out.println( reports.toString() );
           
            
            //foundParticles.free();
            //noSmallParticles.free();
            //convexHullImage.free();
            //greenThreshold.free();
            //image.free();

        } catch (AxisCameraException ex) {
        } catch (NIVisionException ex) {
        }

         Timer.delay(0.5);
        
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

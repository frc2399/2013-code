
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
    
    //used in first Dealy
    //set to false during execution
    boolean foo = true;
    
    final double topHeightFromGround = 104.125;
    final double middleHeightFromGround = 88.625;
    final double lowHeightFromground = 19;
    final double pyramidHeightFromGround = 0; //find this later...
    
    
    final double topWidth = 54;
    final double middleWidth = 54;
    final double lowWidth = 29;
    
    final double topHeight = 12;
    final double middleHeight = 21;
    
    final double cameraHeight = 0; //we dont know yet (2.5 feet?)
    
    BinaryImage newFilteredImage;
    
    int i = 0;
    
    
    public TestVision() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        int i = 4;
        
    }
        
   

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        i++;
        System.out.println( "Execute testVision is running.");
        
        camera = AxisCamera.getInstance( "10.23.99.11");
        cc = new CriteriaCollection();
        
        //cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 20, 400, false);
        //cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 15, 400, false);
        cc.addCriteria(MeasurementType.IMAQ_MT_AREA, 500, 65535, false);
        
        //will not work with a lower reolution( 120 x 140?). DO NOT CHANGE
        camera.writeResolution(AxisCamera.ResolutionT.k320x240);
        
        
        //if no delay, then AXIS CAMERA EXCEPTION!!!!
        //DO NOT REMOVE
        //only runs first time through execute
        if( foo){ 
            Timer.delay(5);
        }
        
        Timer.delay(1);
        
        try {
            
            ColorImage image = camera.getImage();
            
            image.write("/newImage" + "h" + ".bmp");
         
            //BinaryImage greenThreshold = image.thresholdRGB(0, 187, 189, 255, 0, 225);
            //BinaryImage convexHullImage = greenThreshold.convexHull(false);
            //BinaryImage noSmallParticles = convexHullImage.removeSmallObjects(false, 5);
            //BinaryImage foundParticles = noSmallParticles.particleFilter(cc);

            //BinaryImage thresholdImage = image.thresholdHSV(160, 255, 3, 250, 45, 255);   // keep only green objects
            //these values were not working in the light 
            
            BinaryImage thresholdImage = image.thresholdRGB(180, 255, 180, 250, 175, 255);    //testing these valus now...
                thresholdImage.write("/threshold" + "h" + ".bmp");
            BinaryImage convexHullImage = thresholdImage.convexHull(false);          // fill in occluded rectangles
                convexHullImage.write("/convexHull" + "h" + ".bmp");
            //BinaryImage noSmallParticles = convexHullImage.removeSmallObjects(true, 2);
               //noSmallParticles.write("/noSmallParticles.bmp");
            BinaryImage filteredImage = convexHullImage.particleFilter(cc);           // filter out small particles
                filteredImage.write("/filteredImage" + "h" + ".bmp");
            newFilteredImage =convexHullImage.particleFilter(cc);
            
            
            //prints out the number of particles (red blobs) it sees after filtering
            //number of particles should be the number of targets in your viewing angle
            int numBlobs = filteredImage.getNumberParticles();
            
            System.out.println( "Number of Particles: " + numBlobs);
            
            //prints out information for each blob found
            for (int i = 0; i < numBlobs; i++) {
                    ParticleAnalysisReport report = filteredImage.getParticleAnalysisReport(i);
                    System.out.println( "Particle Analysis Report for " + i + " blob: " + report.toString() + "\n" + "\n" +
                                        "Bounding Rectangle width for blob " + i + ": " + report.boundingRectWidth + "\n" + "\n" +
                                        "Bounding Rectangle Height for blob " + i + ": " + report.boundingRectHeight + "\n" + "\n" +
                                        "Bounding Rectangle Area for blob " + i + ": "+ report.particleArea + "\n" + "\n");
                    System.out.println( "blob " + i + " is a " + getTargetType(i)  + "\n" + "\n");
            }
            
            

            
            //Always free every image you make!!!!
            
            image.free();
            thresholdImage.free();
            convexHullImage.free();
            filteredImage.free();

        } catch (AxisCameraException ex) {
            ex.printStackTrace();
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }

         Timer.delay(0.5);
        foo = false;
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
    
    String getTargetType(int particle){
            
        String target = "not set";
        try{
            ParticleAnalysisReport report = newFilteredImage.getParticleAnalysisReport(particle);
            
            int blobWidth = report.boundingRectWidth;
            int blobHeight = report.boundingRectHeight;

            
            if(blobWidth/blobHeight > (topWidth/topHeight - 1) && blobWidth/blobHeight < (topWidth/topHeight + 1) ){
                    target = "Top target";
            } else if(blobWidth/blobHeight > (middleWidth/middleHeight - 1) && blobWidth/blobHeight < (middleWidth/middleHeight + 1) ) {
                    target = "Middle Target";
            } else{
                target = "Not Top/Middle";   
            }
        }
        catch(NIVisionException ex) {
            ex.printStackTrace();
        }
        return target;
    
    }
    
    
}

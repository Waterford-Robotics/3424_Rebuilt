package frc.robot.subsystems.Limelight;


//import edu.wpi.first.math.geometry.Pose3d;
//import edu.wpi.first.math.geometry.Rotation3d;
//import edu.wpi.first.math.geometry.Translation3d;
import frc.robot.Constants.VisionConstants;
public class ApriltagHelpers {


public ApriltagHelpers(){
}
public static double targetAngle(){
   double angleUp = VisionConstants.CAMERA_PITCH + LimelightHelpers.getTY(VisionConstants.LimelightName);
   double distance = (VisionConstants.TAG_HEIGHT - VisionConstants.CAMERA_HEIGHT)/Math.tan(angleUp);
   double x_distance = distance * Math.sin(VisionConstants.CAMERA_YAW + LimelightHelpers.getTX(VisionConstants.LimelightName));
   double y_distance = distance * Math.cos(VisionConstants.CAMERA_YAW + LimelightHelpers.getTX(VisionConstants.LimelightName));
   y_distance += 0.6; // account for hub distance
   double targetAngle = Math.atan(x_distance/y_distance);
   return targetAngle;
}
}


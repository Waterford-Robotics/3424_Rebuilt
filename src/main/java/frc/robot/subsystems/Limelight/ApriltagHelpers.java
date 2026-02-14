package frc.robot.subsystems.Limelight;


//import edu.wpi.first.math.geometry.Pose3d;
//import edu.wpi.first.math.geometry.Rotation3d;
//import edu.wpi.first.math.geometry.Translation3d;
import frc.robot.Constants.VisionConstants;
public class ApriltagHelpers {


public ApriltagHelpers(){
}


public static double getTargetAngle(){
   double TY = Math.toRadians(LimelightHelpers.getTY(VisionConstants.LimelightName));
   double TX = Math.toRadians(LimelightHelpers.getTX(VisionConstants.LimelightName));


   // angleup = ty + pitch
   double angleUp = VisionConstants.CAMERA_PITCH + TY;
   // distance = (h2-h1)/tan(ty+pitch) = (h2-h1)/tan(angleup)
   double distance = (VisionConstants.TAG_HEIGHT - VisionConstants.CAMERA_HEIGHT)/Math.tan(angleUp);
   // xd = d sin(yaw + tx)
   double x_distance = distance * Math.sin(VisionConstants.CAMERA_YAW + TX);
   // yd = d cos(yaw + tx)
   double y_distance = distance * Math.cos(VisionConstants.CAMERA_YAW + TX);
   // hub angle = arctan(xd/(yd + 0.6))
   double hubAngle = Math.atan(x_distance/(y_distance + 0.6));
   // target angle = tx - (hubAngle - yaw)
   double targetAngle = TX - (hubAngle - VisionConstants.CAMERA_YAW);
   return targetAngle;
}
}
  
/*     // Hub center is 0.6 meters behind the AprilTag
   private static final double HUB_OFFSET_METERS = 0.6;
   public static Pose3d getHubCenterTarget(Pose3d tagPose) {
       // extract data
       //Converts a Pose3d object to an array of doubles in the format [x, y, z, roll, pitch, yaw].
       //Translation components are in meters, rotation components are in degrees.


       double[] poseArray = LimelightHelpers.pose3dToArray(tagPose);
       // add HUB_OFFSET_METERS to x axis
       poseArray[0] += 0.6;
       // turn back into a pose
       tagPose = LimelightHelpers.toPose3D(poseArray);
       return tagPose;
   }
   // Pose3d tagPose3d = LimelightHelpers.getBotPose3d_wpiBlue(VisionConstants.LimelightName);
   // return getHubCenterTarget(tagPose3d);
   */




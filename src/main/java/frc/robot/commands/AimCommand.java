package frc.robot.commands;
// import edu.wpi.first.hal.ConstantsJNI;
//import edu.wpi.first.math.controller.PIDController; // Not doing PID yet, simple proportional.
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Limelight.LimelightHelpers;
import frc.robot.subsystems.Limelight.ApriltagHelpers;
import frc.robot.Constants;
import frc.robot.Constants.VisionConstants;
import frc.robot.subsystems.SwerveSubsystem;


public class AimCommand extends Command {
 // Makes instances of Stuff
 SwerveSubsystem swerveSubsystem;
 // Timer so it doesn't take 10 years and eventually "times out" if fails too hard
 Timer timer = new Timer();


 //PIDController pidController = new PIDController(Constants.VisionConstants.kP, Constants.VisionConstants.kI, Constants.VisionConstants.kD);
  
 // Valid IDs available for positioning, do more with this later to account for winning auto and timing.
 // On Red Hub Offset: 3, 8, 9, 11,
 // On Red Hub Centered: 2, 4, 5, 10
 // On Blue Hub: 19, 24, 25, 27
 // On Blue Hub Centered: 18, 20, 21, 26
 // do we only want to use the april tags that are exactly centered on the hub?
 int[] validIDs = {2, 4, 5, 10, 18, 20, 21, 26};


 // Checks if the a tag is seen
 boolean sees_tag;


 // Constructor
 public AimCommand(SwerveSubsystem m_swerveSubsystem) {
   // swerveSubsystem is an instance of SwerveSubsystem class, aka an object
   swerveSubsystem = m_swerveSubsystem;
   addRequirements(swerveSubsystem); // Needs swerveSubsystem to run
 }


 // What we do to set up the command
 @Override
 public void initialize() {
   // Adds condition that filters out undesired IDs. Check for the valid colors.
   // depends on auto... on elastic
   LimelightHelpers.SetFiducialIDFiltersOverride(Constants.VisionConstants.LimelightName, validIDs);
   // Checks for TV (if it sees tag)
   sees_tag = LimelightHelpers.getTV(Constants.VisionConstants.LimelightName);
   // Timer Reset
   timer.start();
   timer.reset();
 }


 // Method that returns a double for how fast the robot needs to turn, farther angle from the tag is a faster turn
 private double limelight_rotation() {
   // Proportional multiplier on the X-Offset value. Multiply by -1 because robot is CCW Positive. Scale down to reduce speed
   // setting up the set point and current angle, then turning accordingly
   //pidController.enableContinuousInput(-180, 180);


   //double targetingAngularVelocity = pidController.calculate(LimelightHelpers.getTX(Constants.VisionConstants.LimelightName), 0);
   // use k_turnRate instead as a proportion? What is k_turnRate (part of Swerve Subsystem)?
   // gives this value to the swerve drive to start driving!
   // turnScale is a constant instead of k_turnRate that gives a proportional scaling to the horizontal angle offset
  
   // positive angle = april tag to the right, turn clockwise, negate
   // negative angle = april tag to the left, turn counterclockwise, positive
   //double targetingAngularVelocity = LimelightHelpers.getTX(Constants.VisionConstants.LimelightName) * Constants.VisionConstants.turnScale;
   double targetingAngularVelocity =
   (LimelightHelpers.getTX(Constants.VisionConstants.LimelightName)
   + VisionConstants.CAMERA_YAW
   - ApriltagHelpers.targetAngle())
    * Constants.VisionConstants.turnScale;


   return targetingAngularVelocity;
 }


 private double limelight_drive() {
   // drive is a constant that gives a proportional scaling to the vertical angle offset
   // positive angle = april tag too high = drive backwards, so negate before putting into thing.
   // negative angle = april tag below bot, drive fowards.
   double distancingVelocity = LimelightHelpers.getTY(Constants.VisionConstants.LimelightName) * Constants.VisionConstants.driveScale;
   return distancingVelocity;
 }


 // The actual control
 @Override
 public void execute() {
   // If tags are in view, rotate at a speed proportional to the offset robot relative!
   // passes lambdas for DoubleSuppliers because it is called repeatedly
   if (sees_tag)
   {
     // scales values into speeds.
     // first parameter: X, positive = forward, negative = backward
     // second parameter: Y, positive = left, negative = right
     // third parameter: Angular Rotation, positive = ccw, negative = cw
     // does rotating and driving back simultaneously I guess...
     //swerveSubsystem.driveCommand( () -> limelight_drive(), () -> 0.0, () -> limelight_rotation());
     swerveSubsystem.driveCommand( () -> 0.0, () -> 0.0, () -> limelight_rotation());


   }
   // Otherwise we tell it to quit
   else sees_tag = false;
 }
 // Add stuff we do after to reset here. the thing that happens once at the very end of the command. Either because isFinished or interrupted
 public void end(boolean interrupted) {
 }


 // Are we done yet? Finishes when threshold is reached or if no tag in view or if timer is reached
 @Override
 public boolean isFinished() {
   return (Math.abs(LimelightHelpers.getTX(Constants.VisionConstants.LimelightName)) < Constants.VisionConstants.kAimThreshold
   || !sees_tag || timer.get() > Constants.VisionConstants.timeoutTime);
 }


}







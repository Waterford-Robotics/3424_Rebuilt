// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.XboxController.Button;


public class Constants {

  public static final class ControllerConstants {
    public static final int k_driverControllerPort = 0; // Driver

    public static final int k_intakeWheels = Axis.kRightTrigger.value;
    public static final int k_climbCompress = Button.kB.value; // B
     public static final int k_climbExtend = 7; 
    public static final int k_aimRobot = Button.kX.value; // X
    public static final int k_resetNavX = Button.kStart.value;
    public static final int k_flipOut = Button.kRightBumper.value; // Right Bump // flip out for driver 
    public static final int k_flipIn = Button.kLeftBumper.value; // Left Bump  flip in for driver,
    public static final int k_revShooter = Axis.kRightTrigger.value;
    public static final int k_operatorControllerPort = 1; // Operator
    public static final int k_Xwheels = Button.kBack.value;
  
    public static final int k_revShooterFast = Axis.kLeftTrigger.value;
  }  

  public static final class MotorIDConstants{
    //left shooter
    public static final int k_leftshooterKrakenID = 20;
    public static final int k_rightshooterKrakenID = 21;

    public static final int k_shooterIndexerKrakenID = 30;
    public static final int k_beltFloorKrakenID = 31;
    public static final int k_rollerFloorKrakenID = 32;

    public static final int k_intakeKrakenID = 40;
    public static final int k_flipuutKrakenID = 41;
    

  }

  public static final class ShooterConstants {
    public static final double k_shooterSpeed = 0.7;

  }

  public static final class IntakeConstants {
    public static final double k_intakeSpeed = 0.45;
    
  }

  public static final class IndexerConstants {

    public static final double k_beltFloorSpeed = 0.3;
    public static final double k_rollerFloorSpeed = 0.3;
    public static final double k_shooterIndexerSpeed = 0.3;

  }
  
    //limelight
     public static final class VisionConstants{
     public static final String LimelightName = "limelight-three";
     public static final double kP = 1.0;
     public static final double kI = 1.0;
     public static final double kD = 1.0;
     public static final double kAimThreshold = 0.1; // 0.1 radians = 5.7 degrees error is ok
     public static final double timeoutTime = 2.0;
     public static final double turnScale = -0.5; //scale down turn rate and PID
     public static final double driveScale = -0.1;
     public static final double CAMERA_HEIGHT = 0.5; // meters
     public static final double TAG_HEIGHT = 1.12;    // meters, actual measurement for hub.
     public static final double CAMERA_PITCH = 0.785;  // upwards tilt. RADIANS! aka 45 degrees. Update if needed
     public static final double CAMERA_YAW = 0.0; // side tilt. Positive is to the left. RADIANS!
  }
}
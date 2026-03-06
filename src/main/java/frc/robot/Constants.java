// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController.Axis;


public class Constants {
      // Constants for Kraken Drivetrain!
  public static final class SwerveConstants {

    // Must be max physically possible speed
    public static final double k_maxSpeed = edu.wpi.first.math.util.Units.feetToMeters(18.9); // Meters per second
    public static final double k_maxAngularSpeed = 1.5 * Math.PI; // Radians per second

  }

  public static final class ControllerConstants {
    public static final int k_driverControllerPort = 0; // Driver

    public static final int k_intakeWheels = Axis.kLeftTrigger.value;
    public static final int k_climbCompress = 2; // B
     public static final int k_climbExtend = 7; 
    public static final int k_aimRobot = 3; // X
   
    public static final int k_spindexer = Axis.kRightTrigger.value;
    public static final int k_resetNavX = 8;
    public static final int k_flipOut = 5; // Right Bump // flip out for driver 
    public static final int k_flipIn = 6; // Left Bump // flip in for driver,
    public static final int k_revShooter = Axis.kRightTrigger.value;
  }  

  public static final class OperatorConstants {
    public static final int k_operatorControllerPort = 1; // Operator
   
    public static final int k_Xwheels = 8;
    public static final int k_revShooter = Axis.kRightTrigger.value;
  }  

  public static final class DriveConstants{
    public static final double k_driveDeadBand = 0.1;
    public static final double k_driveSpeed = -0.8;
    public static final double k_turnRate = -0.85;
  }


  public static final class MotorConstants{
    public static final int k_supplyCurrentLimit = 40;
    //-->IMPORTANT these constants need testing and are not properly adjusted

    //intake
    public static final int k_intakeKrakenID = 10;
    public static final double k_intakeRampRate = 0.05;
    public static final double k_intakeClosedMaxSpeed = 0.4;
    public static final int k_intakeSupplyCurrentLimit = 60;
    public static final double k_intakeSpeed = -0.5;
    public static final int k_intakePolarity = 1;
   
    //intake flip
    public static final int k_flipKrakenID = 11;
    public static final double k_flipRampRate = 0.05;
    public static final double k_flipClosedMaxSpeed = 0.4;
    public static final int k_flipSupplyCurrentLimit = 60;
    public static final double k_flipSpeed = -0.5;
    public static final int k_flipPolarity = 1;

    //left shooter
    public static final int k_leftshooterKrakenID = 20;
    public static final int k_leftshooterPolarity = 1;

    //right shooter
    public static final int k_rightshooterKrakenID = 21;
    public static final int k_rightshooterPolarity = -1;

    //both shooters
    public static final double k_shooterRampRate = 0.05;
    public static final double k_shooterClosedMaxSpeed = 0.7;
    public static final int k_shooterSupplyCurrentLimit = 60;
    public static final double k_shooterSpeed = 0.6;
    public static final double k_fastShooterSpeed = 1;

    //Blue roller
    public static final int k_shooterRollerKrakenID = 22;
    public static final double k_shooterRollerRampRate = 0.05;
    public static final double k_shooterRollerClosedMaxSpeed = 0.4;
    public static final int k_shooterRollerSupplyCurrentLimit = 60;
    public static final double k_shooterRollerSpeed = 0.31;
    public static final double k_fastShooterRollerSpeed = 0.67;
    public static final int k_shooterRollerPolarity = -1;

    //spindexer
    public static final int k_spindexerKrakenID = 30;
    public static final double k_spindexerRampRate = 0.05;
    public static final double k_spindexerClosedMaxSpeed = 0.4;
    public static final int k_spindexerSupplyCurrentLimit = 60;
    public static final double k_spindexerSpeed = -0.5;
    public static final int k_spindexerPolarity = -1;

    //black roller
    public static final int k_hopperRollerKrakenID = 31; // SET
    public static final double k_hopperRollerRampRate = 0.05;
    public static final double k_hopperRollerClosedMaxSpeed = 0.4;
    public static final int k_hopperRollerSupplyCurrentLimit = 60;
    public static final double k_hopperRollerSpeed = 0.31;
    public static final double k_fastHopperRollerSpeed = 0.67;
    public static final int k_hopperRollerPolarity = -1;
    

    //climber NOT SPECIFIC TO CLIMBER YET 
    public static final int k_climberKrakenID = 40;
    public static final double k_climberRampRate = 0.05;
    public static final double k_climberClosedMaxSpeed = 0.4;
    public static final int k_climberSupplyCurrentLimit = 60;
    public static final double k_climberSpeed = 0.31;
    public static final double k_fastClimberSpeed = 0.67;
    public static final int k_climberPolarity = 1;

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
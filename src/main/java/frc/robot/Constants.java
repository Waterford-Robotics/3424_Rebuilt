// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.XboxController.Button;

public class Constants {
      // Constants for Kraken Drivetrain!
  public static final class SwerveConstants {

    // Must be max physically possible speed
    public static final double k_maxSpeed = edu.wpi.first.math.util.Units.feetToMeters(18.9); // Meters per second
    public static final double k_maxAngularSpeed = 1.5 * Math.PI; // Radians per second

  }

  public static final class ControllerConstants {
    public static final int k_driverControllerPort = 0; // Driver
    public static final int k_operatorControllerPort = 1; // Operator

    // public static final double k_driveDeadband = 0.10; // Increase to combat larger stick drift

    public final static int k_start = Button.kStart.value; // Start Button
    public final static int k_back = Button.kBack.value; // Back Button

    public static final int k_intakeWheels = 1; // A
    public static final int k_climbCompress = 2; // B
    public static final int k_aimRobot = 3; // X
    public static final int k_climbExtend = 4; // Y
    
    public static final int k_dpadup = 0; // D-Pad Up
    public static final int k_dpadRight = 90; // D-Pad Right
    public static final int k_dpadDown = 180; // D-Pad Down
    public static final int k_dpadLeft = 270; // D-Pad Left

    public final static int k_flipOut = 5; // Right Bump
    public final static int k_flipIn = 6; // Left it Bump

    public final static int k_righttrig = Axis.kRightTrigger.value; // Right Trig
    public final static int k_lefttrig = Axis.kLeftTrigger.value; // Left Trig
    public final static int k_resetNavX = 8;
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
    //intake flip
    public static final int k_flipKrakenID = 11;
    public static final double k_flipRampRate = 0.05;
    public static final double k_flipClosedMaxSpeed = 0.4;
    public static final int k_flipSupplyCurrentLimit = 60;
    public static final double k_flipSpeed = -0.5;

    //lower shooter
    public static final int k_lowershooterKrakenID = 20;
    public static final double k_lowershooterRampRate = 0.05;
    public static final double k_lowershooterClosedMaxSpeed = 0.4;
    public static final int k_lowershooterSupplyCurrentLimit = 60;
    public static final double k_lowershooterSpeed = 0.31;
    public static final double k_fastLowerShooterSpeed = 0.67;

    //upper shooter
    public static final int k_uppershooterKrakenID = 21;
    public static final double k_uppershooterRampRate = 0.05;
    public static final double k_uppershooterClosedMaxSpeed = 0.4;
    public static final int k_uppershooterSupplyCurrentLimit = 60;
    public static final double k_uppershooterSpeed = 0.31;
    public static final double k_fastUpperShooterSpeed = 0.67;

    //roller
    public static final int k_rollerKrakenID = 22;
    public static final double k_rollerRampRate = 0.05;
    public static final double k_rollerClosedMaxSpeed = 0.4;
    public static final int k_rollerSupplyCurrentLimit = 60;
    public static final double k_rollerSpeed = 0.31;
    public static final double k_fastRollerSpeed = 0.67;

    //spindexer
    public static final int k_spindexerKrakenID = 30;
    public static final double k_spindexerRampRate = 0.05;
    public static final double k_spindexerClosedMaxSpeed = 0.4;
    public static final int k_spindexerSupplyCurrentLimit = 60;
    public static final double k_spindexerSpeed = -0.5;
    public static final double k_blackRollerSpeed = 0.31;



    //climber NOT SPECIFIC TO CLIMBER YET 
    public static final int k_climberKrakenID = 40;
    public static final double k_climberRampRate = 0.05;
    public static final double k_climberClosedMaxSpeed = 0.4;
    public static final int k_climberSupplyCurrentLimit = 60;
    public static final double k_climberSpeed = 0.31;
    public static final double k_fastClimberSpeed = 0.67;
  }
    //limelight
     public static final class VisionConstants{
     public static final String LimelightName = "limelight-three";
     public static final double kP = 1.0;
     public static final double kI = 1.0;
     public static final double kD = 1.0;
     public static final double kAimThreshold = 1.0;
     public static final double timeoutTime = 2.0;
     public static final double turnScale = -0.05; //scale down turn rate and PID
     public static final double driveScale = -0.1;
     public static final double CAMERA_HEIGHT = 0.254; // meters
     public static final double TAG_HEIGHT = 1.12;    // meters, actual measurement for hub.
     public static final double CAMERA_PITCH = 0.785;  // upwards tilt. RADIANS! aka 45 degrees. Update if needed
     public static final double CAMERA_YAW = 0.0; // side tilt. Positive is to the left. RADIANS!

}
}
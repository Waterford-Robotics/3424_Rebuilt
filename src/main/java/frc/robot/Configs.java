package frc.robot;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.units.Units;


public class Configs {
  public static final class IntakeConfigs {
    // Intake Kraken x44
    public static final TalonFXConfiguration INTAKE_TALON_FX_CONFIGURATION = new TalonFXConfiguration();
    public static final TalonFXConfiguration FLIPOUT_TALON_FX_CONFIGURATION = new TalonFXConfiguration();


    static{
      /*
        ********************************************
        **    INTAKE KRAKEN x44 CONFIGURATIONS    **
        ********************************************
      */

      INTAKE_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = 0.05;
      INTAKE_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle =0.95;
      INTAKE_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -0.95;
      INTAKE_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
      INTAKE_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = 50;

      /*
        ********************************************
        **    INTAKE FLIP KRAKEN x60 CONFIGURATIONS    **
        ********************************************
      */
      FLIPOUT_TALON_FX_CONFIGURATION.Slot0.kP = 0; // how much "push" you have, more push = quicker
      FLIPOUT_TALON_FX_CONFIGURATION.Slot0.kI = 0; // Corrects accumulated error (9.5 goes to 10 with extra push)
      FLIPOUT_TALON_FX_CONFIGURATION.Slot0.kD = 0; // Softens P curve, stops oscillations
      FLIPOUT_TALON_FX_CONFIGURATION.Slot0.kS = 0; // overcomes gearbox static friction
      FLIPOUT_TALON_FX_CONFIGURATION.Slot0.kV = 0; // Helps maintain velocity point
      FLIPOUT_TALON_FX_CONFIGURATION.Slot0.kA = 0; // Helps reach desired acceleration
      FLIPOUT_TALON_FX_CONFIGURATION.Slot0.kG = 0; // helps overcome force of gravity on arm/elevator/etc
      FLIPOUT_TALON_FX_CONFIGURATION.Slot0.GravityType = GravityTypeValue.Arm_Cosine; //knows you are doing arm, could be elevator


      FLIPOUT_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake; // uses reverse current to stop motor immediately 
      FLIPOUT_TALON_FX_CONFIGURATION.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
      FLIPOUT_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = 50;
      FLIPOUT_TALON_FX_CONFIGURATION.SoftwareLimitSwitch.ForwardSoftLimitEnable = true; //Turns on limit!
      FLIPOUT_TALON_FX_CONFIGURATION.SoftwareLimitSwitch.ForwardSoftLimitThreshold = Units.Rotations.of(0).in(Units.Rotations); // Most you can extend
      FLIPOUT_TALON_FX_CONFIGURATION.SoftwareLimitSwitch.ReverseSoftLimitEnable = true; //Virtual hardstop!
      FLIPOUT_TALON_FX_CONFIGURATION.SoftwareLimitSwitch.ReverseSoftLimitThreshold = Units.Rotations.of(0).in(Units.Rotations); // Starting position (should always be 0)
      
      

    }
  }
  
  public static final class ShooterConfigs {
    // Left Shooter Kraken x60
    public static final TalonFXConfiguration SHOOTER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();

    /* 
      ***********************************************
      **  LEFT SHOOTER KRAKEN x60 CONFIGURATIONS  **
      ***********************************************
      */
    static{
      SHOOTER_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = 0.05;
      SHOOTER_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = 0.95;
      SHOOTER_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -0.95;
      SHOOTER_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Coast;
      SHOOTER_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = 60;
    }
  }
  public static final class IndexerConfigs {

    public static final TalonFXConfiguration BELT_FLOOR_TALON_FX_CONFIGURATION = new TalonFXConfiguration();
    public static final TalonFXConfiguration SHOOTER_INDEXER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();
    public static final TalonFXConfiguration ROLLER_FLOOR_TALON_FX_CONFIGURATION = new TalonFXConfiguration();

    /* 
    ***********************************************
    **  BELT_FLOOR x44 CONFIGURATIONS  **
    ***********************************************
    */
    static{
      BELT_FLOOR_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = 0.5;
      BELT_FLOOR_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = 0.95;
      BELT_FLOOR_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -0.95;
      BELT_FLOOR_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
      BELT_FLOOR_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = 50;
      /*
       ********************************************
       **    SHOOTER ROLLER KRAKEN x44 CONFIGURATIONS    **
       ********************************************
      */

      SHOOTER_INDEXER_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = 0.5;
      SHOOTER_INDEXER_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = 0.95;
      SHOOTER_INDEXER_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -0.95;
      SHOOTER_INDEXER_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
      SHOOTER_INDEXER_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = 50;
      /*
        ********************************************
        **    HOPPER ROLLER KRAKEN x44 CONFIGURATIONS    **
        ********************************************
      */

      ROLLER_FLOOR_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = 0.5;
      ROLLER_FLOOR_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = 0.95;
      ROLLER_FLOOR_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -0.95;
      ROLLER_FLOOR_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
      ROLLER_FLOOR_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = 50;
    }
  }
}
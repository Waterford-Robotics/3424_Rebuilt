package frc.robot;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class Configs {

  public static final class IntakeConfigs {

    // Intake Kraken x44
    public static final TalonFXConfiguration INTAKE_TALON_FX_CONFIGURATION = new TalonFXConfiguration();
    public static final TalonFXConfiguration FLIPOUT_TALON_FX_CONFIGURATION = new TalonFXConfiguration();

    static {

      /*
        ********************************************
        **    INTAKE KRAKEN x44 CONFIGURATIONS    **
        ********************************************
      */

      INTAKE_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = 0.05;
      INTAKE_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = 0.95;
      INTAKE_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -0.95;
      INTAKE_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
      INTAKE_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = 50;

      /*
        ********************************************
        **    FLIPOUT KRAKEN x60 CONFIGURATIONS   **
        ********************************************
      */
      // TODO: COOL NEW STUFF!
    }
  }
  
  public static final class ShooterConfigs {

    // Left/Right Shooter Kraken x60
    public static final TalonFXConfiguration SHOOTER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();

    static {

      /* 
       ***********************************************
       **     SHOOTER KRAKEN x60 CONFIGURATIONS     **
       ***********************************************
      */
      SHOOTER_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = 0.05;
      SHOOTER_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = 0.95;
      SHOOTER_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = 0.95;
      SHOOTER_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Coast;
      SHOOTER_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = 60;
    }
  }

  public static final class IndexerConfigs {

    public static final TalonFXConfiguration SHOOTER_INDEXER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();
    public static final TalonFXConfiguration BELT_FLOOR_TALON_FX_CONFIGURATION = new TalonFXConfiguration();
    public static final TalonFXConfiguration ROLLER_FLOOR_TALON_FX_CONFIGURATION = new TalonFXConfiguration();

    static {

      /* 
       ***********************************************
       **       Belt Floor x44 CONFIGURATION        **
       ***********************************************
      */
      BELT_FLOOR_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = 0.05;
      BELT_FLOOR_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = 0.95;
      BELT_FLOOR_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -0.95;
      BELT_FLOOR_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
      BELT_FLOOR_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = 50;
      
      /*
       ********************************************
       **  SHOOTDEXER KRAKEN x44 CONFIGURATION   **
       ********************************************
      */

      SHOOTER_INDEXER_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = 0.05;
      SHOOTER_INDEXER_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = 0.95;
      SHOOTER_INDEXER_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -0.95;
      SHOOTER_INDEXER_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
      SHOOTER_INDEXER_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = 50;

      /*
       ********************************************
       ** ROLLER FLOOR KRAKEN x44 CONFIGURATIONS **
       ********************************************
      */
      ROLLER_FLOOR_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = 0.05;
      ROLLER_FLOOR_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = 0.95;
      ROLLER_FLOOR_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -0.95;
      ROLLER_FLOOR_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
      ROLLER_FLOOR_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = 50;
    }
  }
}
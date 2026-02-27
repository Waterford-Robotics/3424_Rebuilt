package frc.robot;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.NeutralModeValue;


import frc.robot.Constants.MotorConstants;

public class Configs {
  public static final class ClimberConfigs {
    public static final TalonFXConfiguration CLIMBER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();
    static{
    /*
    ********************************************
    **    CLIMBER KRAKEN x60 CONFIGURATIONS    **
    ********************************************
   */
    CLIMBER_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = MotorConstants.k_climberRampRate;
    CLIMBER_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle =MotorConstants.k_climberClosedMaxSpeed;
    CLIMBER_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -MotorConstants.k_climberClosedMaxSpeed;
    CLIMBER_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    CLIMBER_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = MotorConstants.k_climberSupplyCurrentLimit;
    }
  }
  public static final class IntakeConfigs {
    // Intake Kraken x44
    public static final TalonFXConfiguration INTAKE_TALON_FX_CONFIGURATION = new TalonFXConfiguration();
    public static final TalonFXConfiguration FLIP_TALON_FX_CONFIGURATION = new TalonFXConfiguration();
    static{
    /*
      ********************************************
      **    INTAKE KRAKEN x44 CONFIGURATIONS    **
      ********************************************
    */

    INTAKE_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = MotorConstants.k_intakeRampRate;
    INTAKE_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle =MotorConstants.k_intakeClosedMaxSpeed;
    INTAKE_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -MotorConstants.k_intakeClosedMaxSpeed;
    INTAKE_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    INTAKE_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = MotorConstants.k_intakeSupplyCurrentLimit;

    /*
      ********************************************
      **    INTAKE FLIP KRAKEN x44 CONFIGURATIONS    **
      ********************************************
    */
    FLIP_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = MotorConstants.k_flipRampRate;
    FLIP_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = MotorConstants.k_flipClosedMaxSpeed;
    FLIP_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle =-MotorConstants.k_flipClosedMaxSpeed;
    FLIP_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    FLIP_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = MotorConstants.k_flipSupplyCurrentLimit;
  }
}
  
  public static final class ShooterConfigs {
  // Left Shooter Kraken x60
  public static final TalonFXConfiguration LEFTSHOOTER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();

  // Right Shooter Kraken x60
  public static final TalonFXConfiguration RIGHTSHOOTER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();

  /* 
    ***********************************************
    **  LEFT SHOOTER KRAKEN x60 CONFIGURATIONS  **
    ***********************************************
    */
static{
  LEFTSHOOTER_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = MotorConstants.k_shooterRampRate;
  LEFTSHOOTER_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = MotorConstants.k_shooterClosedMaxSpeed;
  LEFTSHOOTER_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -MotorConstants.k_shooterClosedMaxSpeed;
  LEFTSHOOTER_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Coast;
  LEFTSHOOTER_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = MotorConstants.k_shooterSupplyCurrentLimit;

  /* 
    ***********************************************
    **  RIGHT SHOOTER KRAKEN x60 CONFIGURATIONS  **
    ***********************************************
  
*/
  RIGHTSHOOTER_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = MotorConstants.k_shooterRampRate;
  RIGHTSHOOTER_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = MotorConstants.k_shooterClosedMaxSpeed;
  RIGHTSHOOTER_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -MotorConstants.k_shooterClosedMaxSpeed;
  RIGHTSHOOTER_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Coast;
  RIGHTSHOOTER_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = MotorConstants.k_shooterSupplyCurrentLimit; 
}
}
public static final class SpindexerConfigs {

  public static final TalonFXConfiguration SPINDEXER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration SHOOTER_ROLLER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();
  public static final TalonFXConfiguration HOPPER_ROLLER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();

  /* 
    ***********************************************
    **  Spindexer x44 CONFIGURATIONS  **
    ***********************************************
    */
static{
  SPINDEXER_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = MotorConstants.k_spindexerRampRate;
  SPINDEXER_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = MotorConstants.k_spindexerClosedMaxSpeed;
  SPINDEXER_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -MotorConstants.k_spindexerClosedMaxSpeed;
  SPINDEXER_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
  SPINDEXER_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = MotorConstants.k_spindexerSupplyCurrentLimit;
  /*
    ********************************************
    **    SHOOTER ROLLER KRAKEN x44 CONFIGURATIONS    **
    ********************************************
  */

  SHOOTER_ROLLER_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = MotorConstants.k_shooterRollerRampRate;
  SHOOTER_ROLLER_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = MotorConstants.k_shooterRollerClosedMaxSpeed;
  SHOOTER_ROLLER_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -MotorConstants.k_shooterRollerClosedMaxSpeed;
  SHOOTER_ROLLER_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
  SHOOTER_ROLLER_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = MotorConstants.k_shooterRollerSupplyCurrentLimit;
  /*
    ********************************************
    **    HOPPER ROLLER KRAKEN x44 CONFIGURATIONS    **
    ********************************************
  */

  HOPPER_ROLLER_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = MotorConstants.k_hopperRollerRampRate;
  HOPPER_ROLLER_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = MotorConstants.k_hopperRollerClosedMaxSpeed;
  HOPPER_ROLLER_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -MotorConstants.k_hopperRollerClosedMaxSpeed;
  HOPPER_ROLLER_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
  HOPPER_ROLLER_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = MotorConstants.k_hopperRollerSupplyCurrentLimit;
}
}
}
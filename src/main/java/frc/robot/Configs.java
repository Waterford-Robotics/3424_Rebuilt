package frc.robot;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.UpdateModeValue;

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
    public static final TalonFXConfiguration LIFT_TALON_FX_CONFIGURATION = new TalonFXConfiguration();
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
      **    INTAKE LIFT KRAKEN x44 CONFIGURATIONS    **
      ********************************************
    */
    LIFT_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = MotorConstants.k_liftRampRate;
    LIFT_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = MotorConstants.k_liftClosedMaxSpeed;
    LIFT_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle =-MotorConstants.k_liftClosedMaxSpeed;
    LIFT_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    LIFT_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = MotorConstants.k_liftSupplyCurrentLimit;
  }
}
  
  public static final class ShooterConfigs {
  // Lower Shooter Kraken x60
  public static final TalonFXConfiguration LOWERSHOOTER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();

  // Upper Shooter Kraken x60
  public static final TalonFXConfiguration UPPERSHOOTER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();

  // Roller Kraken x44
  public static final TalonFXConfiguration ROLLER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();

  /* 
    ***********************************************
    **  CLIMBER SHOOTER KRAKEN x60 CONFIGURATIONS  **
    ***********************************************
    */
static{
  LOWERSHOOTER_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = MotorConstants.k_lowershooterRampRate;
  LOWERSHOOTER_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = MotorConstants.k_lowershooterClosedMaxSpeed;
  LOWERSHOOTER_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -MotorConstants.k_lowershooterClosedMaxSpeed;
  LOWERSHOOTER_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
  LOWERSHOOTER_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = MotorConstants.k_lowershooterSupplyCurrentLimit;

  /* 
    ***********************************************
    **  UPPER SHOOTER KRAKEN x60 CONFIGURATIONS  **
    ***********************************************
  
*/
  UPPERSHOOTER_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = MotorConstants.k_uppershooterRampRate;
  UPPERSHOOTER_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = MotorConstants.k_uppershooterClosedMaxSpeed;
  UPPERSHOOTER_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -MotorConstants.k_uppershooterClosedMaxSpeed;
  UPPERSHOOTER_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
  UPPERSHOOTER_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = MotorConstants.k_uppershooterSupplyCurrentLimit; 

    /*
    ********************************************
    **    ROLLER KRAKEN x44 CONFIGURATIONS    **
    ********************************************
  */

    ROLLER_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = MotorConstants.k_rollerRampRate;
    ROLLER_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = MotorConstants.k_rollerClosedMaxSpeed;
    ROLLER_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -MotorConstants.k_rollerClosedMaxSpeed;
    ROLLER_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    ROLLER_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = MotorConstants.k_rollerSupplyCurrentLimit;
}
}
public static final class SpindexerConfigs {

  public static final TalonFXConfiguration SPINDEXER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();

  /* 
    ***********************************************
    **  Spindexer x44 CONFIGURATIONS  **
    ***********************************************
    */
static{
  SPINDEXER_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = MotorConstants.k_lowershooterRampRate;
  SPINDEXER_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = MotorConstants.k_lowershooterClosedMaxSpeed;
  SPINDEXER_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -MotorConstants.k_lowershooterClosedMaxSpeed;
  SPINDEXER_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
  SPINDEXER_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = MotorConstants.k_lowershooterSupplyCurrentLimit;
}
}
}
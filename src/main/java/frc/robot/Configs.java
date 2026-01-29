package frc.robot;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.UpdateModeValue;

import frc.robot.Constants.MotorConstants;


public class Configs {
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
    INTAKE_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = MotorConstants.k_intakeClosedMaxSpeed;
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
    LIFT_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -MotorConstants.k_liftClosedMaxSpeed;
    LIFT_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
    LIFT_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = MotorConstants.k_liftSupplyCurrentLimit;
  }
}
  
  public static final class ShootConfigs {
  // Lower Shooter Kraken x60
  public static final TalonFXConfiguration LOWERSHOOTER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();

  // Upper Shooter Kraken x60
  public static final TalonFXConfiguration UPPERSHOOTER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();

  /*
      ***********************************************
      **  LOWER SHOOTER KRAKEN x60 CONFIGURATIONS  **
      ***********************************************
    */

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
  }
  
  public static final class SpindexerConfigs {
    // Bottom Spinner Kraken x44
    public static final TalonFXConfiguration BOTTOMSPINNER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();
  
    // Roller Kraken x44
    public static final TalonFXConfiguration ROLLER_TALON_FX_CONFIGURATION = new TalonFXConfiguration();
  
    /*
        ********************************************
        **  BOTTOM SPINNER KRAKEN x44 CONFIGURATIONS    **
        ********************************************
      */
  
      BOTTOMSPINNER_TALON_FX_CONFIGURATION.ClosedLoopRamps.DutyCycleClosedLoopRampPeriod = MotorConstants.k_bottomspinnerRampRate;
      BOTTOMSPINNER_TALON_FX_CONFIGURATION.MotorOutput.PeakForwardDutyCycle = MotorConstants.k_bottomspinnerClosedMaxSpeed;
      BOTTOMSPINNER_TALON_FX_CONFIGURATION.MotorOutput.PeakReverseDutyCycle = -MotorConstants.k_bottomspinnerClosedMaxSpeed;
      BOTTOMSPINNER_TALON_FX_CONFIGURATION.MotorOutput.NeutralMode = NeutralModeValue.Brake;
      BOTTOMSPINNER_TALON_FX_CONFIGURATION.CurrentLimits.SupplyCurrentLimit = MotorConstants.k_bottomspinnerSupplyCurrentLimit;
  
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
}
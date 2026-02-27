package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.SpindexerConfigs;
import frc.robot.Constants.MotorConstants;

public class SpindexerSubsystem extends SubsystemBase{

  private TalonFX m_spindexer;
  private TalonFX m_shooterRoller;
  private TalonFX m_hopperRoller;

  public SpindexerSubsystem() {
    m_spindexer = new TalonFX(MotorConstants.k_spindexerKrakenID);
    m_spindexer.getConfigurator().apply(SpindexerConfigs.SPINDEXER_TALON_FX_CONFIGURATION, 0.05);
    
    m_shooterRoller = new TalonFX(MotorConstants.k_shooterRollerKrakenID);
    m_shooterRoller.getConfigurator().apply(SpindexerConfigs.SHOOTER_ROLLER_TALON_FX_CONFIGURATION, 0.05);

    m_hopperRoller = new TalonFX(MotorConstants.k_shooterRollerKrakenID);
    m_hopperRoller.getConfigurator().apply(SpindexerConfigs.HOPPER_ROLLER_TALON_FX_CONFIGURATION, 0.05);
  
  }

  public void spindex() {
    m_spindexer.set(MotorConstants.k_spindexerSpeed*MotorConstants.k_spindexerPolarity);  // Starts the spinner
    m_shooterRoller.set(MotorConstants.k_shooterRollerSpeed*MotorConstants.k_shooterRollerPolarity); // feeds the balls into the shooter
    m_hopperRoller.set(MotorConstants.k_hopperRollerSpeed*MotorConstants.k_hopperRollerPolarity); // feeds the balls into the spindexer

  }

  public void stopSpindex() {
    m_spindexer.set(0); // Stops the bottom spinner
    m_shooterRoller.set(0);
    m_hopperRoller.set(0);
  }
}
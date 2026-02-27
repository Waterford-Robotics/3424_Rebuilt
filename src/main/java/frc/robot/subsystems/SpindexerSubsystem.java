package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.ShooterConfigs;
import frc.robot.Configs.SpindexerConfigs;
import frc.robot.Constants.MotorConstants;

public class SpindexerSubsystem extends SubsystemBase{

  private TalonFX m_spindexer;
  private TalonFX m_blueRoller;
  private TalonFX m_blackRoller;

  public SpindexerSubsystem() {
    m_spindexer = new TalonFX(MotorConstants.k_spindexerKrakenID);
    m_spindexer.getConfigurator().apply(SpindexerConfigs.SPINDEXER_TALON_FX_CONFIGURATION, 0.05);
    
    m_blueRoller = new TalonFX(MotorConstants.k_blueRollerKrakenID);
    m_blueRoller.getConfigurator().apply(SpindexerConfigs.BLUEROLLER_TALON_FX_CONFIGURATION, 0.05);

    m_blackRoller = new TalonFX(MotorConstants.k_blueRollerKrakenID);
    m_blackRoller.getConfigurator().apply(SpindexerConfigs.BLACKROLLER_TALON_FX_CONFIGURATION, 0.05);
  
  }

  public void spindex() {
    m_spindexer.set(MotorConstants.k_spindexerSpeed*MotorConstants.k_spindexerPolarity);  // Starts the spinner
    m_blueRoller.set(MotorConstants.k_blueRollerSpeed*MotorConstants.k_blueRollerPolarity); // feeds the balls into the shooter
    m_blackRoller.set(MotorConstants.k_blackRollerSpeed*MotorConstants.k_blackRollerPolarity); // feeds the balls into the spindexer

  }

  public void stopSpindex() {
    m_spindexer.set(0); // Stops the bottom spinner
    m_blueRoller.set(0);
    m_blackRoller.set(0);
  }
}
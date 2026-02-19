package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.ShooterConfigs;
import frc.robot.Configs.SpindexerConfigs;
import frc.robot.Constants.MotorConstants;

public class SpindexerSubsystem extends SubsystemBase{

  private TalonFX m_spindexer;
  private TalonFX m_roller; // roller feeder
  private TalonFX m_blackRoller;

  public SpindexerSubsystem() {
    m_spindexer = new TalonFX(MotorConstants.k_spindexerKrakenID);
    m_spindexer.getConfigurator().apply(SpindexerConfigs.SPINDEXER_TALON_FX_CONFIGURATION, 0.05);
    
    m_roller = new TalonFX(MotorConstants.k_rollerKrakenID);
    m_roller.getConfigurator().apply(ShooterConfigs.ROLLER_TALON_FX_CONFIGURATION, 0.05);

    m_blackRoller = new TalonFX(MotorConstants.k_rollerKrakenID);
    m_blackRoller.getConfigurator().apply(ShooterConfigs.ROLLER_TALON_FX_CONFIGURATION, 0.05);
  
  }

  public void spindex() {
    m_spindexer.set(MotorConstants.k_spindexerSpeed);  // Starts the spinner
    m_roller.set(MotorConstants.k_rollerSpeed); // feeds the balls into the shooter
    m_blackRoller.set(MotorConstants.k_blackRollerSpeed); // feeds the balls into the spindexer

  }

  public void stopSpindex() {
    m_spindexer.set(0); // Stops the bottom spinner
    m_roller.set(0);
    m_blackRoller.set(0);
  }
}
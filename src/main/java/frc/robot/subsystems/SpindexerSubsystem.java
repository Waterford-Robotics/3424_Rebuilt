package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.SpindexerConfigs;
import frc.robot.Constants.MotorConstants;

public class SpindexerSubsystem extends SubsystemBase{

  private TalonFX m_spindexer;

  public SpindexerSubsystem() {
    m_spindexer = new TalonFX(MotorConstants.k_spindexerKrakenID);
    m_spindexer.getConfigurator().apply(SpindexerConfigs.SPINDEXER_TALON_FX_CONFIGURATION, 0.05);
  }

  public void spindex() {
    m_spindexer.set(MotorConstants.k_spindexerSpeed);  // Starts the spinner and roller
  }

  public void stopSpindex() {
    m_spindexer.set(0); // Stops the bottom spinner
  }
}
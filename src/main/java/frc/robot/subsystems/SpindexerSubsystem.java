package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.SpindexerConfigs;
import frc.robot.Constants.MotorConstants;

public class SpindexerSubsystem extends SubsystemBase{

  private TalonFX m_bottomspinner;
  private TalonFX m_roller;

  public SpindexerSubsystem() {
    m_bottomspinner = new TalonFX(MotorConstants.k_spindexerKrakenID);
    m_bottomspinner.getConfigurator().apply(SpindexerConfigs.SPINDEXER_TALON_FX_CONFIGURATION, 0.05);

    m_roller = new TalonFX(MotorConstants.k_rollerKrakenID);
    m_roller.getConfigurator().apply(SpindexerConfigs.SPINDEXER_TALON_FX_CONFIGURATION, 0.05);
  }

  public void spindex() {
    m_bottomspinner.set(MotorConstants.k_bottomspinnerSpeed);  // Starts the spinner and roller
    m_roller.set(MotorConstants.k_rollerSpeed);
  }

  public void stopSpindex() {
    m_bottomspinner.set(0); // Stops the bottom spinner
    m_roller.set(0); //Stops the roller
  }
}
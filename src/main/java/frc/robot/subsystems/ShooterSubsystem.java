package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.ShooterConfigs;
import frc.robot.Constants.MotorConstants;

public class ShooterSubsystem extends SubsystemBase{

  private TalonFX m_lower; // lower shooter
  private TalonFX m_upper; // upper shooter
  private TalonFX m_roller; // roller feeder

  public ShooterSubsystem() {
    m_lower = new TalonFX(MotorConstants.k_lowershooterKrakenID);
    m_lower.getConfigurator().apply(ShooterConfigs.LOWERSHOOTER_TALON_FX_CONFIGURATION, 0.05);

    m_upper = new TalonFX(MotorConstants.k_uppershooterKrakenID);
    m_upper.getConfigurator().apply(ShooterConfigs.UPPERSHOOTER_TALON_FX_CONFIGURATION, 0.05);

    m_roller = new TalonFX(MotorConstants.k_rollerKrakenID);
    m_roller.getConfigurator().apply(ShooterConfigs.ROLLER_TALON_FX_CONFIGURATION, 0.05);
  }

  public void shoot() {
    m_lower.set(MotorConstants.k_lowershooterSpeed);  // Revs up the two shooter motors
    m_upper.set(MotorConstants.k_uppershooterSpeed);
    m_roller.set(MotorConstants.k_rollerSpeed); // feeds the balls in
  }

  public void stopShooting() {
    m_lower.set(0);  // Stops the two shooter motors
    m_upper.set(0);
    m_roller.set(0);
  }
}
package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.ShooterConfigs;
import frc.robot.Constants.MotorIDConstants;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {

  // [Kraken x60] x2
  private TalonFX m_leftShooter;
  private TalonFX m_rightShooter; 

  // Shoot Subsystem
  public ShooterSubsystem() {

    // Shooter Motors
    m_leftShooter = new TalonFX(MotorIDConstants.k_leftshooterKrakenID);
    m_rightShooter = new TalonFX(MotorIDConstants.k_rightshooterKrakenID);

    // Apply Configs
    m_leftShooter.getConfigurator().apply(ShooterConfigs.SHOOTER_TALON_FX_CONFIGURATION, 0.05);
    m_rightShooter.getConfigurator().apply(ShooterConfigs.SHOOTER_TALON_FX_CONFIGURATION, 0.05);
  }

  // Standard Shot
  public void shoot() {
    m_leftShooter.set(ShooterConstants.k_shooterSpeed); 
    m_rightShooter.set(-ShooterConstants.k_shooterSpeed);
  }

  // Stop Shooter
  public void stopShooter() {
    m_leftShooter.set(0); 
    m_rightShooter.set(0);
  }
}
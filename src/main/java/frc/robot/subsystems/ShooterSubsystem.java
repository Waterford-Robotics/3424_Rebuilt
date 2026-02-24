package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.ShooterConfigs;
import frc.robot.Constants.MotorConstants;
import frc.robot.subsystems.Limelight.ApriltagHelpers;

public class ShooterSubsystem extends SubsystemBase{

  private TalonFX m_lower; // lower shooter
  private TalonFX m_upper; // upper shooter

  public ShooterSubsystem() {
    m_lower = new TalonFX(MotorConstants.k_lowershooterKrakenID);
    m_lower.getConfigurator().apply(ShooterConfigs.LOWERSHOOTER_TALON_FX_CONFIGURATION, 0.05);

    m_upper = new TalonFX(MotorConstants.k_uppershooterKrakenID);
    m_upper.getConfigurator().apply(ShooterConfigs.UPPERSHOOTER_TALON_FX_CONFIGURATION, 0.05);
  }

  public void shootHub() {
    m_lower.set(calculateSpeed(ApriltagHelpers.getDistance()) * MotorConstants.k_lowershooterPolarity);  // Revs up the two shooter motors
    m_upper.set(calculateSpeed(ApriltagHelpers.getDistance())* MotorConstants.k_uppershooterPolarity);
  }

  public void shootPass() {
    m_lower.set(MotorConstants.k_lowershooterSpeed * MotorConstants.k_lowershooterPolarity);
    m_upper.set(MotorConstants.k_uppershooterSpeed * MotorConstants.k_uppershooterPolarity);
  }

  public double calculateSpeed(double distance) {
      return(distance*distance/10); // takes in distance, does math, and spits out speed
  }

  public void stopShooting() {
    m_lower.set(0);  // Stops the two shooter motors
    m_upper.set(0);
  }
}
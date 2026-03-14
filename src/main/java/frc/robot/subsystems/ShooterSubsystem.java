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
    m_lower = new TalonFX(MotorConstants.k_leftshooterKrakenID);
    m_lower.getConfigurator().apply(ShooterConfigs.LEFTSHOOTER_TALON_FX_CONFIGURATION, 0.05);

    m_upper = new TalonFX(MotorConstants.k_rightshooterKrakenID);
    m_upper.getConfigurator().apply(ShooterConfigs.RIGHTSHOOTER_TALON_FX_CONFIGURATION, 0.05);
  }

  public void shoot() {
    // if(false){ //TODO: A condition that checks if the limelight is getting good data from an april tag
    //   m_lower.set(calculateSpeed(ApriltagHelpers.getDistance()) * MotorConstants.k_leftshooterPolarity);  // Revs up the two shooter motors
    //   m_upper.set(calculateSpeed(ApriltagHelpers.getDistance())* MotorConstants.k_rightshooterPolarity);
    // }
    // else{
      m_lower.set(MotorConstants.k_shooterSpeed * MotorConstants.k_leftshooterPolarity);  // Revs up the two shooter motors
      m_upper.set(MotorConstants.k_shooterSpeed * MotorConstants.k_rightshooterPolarity);
    // }
  }

  public void far_shoot(){
      m_lower.set(MotorConstants.k_fastShooterSpeed * MotorConstants.k_leftshooterPolarity);  // Revs up the two shooter motors to a faster speed
      m_upper.set(MotorConstants.k_fastShooterSpeed * MotorConstants.k_rightshooterPolarity);
  }

  public double calculateSpeed(double distance) {
      return(distance*distance/10); // takes in distance, does math, and spits out speed
  }

  public void stopShooting() {
    m_lower.set(0);  // Stops the two shooter motors
    m_upper.set(0);
  }
}
package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.IntakeConfigs;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.MotorIDConstants;

public class IntakeSubsystem extends SubsystemBase {

  // [Kraken x44] x1
  private TalonFX m_intake;

  // Intake constructor
  public IntakeSubsystem() {

    // Intake Roller
    m_intake = new TalonFX(MotorIDConstants.k_intakeKrakenID);

    // Apply Configs (yay!)
    m_intake.getConfigurator().apply(IntakeConfigs.INTAKE_TALON_FX_CONFIGURATION, 0.05);
  }

  // Intake!
  public void intake() {
    m_intake.set(-IntakeConstants.k_intakeSpeed);
  }

  // Reverse Intake!
  public void reverseIntake() {
    m_intake.set(IntakeConstants.k_intakeSpeed);
  }

  // Stop!
  public void stopIntake() {
    m_intake.set(0);
  }
}
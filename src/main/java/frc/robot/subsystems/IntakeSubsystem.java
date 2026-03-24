package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.IntakeConfigs;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.MotorIDConstants;

// Clean
public class IntakeSubsystem extends SubsystemBase {

  private TalonFX m_intake; // intake wheel

  public IntakeSubsystem() {
    m_intake = new TalonFX(MotorIDConstants.k_intakeKrakenID);
    m_intake.getConfigurator().apply(IntakeConfigs.INTAKE_TALON_FX_CONFIGURATION, 0.05);
  }


  public void intake() { 
    m_intake.set(-IntakeConstants.k_intakeSpeed);//intake forward
  }


  public void reverseIntake() {
    m_intake.set(IntakeConstants.k_intakeSpeed); //make it run backwards!
  }

  public void stopIntake() {
    m_intake.set(0);
  }
}
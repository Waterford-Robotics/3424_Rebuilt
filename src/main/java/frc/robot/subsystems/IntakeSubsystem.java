package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.IntakeConfigs;
import frc.robot.Constants.MotorConstants;
// Clean
public class IntakeSubsystem extends SubsystemBase{

  private TalonFX m_intake; // intake wheels
  private TalonFX m_flip; // motor to make intake go up and down

  public IntakeSubsystem() {
    m_intake = new TalonFX(MotorConstants.k_intakeKrakenID);
    m_intake.getConfigurator().apply(IntakeConfigs.INTAKE_TALON_FX_CONFIGURATION, 0.05);

    m_flip = new TalonFX(MotorConstants.k_intakeKrakenID);
    m_flip.getConfigurator().apply(IntakeConfigs.FLIP_TALON_FX_CONFIGURATION, 0.05);
  }

  public void intakeCommand(int polarity) { //polarity is 1 or -1
    m_intake.set(MotorConstants.k_intakeSpeed*polarity); //-1 polarity makes motor run backwards
  }

  public void flipCommand(int polarity){
    m_flip.set(MotorConstants.k_flipSpeed*polarity); //-1 polarity makes motor run backwards
  }
  public void stopFlip() {
      m_flip.set(0);
    }

  public void stopIntake() {
    m_intake.set(0);
  }
}
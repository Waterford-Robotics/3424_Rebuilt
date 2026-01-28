import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.IntakeConfigs;
import frc.robot.Constants.MotorConstants;

public class IntakeSubsystem extends SubsystemBase{

  private TalonFX m_intake; // intake wheels
  private TalonFX m_lift; // motor to lift hood

  public IntakeSubsystem() {
    m_intake = new TalonFX(MotorConstants.k_intakeKrakenID);
    m_intake.getConfigurator().apply(IntakeConfigs.INTAKE_TALON_FX_CONFIGURATION, 0.05);

    m_lift = new TalonFX(MotorConstants.k_intakeKrakenID);
    m_lift.getConfigurator().apply(IntakeConfigs.INTAKE_TALON_FX_CONFIGURATION, 0.05);
  }

  public void lift() {
    m_lift.set(MotorConstants.k_intakeSpeed);
  }

  public void intake() {
    m_intake.set(MotorConstants.k_intakeSpeed);
  }

  public void stopLift() {
    m_lift.set(0);
  }

  public void stopIntake() {
    m_intake.set(0);
  }
}
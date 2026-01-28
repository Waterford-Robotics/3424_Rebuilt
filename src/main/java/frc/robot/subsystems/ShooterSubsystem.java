import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.IntakeConfigs;
import frc.robot.Constants.MotorConstants;

public class IntakeSubsystem extends SubsystemBase{

  private TalonFX m_lower;
  private TalonFX m_upper;

  public IntakeSubsystem() {
    m_lower = new TalonFX(MotorConstants.k_intakeKrakenID);
    m_lower.getConfigurator().apply(IntakeConfigs.INTAKE_TALON_FX_CONFIGURATION, 0.05);

    m_upper = new TalonFX(MotorConstants.k_intakeKrakenID);
    m_upper.getConfigurator().apply(IntakeConfigs.INTAKE_TALON_FX_CONFIGURATION, 0.05);
  }

  public void shoot() {
    m_lower.set(MotorConstants.k_intakeSpeed);  // Revs up the two shooter motors
    m_upper.set(MotorConstants.k_intakeSpeed);
  }

  public void stopShooting() {
    m_lower.set(MotorConstants.k_intakeSpeed);  // Stops the two shooter motors
    m_upper.set(MotorConstants.k_intakeSpeed);
  }
}
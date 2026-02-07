package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.ClimberConfigs;
import frc.robot.Constants.MotorConstants;

public class ClimberSubsystem extends SubsystemBase{

    private TalonFX m_climbSpinner; //motor that spins extends climber arm
    public ClimberSubsystem() {
        m_climbSpinner = new TalonFX(MotorConstants.k_climberKrakenID);
        m_climbSpinner.getConfigurator().apply(ClimberConfigs.CLIMBER_TALON_FX_CONFIGURATION, 0.05);
    }

    public void climb() {
        m_climbSpinner.set(MotorConstants.k_climberSpeed); 
    }

    public void stopClimbing() {
        m_climbSpinner.set(0); 
    }
}
package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.IndexerConfigs;
import frc.robot.Constants.IndexerConstants;
import frc.robot.Constants.MotorIDConstants;

public class IndexerSubsystem extends SubsystemBase {

  // [Kraken x44] x2 TODO: Confirm
  private TalonFX m_shooterIndexer;
  private TalonFX m_beltFloor;
  private TalonFX m_rollerFloor;

  // Rolls and indexes fuels
  public IndexerSubsystem() {
    
    m_shooterIndexer = new TalonFX(MotorIDConstants.k_shooterIndexerKrakenID);
    m_beltFloor = new TalonFX(MotorIDConstants.k_beltFloorKrakenID);
    m_rollerFloor = new TalonFX(MotorIDConstants.k_rollerFloorKrakenID);

    m_shooterIndexer.getConfigurator().apply(IndexerConfigs.SHOOTER_INDEXER_TALON_FX_CONFIGURATION, 0.05);
    m_beltFloor.getConfigurator().apply(IndexerConfigs.BELT_FLOOR_TALON_FX_CONFIGURATION, 0.05);
    m_rollerFloor.getConfigurator().apply(IndexerConfigs.ROLLER_FLOOR_TALON_FX_CONFIGURATION, 0.05);
  
  }

  public void index() {
    m_shooterIndexer.set(-IndexerConstants.k_shooterIndexerSpeed); // Feeds the balls into the shooter
    m_beltFloor.set(IndexerConstants.k_beltFloorSpeed); // Conveys balls to shooter indexer TODO: Check for direction
    m_rollerFloor.set(IndexerConstants.k_rollerFloorSpeed); // Feeds the balls onto belt floor
  }

  public void stopIndex() {
    m_shooterIndexer.set(0);
    m_beltFloor.set(0);
    m_rollerFloor.set(0);
  }
}
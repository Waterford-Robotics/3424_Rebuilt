// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// Spindexes
// Good
package frc.robot.commands;

import frc.robot.subsystems.SpindexerSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class SpindexerCommand extends Command {

  // Uses Spindexer Subsystem
  SpindexerSubsystem m_spindexerSubsystem;
  double m_seconds;
  Timer m_timer = new Timer();

  // Constructor
  public SpindexerCommand(SpindexerSubsystem spindexerSubsystem, double seconds) {
        
    // Definitions and setting parameters are equal to members!
    m_spindexerSubsystem = spindexerSubsystem;
    addRequirements(spindexerSubsystem);
    m_seconds = seconds;
  }

  // Reset timer when the command starts executing
  public void initialize() {
    m_timer.start();
    m_timer.reset();
  }
  
  // Actual command
  public void execute() {

    if(m_timer.get() < m_seconds) {
      m_spindexerSubsystem.spindex();
    }
  }

  // Stuff that happens when command is over
  public void end(boolean interrupted) {
    m_spindexerSubsystem.stopSpindex();
  }

  // Checks if the command is done
  public boolean isFinished() {

    // Am I done?  Am I done? Am I finally done?
    return m_timer.get() > m_seconds;
  }
}
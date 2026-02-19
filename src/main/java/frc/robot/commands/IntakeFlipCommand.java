// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
// Flip in or out the intake
// Clean!
package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class IntakeFlipoutCommand extends Command {

  IntakeSubsystem m_intakeSubsystem;
  double m_seconds;
  int m_polarity;
  Timer m_timer = new Timer();

  // Constructor
  public IntakeFlipoutCommand(IntakeSubsystem intakeSubsystem, double seconds, int polarity) {
        
    // Definitions and setting parameters are equal to members!
    m_intakeSubsystem = intakeSubsystem;
    addRequirements(intakeSubsystem);
    m_seconds = seconds;
    m_polarity = polarity;
  }

  // Reset timer when the command starts executing
  public void initialize() {
    m_timer.start();
    m_timer.reset();
  }
  
  // Actual command
  public void execute() {
    if(m_timer.get() < m_seconds) {
      m_intakeSubsystem.flipCommand(m_polarity);
    }
  }

  // Stuff that happens when command is over
  public void end(boolean interrupted) {
    m_intakeSubsystem.stopFlip();
  }

  // Checks if the command is done
  public boolean isFinished() {

    // Am I done?  Am I done? Am I finally done?
    return m_timer.get() > m_seconds;
  }
}
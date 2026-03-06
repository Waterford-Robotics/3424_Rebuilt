// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.ControllerConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.MotorConstants;
import frc.robot.commands.AimCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.IntakeFlipCommand;
import frc.robot.commands.IntakeRollersCommand;
import frc.robot.commands.SpindexerCommand;
//import frc.robot.subsystems.ClimberSubsystem;

import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SpindexerSubsystem;
import frc.robot.subsystems.SwerveSubsystem;

import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.events.EventTrigger;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final SwerveSubsystem m_swerveSubsystem = new SwerveSubsystem();
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  //private final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();
  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
  private final SpindexerSubsystem m_spindexerSubsystem = new SpindexerSubsystem();
  private final CommandXboxController m_driverController = new CommandXboxController(ControllerConstants.k_driverControllerPort);
  private final CommandXboxController m_operatorController = new CommandXboxController(OperatorConstants.k_operatorControllerPort);
  SendableChooser<Command> m_chooser = new SendableChooser<>();
 

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    m_swerveSubsystem.setDefaultCommand(driveFieldOrientedAngularVelocity);
  
   // NamedCommands.registerCommand("shooterCommand", new ShooterCommand(m_shooterSubsystem,1.0));
   // Aim and rev up at the same time, then start spindexing 
   NamedCommands.registerCommand("AimAndShootSequence", 
        new SequentialCommandGroup(
          new ParallelCommandGroup(
            new AimCommand(m_swerveSubsystem), 
            new ShooterCommand(m_shooterSubsystem, 2.0)
        ),
          new SpindexerCommand(m_spindexerSubsystem, 2.0))

    );
    // Deploy intake and roll at the same time
    NamedCommands.registerCommand("IntakeFlipout", 
        new IntakeFlipCommand(m_intakeSubsystem, 1.0, MotorConstants.k_flipPolarity)
    );

    NamedCommands.registerCommand("IntakeFlipin", 
        new IntakeFlipCommand(m_intakeSubsystem, 1.0, -1 * MotorConstants.k_flipPolarity)
    );

    NamedCommands.registerCommand("IntakeRollers", 
        new IntakeRollersCommand(m_intakeSubsystem, 1.0)
    );

   // m_chooser.addOption("LSNZSR", m_swerveSubsystem.getAutonomousCommand("LSNZSR"));
    //m_chooser.addOption("SLSDS", m_swerveSubsystem.getAutonomousCommand("SLSDS"));
    //m_chooser.addOption("SLSDS", m_swerveSubsystem.getAutonomousCommand("SLSDS"));

    new EventTrigger("flipout")
      .whileTrue(new RunCommand(
        () -> m_intakeSubsystem.flipCommand(1),m_intakeSubsystem));
    
    new EventTrigger("intakeRollers")
      .whileTrue(new RunCommand(
        () -> m_intakeSubsystem.intakeCommand(1),m_intakeSubsystem));

    SmartDashboard.putData("Automode", m_chooser);

    

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // CONTROLLER CONSTANTS
    //zero NavX
    new JoystickButton(m_driverController.getHID(), ControllerConstants.k_resetNavX)
    .onTrue(new InstantCommand(
        () -> m_swerveSubsystem.zeroGyro(),
        m_swerveSubsystem));
    // does there need to be an .onFalse?    

    // intake wheels
   new Trigger(() -> m_driverController.getRawAxis(ControllerConstants.k_intakeWheels) > 0.05)
      .whileTrue(
        new RunCommand(() -> m_intakeSubsystem.intakeCommand(1))
      )
      .onFalse(
        new RunCommand(() -> m_intakeSubsystem.stopIntake())
      );

    // spindexer and feed
    new JoystickButton(m_driverController.getHID(), ControllerConstants.k_spindexer)
      .onTrue(new RunCommand(
        () -> m_spindexerSubsystem.spindex(), m_spindexerSubsystem))
      .onFalse(new RunCommand(
        () -> m_spindexerSubsystem.stopSpindex(),
        m_spindexerSubsystem));

    // aim
    new JoystickButton(m_driverController.getHID(), ControllerConstants.k_aimRobot)
     .onTrue(new AimCommand(m_swerveSubsystem));

     // X Wheels
     new JoystickButton(m_operatorController.getHID(), OperatorConstants.k_Xwheels)
    .whileTrue(new RunCommand(
        () -> m_swerveSubsystem.XWheels(),
        m_swerveSubsystem));

    /* 
      // climber extension
      new JoystickButton(m_operatorController.getHID(), ControllerConstants.k_climbExtend)
     .whileTrue(new RunCommand(
        () -> m_climberSubsystem.climbCommand(MotorConstants.k_climberPolarity), //may need to change
        m_climberSubsystem))
      .onFalse(new RunCommand(
        () -> m_climberSubsystem.stopClimb(),
        m_climberSubsystem));
    
      // climber compression
      new JoystickButton(m_operatorController.getHID(), ControllerConstants.k_climbCompress)
     .whileTrue(new RunCommand(
        () -> m_climberSubsystem.climbCommand(-1*MotorConstants.k_climberPolarity), //may need to change
        m_climberSubsystem))
      .onFalse(new RunCommand(
        () -> m_climberSubsystem.stopClimb(),
        m_climberSubsystem));
*/
      // flip out
      new JoystickButton(m_driverController.getHID(), ControllerConstants.k_flipOut)
     .onTrue(new RunCommand( //double check onTrue of whileTrue
        () -> m_intakeSubsystem.flipCommand(MotorConstants.k_intakePolarity), //may need to change
        m_intakeSubsystem))
      .onFalse(new RunCommand(
        () -> m_intakeSubsystem.stopFlip(),
        m_intakeSubsystem));

      // flip in
      new JoystickButton(m_driverController.getHID(), ControllerConstants.k_flipIn)
     .onTrue(new RunCommand(
        () -> m_intakeSubsystem.flipCommand(-1 * MotorConstants.k_intakePolarity), //may need to change
        m_intakeSubsystem))
      .onFalse(new RunCommand(
        () -> m_intakeSubsystem.stopFlip(),
        m_intakeSubsystem));

   
    //Spindexer on Driver controller
    new Trigger(() -> m_driverController.getRawAxis(ControllerConstants.k_spindexer) > 0.05)
      .whileTrue(
        new RunCommand(() -> m_spindexerSubsystem.spindex())
      )
      .onFalse(
        new RunCommand(() -> m_spindexerSubsystem.stopSpindex())
      );
// shoot/rev up
    new Trigger (() -> m_driverController.getRawAxis(OperatorConstants.k_revShooter) > 0.05)
      .whileTrue(
        new RunCommand(() -> m_shooterSubsystem.shoot())
      )
      .onFalse(
        new RunCommand(() -> m_shooterSubsystem.stopShooting())
      );
  

    new Trigger (() -> m_driverController.getRawAxis(ControllerConstants.k_rollerfloor) > 0.05)
      .whileTrue(
        new RunCommand(() -> m_spindexerSubsystem.spindex())
      )
      .onFalse(
        new RunCommand(() -> m_spindexerSubsystem.stopSpindex())
      );
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  Command driveFieldOrientedAngularVelocity = m_swerveSubsystem.driveCommand(
        () -> MathUtil.applyDeadband(m_driverController.getLeftY() * DriveConstants.k_driveSpeed, DriveConstants.k_driveDeadBand),
        () -> MathUtil.applyDeadband(m_driverController.getLeftX() * DriveConstants.k_driveSpeed, DriveConstants.k_driveDeadBand),
        () -> m_driverController.getRightX() * DriveConstants.k_turnRate); 
  
  public Command getAutonomousCommand() {
    // The selected auto on SmartDashboard will be run in autonomous
    return m_chooser.getSelected(); 
  }

  SequentialCommandGroup SpindexAndShootCommand = new SequentialCommandGroup(
    new ShooterCommand(m_shooterSubsystem, 1.0),
    new SpindexerCommand(m_spindexerSubsystem, 1.0)
  );

  
}
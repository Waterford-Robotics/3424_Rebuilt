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
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.SpindexerCommand;
import frc.robot.subsystems.ClimberSubsystem;

import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SpindexerSubsystem;
import frc.robot.subsystems.SwerveSubsystem;
import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
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
  private final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();
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
    //zero NavX
    new JoystickButton(m_driverController.getHID(), ControllerConstants.k_resetNavX)
    .onTrue(new InstantCommand(
        () -> m_swerveSubsystem.zeroGyro(),
        m_swerveSubsystem));


     new JoystickButton(m_driverController.getHID(), OperatorConstants.k_Xwheels)
    .whileTrue(new RunCommand(
        () -> m_swerveSubsystem.XWheels(),
        m_swerveSubsystem));
    

    // intake wheels
    new JoystickButton(m_driverController.getHID(), ControllerConstants.k_intakeWheels)
      .whileTrue(new RunCommand(
        () -> m_intakeSubsystem.intakeCommand(MotorConstants.k_intakePolarity), // may need to change
        m_intakeSubsystem))
      .onFalse(new RunCommand(
        () -> m_intakeSubsystem.stopIntake(),
        m_intakeSubsystem));

    
    //     // climber extension
    // new JoystickButton(m_operatorController.getHID(), ControllerConstants.k_climbExtend)
    //  .whileTrue(new RunCommand(
    //     () -> m_climberSubsystem.climbCommand(MotorConstants.k_climberPolarity), //may need to change
    //     m_climberSubsystem))
    //   .onFalse(new RunCommand(
    //     () -> m_climberSubsystem.stopClimb(),
    //     m_climberSubsystem));
    
    // // climber compression
    // new JoystickButton(m_operatorController.getHID(), ControllerConstants.k_climbCompress)
    //  .whileTrue(new RunCommand(
    //     () -> m_climberSubsystem.climbCommand(-1*MotorConstants.k_climberPolarity), //may need to change
    //     m_climberSubsystem))
    //   .onFalse(new RunCommand(
    //     () -> m_climberSubsystem.stopClimb(),
    //     m_climberSubsystem));/

    // flip out
    new JoystickButton(m_operatorController.getHID(), OperatorConstants.k_flipOut)
     .onTrue(new RunCommand( //double check onTrue of whileTrue
        () -> m_intakeSubsystem.flipCommand(MotorConstants.k_intakePolarity), //may need to change
        m_intakeSubsystem));

    // flip in
    new JoystickButton(m_operatorController.getHID(), OperatorConstants.k_flipIn)
     .onTrue(new RunCommand(
        () -> m_intakeSubsystem.flipCommand(-1 * MotorConstants.k_intakePolarity), //may need to change
        m_intakeSubsystem));


    // aim
    new JoystickButton(m_driverController.getHID(), ControllerConstants.k_aimRobot)
     .onTrue(new AimCommand(m_swerveSubsystem));

    // shoot/rev up, operator
    new JoystickButton(m_operatorController.getHID(), OperatorConstants.k_shoot)
        .onTrue(new RunCommand(
        () -> m_shooterSubsystem.shoot(), m_shooterSubsystem));

    // spindexer, driver
    new JoystickButton(m_driverController.getHID(), ControllerConstants.k_spindexer)
     .onTrue(new RunCommand(
        () -> m_spindexerSubsystem.spindex(), m_spindexerSubsystem));
    
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
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.*;

import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.SignalLogger;
import com.ctre.phoenix6.swerve.SwerveRequest;
import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.RobotModeTriggers;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.ControllerConstants;

import frc.robot.commands.IntakeForSecsCommand;
import frc.robot.commands.ShootForSecsCommand;

import frc.robot.generated.TunerConstants;

import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.IndexerSubsystem;

public class RobotContainer {
	private double MaxSpeed = 1.0 * TunerConstants.kSpeedAt12Volts.in(MetersPerSecond); // kSpeedAt12Volts desired top speed
	private double MaxAngularRate = RotationsPerSecond.of(0.75).in(RadiansPerSecond); // 3/4 of a rotation per second max angular velocity

	/* Setting up bindings for necessary control of the swerve drive platform */
	private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
		.withDeadband(MaxSpeed * 0.1).withRotationalDeadband(MaxAngularRate * 0.1) // Add a 10% deadband
		.withDriveRequestType(DriveRequestType.OpenLoopVoltage); // Use open-loop control for drive motors
	
	public final CommandSwerveDrivetrain m_drivetrain = TunerConstants.createDrivetrain();
	private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
	private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
	private final IndexerSubsystem m_spindexerSubsystem = new IndexerSubsystem();

	private final CommandXboxController m_driverController = new CommandXboxController(ControllerConstants.k_driverControllerPort);
	private final CommandXboxController m_operatorController = new CommandXboxController(ControllerConstants.k_operatorControllerPort);

  private SendableChooser<Command> m_chooser = new SendableChooser<>();

	public RobotContainer() {
		
		configureBindings();

		// Note that X is defined as forward according to WPILib convention,
		// and Y is defined as to the left according to WPILib convention.
		m_drivetrain.setDefaultCommand(
				// Drivetrain will execute this command periodically
				m_drivetrain.applyRequest(() ->
						drive.withVelocityX(-m_driverController.getLeftY() * MaxSpeed) // Drive forward with negative Y (forward)
								.withVelocityY(-m_driverController.getLeftX() * MaxSpeed) // Drive left with negative X (left)
								.withRotationalRate(-m_driverController.getRightX() * MaxAngularRate) // Drive counterclockwise with negative X (left)
				)
		);

		SignalLogger.enableAutoLogging(false);

		// NAMED COMMANDS
		NamedCommands.registerCommand("ShootCommand", 
			new ShootForSecsCommand(m_shooterSubsystem,10)
		);

		NamedCommands.registerCommand("Intake", 
			new IntakeForSecsCommand(m_intakeSubsystem, 1.0)
		);
		
		// AUTOS!
		m_chooser.addOption("Shoot", getShootCommandGroup());

		// Put Chooser on SmartDashboarrd
		SmartDashboard.putData("Automode", m_chooser);
	}

	private void configureBindings() {
		
		// Idle while the robot is disabled. This ensures the configured
		// neutral mode is applied to the drive motors while disabled.
		final var idle = new SwerveRequest.Idle();
		RobotModeTriggers.disabled().whileTrue(
			m_drivetrain.applyRequest(() -> idle).ignoringDisable(true)
		);

		// Zero NavX
		new JoystickButton(m_driverController.getHID(), ControllerConstants.k_back)
		.onTrue(
			new InstantCommand(() -> m_drivetrain.resetGyro(), m_drivetrain)
		);

		// X Wheels
		new JoystickButton(m_operatorController.getHID(), ControllerConstants.k_X) // TODO: CHECK
		.whileTrue(
			m_drivetrain.applyRequest(() -> new SwerveRequest.SwerveDriveBrake())
		);

		// Intake Wheels
		new Trigger(() -> m_driverController.getRawAxis(ControllerConstants.k_righttrig) > 0.05)
		.whileTrue(
			new RunCommand(() -> m_intakeSubsystem.intake())
		)
		.onFalse(
			new InstantCommand(() -> m_intakeSubsystem.stopIntake())
		);

		// Spindexer on Driver controller
		new Trigger(() -> m_driverController.getRawAxis(ControllerConstants.k_lefttrig) > 0.05)
		.whileTrue(
				new RunCommand(() -> m_spindexerSubsystem.index())
		)
		.onFalse(
				new RunCommand(() -> m_spindexerSubsystem.stopIndex())
		);
		
		// Rev up normal speed
		new Trigger (() -> m_operatorController.getRawAxis(ControllerConstants.k_righttrig) > 0.05)
		.whileTrue(
			new RunCommand(() -> m_shooterSubsystem.shoot())
		)
		.onFalse(
			new InstantCommand(() -> m_shooterSubsystem.stopShooter())
		);

		new JoystickButton(m_operatorController.getHID(), ControllerConstants.k_leftbump) // TODO: Confirm
		.onTrue(
			new RunCommand(() -> m_intakeSubsystem.intake(), m_intakeSubsystem)
		)
		.onFalse(
			new InstantCommand(() -> m_intakeSubsystem.stopIntake(), m_intakeSubsystem)
		);
	}

	// Shoot Command for Autos
	SequentialCommandGroup getShootCommandGroup() {
		return new SequentialCommandGroup(
			new ShootForSecsCommand(m_shooterSubsystem, 1),
			new ParallelCommandGroup(
				new ShootForSecsCommand(m_shooterSubsystem, 10)
				// new SpindexerCommand(m_spindexerSubsystem,10)
			)
		);
	}

	// Return Autos
	public Command getAutonomousCommand() {
		return m_chooser.getSelected();
	}
}

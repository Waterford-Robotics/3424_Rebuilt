// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import static edu.wpi.first.units.Units.*;

import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.SignalLogger;
import com.ctre.phoenix6.swerve.SwerveRequest;
import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.events.EventTrigger;

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
import frc.robot.Constants.MotorConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.IntakeFlipCommand;
import frc.robot.commands.IntakeRollersCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.AimCommand;


import frc.robot.commands.SpindexerCommand;
import frc.robot.generated.TunerConstants;
import com.pathplanner.lib.auto.NamedCommands; 

import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SpindexerSubsystem;

public class RobotContainer {
    private double MaxSpeed = 1.0 * TunerConstants.kSpeedAt12Volts.in(MetersPerSecond); // kSpeedAt12Volts desired top speed
    private double MaxAngularRate = RotationsPerSecond.of(0.75).in(RadiansPerSecond); // 3/4 of a rotation per second max angular velocity

    /* Setting up bindings for necessary control of the swerve drive platform */
    private final SwerveRequest.FieldCentric drive = new SwerveRequest.FieldCentric()
            .withDeadband(MaxSpeed * 0.1).withRotationalDeadband(MaxAngularRate * 0.1) // Add a 10% deadband
            .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // Use open-loop control for drive motors
    
    public final CommandSwerveDrivetrain m_drivetrain = TunerConstants.createDrivetrain();
    private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  //private final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();
    private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
    private final SpindexerSubsystem m_spindexerSubsystem = new SpindexerSubsystem();

    private final CommandXboxController m_driverController = new CommandXboxController(ControllerConstants.k_driverControllerPort);
    private final CommandXboxController m_operatorController = new CommandXboxController(OperatorConstants.k_operatorControllerPort);

    

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

        NamedCommands.registerCommand("IntakeFlipout", 
            new IntakeFlipCommand(m_intakeSubsystem, 1.0, MotorConstants.k_flipPolarity)
        );

         NamedCommands.registerCommand("AimRobot", 
            new AimCommand(m_drivetrain)
        );

        NamedCommands.registerCommand("IntakeFlipin", 
            new IntakeFlipCommand(m_intakeSubsystem, 1.0, -1 * MotorConstants.k_flipPolarity)
        );

        NamedCommands.registerCommand("ShootCommand", 
            new ShooterCommand(m_shooterSubsystem,10)
        );

         NamedCommands.registerCommand("Shoot1SecCommand", 
            new ShooterCommand(m_shooterSubsystem,1)
        );

        NamedCommands.registerCommand("Spindexer",
            new SpindexerCommand(m_spindexerSubsystem, 10)
        );

        NamedCommands.registerCommand("IntakeRollers", 
            new IntakeRollersCommand(m_intakeSubsystem, 1.0)
        );
        
        
         m_chooser.addOption("Shoot", Shoot);
        
        
        

        new EventTrigger("flipout")
        .whileTrue(new RunCommand(
            () -> m_intakeSubsystem.flipCommand(1),m_intakeSubsystem));
        
        new EventTrigger("intakeRollers")
        .whileTrue(new RunCommand(
            () -> m_intakeSubsystem.intakeCommand(1),m_intakeSubsystem));

        SmartDashboard.putData("Automode", m_chooser);


    }

    private void configureBindings() {
        
        // Idle while the robot is disabled. This ensures the configured
        // neutral mode is applied to the drive motors while disabled.
        final var idle = new SwerveRequest.Idle();
        RobotModeTriggers.disabled().whileTrue(
            m_drivetrain.applyRequest(() -> idle).ignoringDisable(true)
        );

        // m_driverController.b().whileTrue(drivetrain.applyRequest(() ->
        //     point.withModuleDirection(new Rotation2d(-m_driverController.getLeftY(), -m_driverController.getLeftX()))
        // ));

        // Zero NavX
        new JoystickButton(m_driverController.getHID(), ControllerConstants.k_resetNavX)
        .onTrue(
            new InstantCommand(() -> m_drivetrain.resetGyro(), m_drivetrain)
        );

        // X Wheels
        new JoystickButton(m_operatorController.getHID(), OperatorConstants.k_Xwheels)
        .whileTrue(
            m_drivetrain.applyRequest(() -> new SwerveRequest.SwerveDriveBrake()
         ));

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
        .onTrue(
            new RunCommand(() -> m_spindexerSubsystem.spindex(), m_spindexerSubsystem)
        )
        .onFalse(
            new RunCommand(() -> m_spindexerSubsystem.stopSpindex(), m_spindexerSubsystem)
        );

        // flip out
        new JoystickButton(m_driverController.getHID(), ControllerConstants.k_flipOut)
        .onTrue(
            new RunCommand(() -> m_intakeSubsystem.flipCommand(MotorConstants.k_intakePolarity), m_intakeSubsystem)
        )
        .onFalse(
            new RunCommand(() -> m_intakeSubsystem.stopFlip(), m_intakeSubsystem)
        );

        // flip in
        new JoystickButton(m_driverController.getHID(), ControllerConstants.k_flipIn)
        .onTrue(
            new RunCommand(() -> m_intakeSubsystem.flipCommand(-1 * MotorConstants.k_intakePolarity), m_intakeSubsystem)
        )
        .onFalse(
            new RunCommand(() -> m_intakeSubsystem.stopFlip(), m_intakeSubsystem)
        );

        // Aim Command
        new JoystickButton(m_driverController.getHID(), ControllerConstants.k_aimRobot)
        .onTrue(
            new AimCommand(m_drivetrain)
        );
        // Aim Command
        new JoystickButton(m_operatorController.getHID(), ControllerConstants.k_aimRobot)
        .onTrue(
            new AimCommand(m_drivetrain)
        );

        // flip out
        new JoystickButton(m_operatorController.getHID(), ControllerConstants.k_flipOut)
        .onTrue(
            new RunCommand(() -> m_intakeSubsystem.flipCommand(MotorConstants.k_intakePolarity), m_intakeSubsystem)
        )
        .onFalse(
            new RunCommand(() -> m_intakeSubsystem.stopFlip(), m_intakeSubsystem)
        );

        // flip in
        new JoystickButton(m_operatorController.getHID(), ControllerConstants.k_flipIn)
        .onTrue(
            new RunCommand(() -> m_intakeSubsystem.flipCommand(-1 * MotorConstants.k_intakePolarity), m_intakeSubsystem)
        )
        .onFalse(
            new RunCommand(() -> m_intakeSubsystem.stopFlip(), m_intakeSubsystem)
        );

        // Spindexer on Driver controller
        new Trigger(() -> m_driverController.getRawAxis(ControllerConstants.k_spindexer) > 0.05)
        .whileTrue(
            new RunCommand(() -> m_spindexerSubsystem.spindex())
        )
        .onFalse(
            new RunCommand(() -> m_spindexerSubsystem.stopSpindex())
        );
        
        // rev up normal speed
        new Trigger (() -> m_operatorController.getRawAxis(OperatorConstants.k_revShooterNormal) > 0.05)
        .whileTrue(
            new RunCommand(() -> m_shooterSubsystem.shoot())
        )
        .onFalse(
            new RunCommand(() -> m_shooterSubsystem.stopShooting())
        );

        // rev up faster speed
        new Trigger (() -> m_operatorController.getRawAxis(OperatorConstants.k_revShooterFast) > 0.05)
        .whileTrue(
            new RunCommand(() -> m_shooterSubsystem.far_shoot())
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

        new JoystickButton(m_operatorController.getHID(), OperatorConstants.k_reverseIntake)
        .onTrue(
            new RunCommand(() -> m_intakeSubsystem.intakeCommand(-1), m_intakeSubsystem)
        )
        .onFalse(
            new RunCommand(() -> m_intakeSubsystem.stopIntake(), m_intakeSubsystem)
        );
    }

   SequentialCommandGroup Shoot = new SequentialCommandGroup(
            new ShooterCommand(m_shooterSubsystem, 1),
            new ParallelCommandGroup(
                new ShooterCommand(m_shooterSubsystem, 10),
                new SpindexerCommand(m_spindexerSubsystem,10)
        )


    );
    public Command getAutonomousCommand() {
        return m_chooser.getSelected();
    }
}

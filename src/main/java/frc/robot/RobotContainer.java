// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

<<<<<<< HEAD
import static edu.wpi.first.units.Units.*;
=======
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
import swervelib.SwerveInputStream;

import java.io.File;
>>>>>>> 43005d5cff7c588859268c186c290ac8e27cd5e7

import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.SignalLogger;
import com.ctre.phoenix6.swerve.SwerveRequest;
import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.events.EventTrigger;

<<<<<<< HEAD
=======
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Filesystem;
>>>>>>> 43005d5cff7c588859268c186c290ac8e27cd5e7
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
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

import frc.robot.commands.SpindexerCommand;
import frc.robot.generated.TunerConstants;
import com.pathplanner.lib.auto.NamedCommands; 

import frc.robot.subsystems.CommandSwerveDrivetrain;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.SpindexerSubsystem;

public class RobotContainer {
<<<<<<< HEAD
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
=======
  // The robot's subsystems and commands are defined here...
  private final SwerveSubsystem m_swerveSubsystem = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(),"swerve"));
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  //private final ClimberSubsystem m_climberSubsystem = new ClimberSubsystem();
  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
  private final SpindexerSubsystem m_spindexerSubsystem = new SpindexerSubsystem();
  private final CommandXboxController m_driverController = new CommandXboxController(ControllerConstants.k_driverControllerPort);
  private final CommandXboxController m_operatorController = new CommandXboxController(OperatorConstants.k_operatorControllerPort);
  SendableChooser<Command> m_chooser = new SendableChooser<>();
 
  SwerveInputStream driveAngularVelocity = SwerveInputStream.of(m_swerveSubsystem.getSwerveDrive(),
                                                                () -> m_driverController.getLeftY(),
                                                                () -> m_driverController.getLeftX())
                                                            .withControllerRotationAxis(m_driverController::getRightX)
                                                            .deadband(DriveConstants.k_driveDeadBand)
                                                            .scaleTranslation(DriveConstants.k_driveSpeed)
                                                            .allianceRelativeControl(false);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  
   // NamedCommands.registerCommand("shooterCommand", new ShooterCommand(m_shooterSubsystem,1.0));
   // Aim and rev up at the same time, then start spindexing 
   NamedCommands.registerCommand("AimAndShootSequence", 
        new SequentialCommandGroup(
          new ParallelCommandGroup(
            new AimCommand(m_swerveSubsystem), 
            new ShooterCommand(m_shooterSubsystem, 2.0)
        ),
          new SpindexerCommand(m_spindexerSubsystem, 2.0))
>>>>>>> 43005d5cff7c588859268c186c290ac8e27cd5e7

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
        
        
         m_chooser.addOption("ShootLeft", AutoBuilder.buildAuto("ShootLeftSide.auto"));
        
        

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

<<<<<<< HEAD
        new JoystickButton(m_operatorController.getHID(), OperatorConstants.k_reverseIntake)
        .onTrue(
            new RunCommand(() -> m_intakeSubsystem.intakeCommand(-1), m_intakeSubsystem)
        )
        .onFalse(
            new RunCommand(() -> m_intakeSubsystem.stopIntake(), m_intakeSubsystem)
        );
    }

    public Command getAutonomousCommand() {
        return m_chooser.getSelected();
    }
}
=======
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
    Command driveFieldOrientedAnglularVelocity = m_swerveSubsystem.driveFieldOriented(driveAngularVelocity);
    m_swerveSubsystem.setDefaultCommand(driveFieldOrientedAnglularVelocity);

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
  public Command getAutonomousCommand() {
    // The selected auto on SmartDashboard will be run in autonomous
    return m_chooser.getSelected(); 
  }

  SequentialCommandGroup SpindexAndShootCommand = new SequentialCommandGroup(
    new ShooterCommand(m_shooterSubsystem, 1.0),
    new SpindexerCommand(m_spindexerSubsystem, 1.0)
  );

  
}
>>>>>>> 43005d5cff7c588859268c186c290ac8e27cd5e7

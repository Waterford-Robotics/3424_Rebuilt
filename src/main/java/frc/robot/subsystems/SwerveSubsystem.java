package frc.robot.subsystems;

import java.io.File;
import java.util.function.DoubleSupplier;

import com.pathplanner.lib.config.RobotConfig;
import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.SwerveConstants;
import swervelib.SwerveDrive;
import swervelib.math.SwerveMath;
import swervelib.parser.SwerveParser;
import swervelib.telemetry.SwerveDriveTelemetry;
import swervelib.telemetry.SwerveDriveTelemetry.TelemetryVerbosity;

public class SwerveSubsystem extends SubsystemBase {

    File directory = new File(Filesystem.getDeployDirectory(), "swerve");
    SwerveDrive swerveDrive;
    RobotConfig config;

    public Pose2d getPose() {
        return swerveDrive.getPose();
    }

    public SwerveSubsystem() {
        SwerveDriveTelemetry.verbosity = TelemetryVerbosity.HIGH;

        try {
            swerveDrive = new SwerveParser(directory).createSwerveDrive(SwerveConstants.k_maxSpeed);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        swerveDrive.setCosineCompensator(false);

        try {
            config = RobotConfig.fromGUISettings();
        } catch (Exception e) {

            e.printStackTrace(); 
        }
    }

    public Command driveCommand(DoubleSupplier translationX, DoubleSupplier translationY, DoubleSupplier angularRotationX) {
        return run(() -> {
        
            swerveDrive.drive(SwerveMath.scaleTranslation(new Translation2d(
                translationX.getAsDouble() * swerveDrive.getMaximumChassisVelocity(),
                translationY.getAsDouble() * swerveDrive.getMaximumChassisVelocity()), DriveConstants.k_driveSpeed),
                Math.pow(angularRotationX.getAsDouble(), 3) * swerveDrive.getMaximumChassisAngularVelocity(),
                true,
                false);
        });
    }
   

    public void resetOdometry(Pose2d initialHolonomicPose) {
        swerveDrive.resetOdometry(initialHolonomicPose);
    }

    public ChassisSpeeds getRobotVelocity() {
        return swerveDrive.getRobotVelocity();
    }

    public void setChassisSpeeds(ChassisSpeeds chassisSpeeds) {
        swerveDrive.setChassisSpeeds(chassisSpeeds);
    }

    public void zeroGyro() { 
        swerveDrive.zeroGyro();
    }

     // Get Auto Command
    public Command getAutonomousCommand(String pathName) {
        // Create a path following command using AutoBuilder. This will also trigger event markers.
        return new PathPlannerAuto(pathName);
    }

    @Override
    public void periodic() {
    }

    @Override
    public void simulationPeriodic() {
    }
}

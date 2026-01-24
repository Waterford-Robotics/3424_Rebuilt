// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.Talon;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */

public class Robot extends TimedRobot {

  // Creates two new Talon objects! That means you are stating that the robot
  // has two Talon motors. The number in the parenthesis is the corresponding PWM
  // port on the RoboRIO

  // The first line tells the robot about where to find the left motor, and the 
  // second tells the robot about the right motor. I named them l1 (for left) 
  // and r1 (for right), but you can really name it whatever you want, as long
  // as it's easy to understand what each name means on the robot. One commonly
  // used format is to use abbreviate left as l and right as r, and add numbers
  // to designate between different left and right motors on the drivebase
  Talon l1 = new Talon(0);
  Talon r1 = new Talon(1);

  // Now that you have two motors, it's time to make them work together. By creating
  // a DiffferentialDrive object, you are telling the robot that the two motors (l1 
  // and r1) are a pair, and that they should work together as a drive train. We often
  // name this DifferentialDrive object dT, which stands for 'drive train'
  DifferentialDrive dT = new DifferentialDrive(l1, r1);

  // Remember moving the joystick to Port 0 on the FRC Driver Station? This is where
  // the port is set. By creating a new Joystick, we tell the robot that the drivebase
  // is controlled by a Logitech Controller. We name the driving controller 'driver' and
  // the operator's controller 'operator'
  Joystick driver = new Joystick(0);
  
  // This function is run when the robot is first started up and should be used for any
  // initialization code
  @Override
  public void robotInit() {

    // Because we want the robot's driving motors to spin the same way when moving forwards,
    // we have to reverse one of the motor's directions so they aren't spinning in opposite
    // directions when we push the joystick forwards. That's why we reverse one of the
    // robot's motors, by 'inverting' its direction
    r1.setInverted(true);

  }

  // This function is repeatedly run when the robot is powered on
  @Override
  public void robotPeriodic() {}

  // This function runs when the autonomous period starts. This includes
  // any preparation work needed as a prerequisite to the desired auto
  @Override
  public void autonomousInit() {}

  // This function is repeatedly run during the autonomous period. This is
  // where the code for your autonomous would go if it was implemented
  @Override
  public void autonomousPeriodic() {}

  // This function is run at the beginning of the tele-op period
  @Override
  public void teleopInit() {}

  // This function is run repeatedly during the tele-op period
  @Override
  public void teleopPeriodic() {
    
    // This line of code is how the joystick information is translated to instructions
    // for the motor controller. We use the Arcade Drive system to run our drive train
    // (dT). The first part in the parenthesis and before the comma controls the forwards 
    // and backwards movement on the robot. The second part in the parenthesis after the
    // comma takes the joystick input and translates it into turning movement. The 0.8
    // means that the motors run at 80% of the maximum CIM motor speed. Generally, it's
    // not a good idea to set this number above 80%, since running the motors too fast
    // can cause issues.
    dT.arcadeDrive(0.80 * driver.getRawAxis(1), 0.80 * driver.getRawAxis(2));

  }

  // This function is run as soon as the robot is disabled
  @Override
  public void disabledInit() {}

  // This function is repeatedly run when the robot is disabled
  @Override
  public void disabledPeriodic() {}

  // This function is run when test mode is activated
  @Override
  public void testInit() {}

  // This function is run repeatedly during test mode
  @Override
  public void testPeriodic() {}

  // This function is run when simulation mode starts
  @Override
  public void simulationInit() {}

  // This function is run repeatedly during simulation mode
  @Override
  public void simulationPeriodic() {}
}

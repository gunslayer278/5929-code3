// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.BaseCommands.TankDriveCommand;
import frc.robot.subsystems.TankDriveTrainSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotContainer {
  private final TankDriveTrainSubsystem m_driveTrain = new TankDriveTrainSubsystem();
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {
    SmartDashboard.putData("Auto mode", m_chooser);
    configureBindings();
  }

  
  private void configureBindings() {
    Joystick m_driverControllerLeft = new Joystick(Constants.OIConstants.kDriverControllerPortLeft);
    Joystick m_driverControllerRight = new Joystick(Constants.OIConstants.kDriverControllerPortRight);
    
    m_driveTrain.setDefaultCommand(
      new TankDriveCommand(
        m_driveTrain,
        m_driverControllerLeft.getY(),
        m_driverControllerRight.getY()
      )
    );

    m_chooser.setDefaultOption("I dont wanna go fast", new SequentialCommandGroup(
      new TankDriveCommand(m_driveTrain, 0.5, 0.5).withTimeout(5),
      new TankDriveCommand(m_driveTrain, 0, 0)
    ));
    m_chooser.addOption("Full Send or no send", new SequentialCommandGroup(
      new TankDriveCommand(m_driveTrain, 1, 1).withTimeout(5),
      new TankDriveCommand(m_driveTrain, 0, 0)
    ));

  }

  
  public Command getAutonomousCommand() {
    return null;
  }
}
// TYPEE THIS  ./gradlew build --refresh-dependencies        
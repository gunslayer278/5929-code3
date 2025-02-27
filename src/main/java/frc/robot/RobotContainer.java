// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.BaseCommands.TankDriveCommand;
import frc.robot.subsystems.TankDriveTrainSubsystem;

public class RobotContainer {

  private final TankDriveTrainSubsystem m_driveTrain = new TankDriveTrainSubsystem();

  public RobotContainer() {
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
    

  }

  
  public Command getAutonomousCommand() {
    return null; 
  }
}
// TYPEE THIS  ./gradlew build --refresh-dependencies        
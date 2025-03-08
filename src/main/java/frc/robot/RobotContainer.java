// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.Constants;
import frc.robot.commands.BaseCommands.SetElevatorCommands;
import frc.robot.commands.BaseCommands.SetIntakeCommand;
import frc.robot.commands.BaseCommands.SetPivot;
import frc.robot.commands.BaseCommands.TankDriveCommand;
import frc.robot.subsystems.TankDriveTrainSubsystem;
import frc.robot.subsystems.piviotSubsytem;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotContainer {
  private final TankDriveTrainSubsystem m_driveTrain = new TankDriveTrainSubsystem();
  private final ElevatorSubsystem m_elevator = new ElevatorSubsystem();
  private final IntakeSubsystem m_intake = new IntakeSubsystem();
  private final piviotSubsytem m_pivotSubsystem = new piviotSubsytem();
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();

  public RobotContainer() {
    SmartDashboard.putData("Auto mode", m_chooser);
    configureBindings();
  }

  
  private void configureBindings() {
    Joystick m_driverControllerLeft = new Joystick(Constants.OIConstants.kDriverControllerPortLeft);
    Joystick m_driverControllerRight = new Joystick(Constants.OIConstants.kDriverControllerPortRight);
    Joystick m_accessoryJoystick = new Joystick(Constants.OIConstants.m_accessoryJoystick);
    JoystickButton m_intakeButton = new JoystickButton(m_accessoryJoystick, Constants.OIConstants.kIntakeButton);
    JoystickButton m_outtakeButton = new JoystickButton(m_accessoryJoystick, Constants.OIConstants.kOuttakeButton);
    POVButton m_pivotButtonUp = new POVButton(m_accessoryJoystick, 0);
    POVButton m_pivotButtonDown = new POVButton(m_accessoryJoystick, 180);


    
    m_driveTrain.setDefaultCommand(
      new TankDriveCommand(
        m_driveTrain,
        () -> m_driverControllerLeft.getY(),
        () -> m_driverControllerRight.getY()
      )
    );
    m_elevator.setDefaultCommand(
      new SetElevatorCommands(
        m_elevator,
        () -> m_accessoryJoystick.getY()/2));
    
  
    m_intakeButton.whileTrue(new SetIntakeCommand(m_intake, .2));
    m_outtakeButton.whileTrue(new SetIntakeCommand(m_intake, -.2));

    m_pivotButtonUp.whileTrue(new SetPivot(m_pivotSubsystem, .2));
    m_pivotButtonDown.whileTrue(new SetPivot(m_pivotSubsystem, -.2));

    m_chooser.setDefaultOption("I dont wanna go fast", new SequentialCommandGroup(
      new TankDriveCommand(m_driveTrain, 0.75, -0.75).withTimeout(1),
      new TankDriveCommand(m_driveTrain, 0, 0)
    ));
    m_chooser.addOption("Full Send or no send", new SequentialCommandGroup(
      new TankDriveCommand(m_driveTrain, 1, -1).withTimeout(1),
      new TankDriveCommand(m_driveTrain, 0, 0)
    ));

  }

  
  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }
}
      
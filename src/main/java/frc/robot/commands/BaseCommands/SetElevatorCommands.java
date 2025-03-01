package frc.robot.commands.BaseCommands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;

public class SetElevatorCommands extends Command {
    private final ElevatorSubsystem elevatorSubsystem;
    private final double m_speed;
    private final DoubleSupplier m_speedSupplier;
    private final boolean m_useSupplier;
    
    // Constructor for fixed speed
    public SetElevatorCommands(ElevatorSubsystem elevatorSubsystem, double speed) {
        this.elevatorSubsystem = elevatorSubsystem;
        m_speed = speed;
        m_speedSupplier = null;
        m_useSupplier = false;
        addRequirements(elevatorSubsystem);
    }
    
    // Constructor for joystick control
    public SetElevatorCommands(ElevatorSubsystem elevatorSubsystem, DoubleSupplier speedSupplier) {
        this.elevatorSubsystem = elevatorSubsystem;
        m_speed = 0;
        m_speedSupplier = speedSupplier;
        m_useSupplier = true;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        if (m_useSupplier) {
            double speed = m_speedSupplier.getAsDouble();
            elevatorSubsystem.setElevatorSpeed(speed);
            SmartDashboard.putNumber("Elevator Speed", speed);
        } else {
            elevatorSubsystem.setElevatorSpeed(m_speed);
        }
    }

    @Override
    public void end(boolean interrupted) {
        elevatorSubsystem.setElevatorSpeed(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
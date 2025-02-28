package frc.robot.commands.BaseCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ElevatorSubsystem;

public class SetElevatorCommands extends Command {
    private final ElevatorSubsystem elevatorSubsystem;
    private double m_speed;
    
    public SetElevatorCommands(ElevatorSubsystem elevatorSubsystem, double speed) {
        this.elevatorSubsystem = elevatorSubsystem;
        m_speed = speed;
        addRequirements(elevatorSubsystem);
    }

    @Override
    public void execute() {
        elevatorSubsystem.setElevatorSpeed(m_speed);
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}

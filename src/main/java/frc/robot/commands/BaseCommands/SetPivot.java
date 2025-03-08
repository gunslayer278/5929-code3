package frc.robot.commands.BaseCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.piviotSubsytem;

public class SetPivot extends Command {
    private final piviotSubsytem piviotSubsystem;
    private final double m_speed;
    
    public SetPivot(piviotSubsytem piviotSubsystem, double speed) {
        this.piviotSubsystem = piviotSubsystem;
        this.m_speed = speed;
        addRequirements(piviotSubsystem);
    }

    @Override
    public void initialize() {
        piviotSubsystem.setPiviotSpeed(m_speed);
    }

    @Override
    public void end(boolean interrupted) {
        piviotSubsystem.stopPiviot();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}

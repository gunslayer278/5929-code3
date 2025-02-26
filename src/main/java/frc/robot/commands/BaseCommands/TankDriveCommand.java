package frc.robot.commands.BaseCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDriveTrainSubsystem;

public class TankDriveCommand extends Command {
    private TankDriveTrainSubsystem m_subsystem;
    private final double m_leftSpeed;
    private final double m_rightSpeed;

    public TankDriveCommand(TankDriveTrainSubsystem subsystem, double leftSpeed, double rightSpeed) {
        m_subsystem = subsystem;
        m_leftSpeed = leftSpeed;
        m_rightSpeed = rightSpeed;
        addRequirements(m_subsystem);
    }
    public void execute() {
        m_subsystem.setSpeed(m_leftSpeed, m_rightSpeed);
    }
    public void end(boolean interrupted) {
        m_subsystem.StopRobot();
    }
        
    

}

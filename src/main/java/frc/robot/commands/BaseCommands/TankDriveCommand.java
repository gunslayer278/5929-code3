package frc.robot.commands.BaseCommands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.TankDriveTrainSubsystem;

public class TankDriveCommand extends Command {
    private TankDriveTrainSubsystem m_subsystem;
    private final double m_leftSpeed;
    private final double m_rightSpeed;
    private final DoubleSupplier m_leftSpeedSupplier;
    private final DoubleSupplier m_rightSpeedSupplier;
    private final boolean m_useSuppliers;

    public TankDriveCommand(TankDriveTrainSubsystem subsystem, double leftSpeed, double rightSpeed) {
        m_subsystem = subsystem;
        m_leftSpeed = leftSpeed;
        m_rightSpeed = rightSpeed;
        m_leftSpeedSupplier = null;
        m_rightSpeedSupplier = null;
        m_useSuppliers = false;
        addRequirements(m_subsystem);
    }
    
    public TankDriveCommand(TankDriveTrainSubsystem subsystem, DoubleSupplier leftSpeedSupplier, DoubleSupplier rightSpeedSupplier) {
        m_subsystem = subsystem;
        m_leftSpeed = 0;
        m_rightSpeed = 0;
        m_leftSpeedSupplier = leftSpeedSupplier;
        m_rightSpeedSupplier = rightSpeedSupplier;
        m_useSuppliers = true;
        addRequirements(m_subsystem);
    }
    
    public void execute() {
        if (m_useSuppliers) {
            double leftSpeed = m_leftSpeedSupplier.getAsDouble(); 
            double rightSpeed = -m_rightSpeedSupplier.getAsDouble(); 
            
            m_subsystem.setSpeed(leftSpeed, rightSpeed);
            SmartDashboard.putNumber("Left Speed Joystick", leftSpeed);
            SmartDashboard.putNumber("Right Speed Joystick", rightSpeed);
        } else {
            // Use constant values (for autonomous)
            m_subsystem.setSpeed(m_leftSpeed, m_rightSpeed);
            SmartDashboard.putNumber("Left Speed Auto", m_leftSpeed);
            SmartDashboard.putNumber("Right Speed Auto", m_rightSpeed);
        }
    }
    
    public void end(boolean interrupted) {
        m_subsystem.StopRobot();
    }
}
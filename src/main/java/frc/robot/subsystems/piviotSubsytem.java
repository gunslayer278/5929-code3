package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class piviotSubsytem extends SubsystemBase {
    private VictorSPX piviotMotor;
    public piviotSubsytem() {
        piviotMotor = new VictorSPX(Constants.RotatingArm.kRotatorPort);
        
        // Configure motor to brake mode instead of coast
        piviotMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
    }
    public void setPiviotSpeed(double speed) {
        piviotMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, speed);
        SmartDashboard.putNumber("Piviot Speed", speed);
    }
    public void stopPiviot() {
        piviotMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, 0);
    }
    @Override
    public void periodic() {
        // Victor SPX doesn't directly provide current measurement like SparkMax
        // You would need a PDP/PDH to monitor current
        SmartDashboard.putNumber("Piviot Output", piviotMotor.getMotorOutputPercent());
    }
}

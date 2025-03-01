package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
    private VictorSPX intakeMotor;

    public IntakeSubsystem() {
        intakeMotor = new VictorSPX(Constants.Intake.kIntakePort);
        
        // Configure motor to brake mode instead of coast
        intakeMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
    }

    public void setIntakeSpeed(double speed) {
        intakeMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, speed);
        SmartDashboard.putNumber("Intake Speed", speed);
    }

    public void stopIntake() {
        intakeMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, 0);
    }

    @Override
    public void periodic() {
        // Victor SPX doesn't directly provide current measurement like SparkMax
        // You would need a PDP/PDH to monitor current
        SmartDashboard.putNumber("Intake Output", intakeMotor.get());
    }
}

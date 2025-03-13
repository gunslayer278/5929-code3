package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class piviotSubsytem extends SubsystemBase {
    private SparkMax piviotMotor;

    public piviotSubsytem() 
    {
        // piviotMotor = new VictorSPX(Constants.RotatingArm.kRotatorPort);
        piviotMotor = new SparkMax(Constants.RotatingArm.kRotatorPort, MotorType.kBrushless);

        // Configure motor to brake mode instead of coast
        // piviotMotor.setNeutralMode(com.ctre.phoenix.motorcontrol.NeutralMode.Brake);
        SparkMaxConfig piviotMotorConfig = new SparkMaxConfig();
        piviotMotorConfig.idleMode(IdleMode.kBrake);
        piviotMotor.configure(piviotMotorConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);

    }
    public void setPiviotSpeed(double speed) 
    {
        // piviotMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, speed);
        piviotMotor.set(speed);

        SmartDashboard.putNumber("Piviot Speed", speed);
    }

    public void stopPiviot() 
    {
        // piviotMotor.set(com.ctre.phoenix.motorcontrol.ControlMode.PercentOutput, 0);
        piviotMotor.set(0);
    }

    @Override
    public void periodic() {
        // Victor SPX doesn't directly provide current measurement like SparkMax
        // You would need a PDP/PDH to monitor current
        // SmartDashboard.putNumber("Piviot Output", piviotMotor.getMotorOutputPercent());
        SmartDashboard.putNumber("Piviot Output", piviotMotor.get());
    }
}

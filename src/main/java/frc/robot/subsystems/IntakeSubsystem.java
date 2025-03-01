package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
    private SparkMax intakeMotor;
    private SparkMaxConfig sparkMaxConfig;

    public IntakeSubsystem() {
        intakeMotor = new SparkMax(Constants.Intake.kIntakePort, MotorType.kBrushed);
        
        sparkMaxConfig = new SparkMaxConfig();
        sparkMaxConfig.idleMode(IdleMode.kBrake);
        intakeMotor.configure(sparkMaxConfig, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);
    }

    public void setIntakeSpeed(double speed) {
        intakeMotor.set(speed);
        SmartDashboard.putNumber("Intake Speed", speed);
    }

    public void stopIntake() {
        intakeMotor.set(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Intake Current", intakeMotor.getAppliedOutput());
    }
}

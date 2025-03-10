package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem  extends SubsystemBase{
    private SparkMax ElevatorMaster;
    private SparkMax ElevatorSlave;
    private SparkMaxConfig SparkMaxConfigMaster;
    private SparkMaxConfig SparkMaxConfigElevatorSlave;

    public ElevatorSubsystem() {
        ElevatorMaster = new SparkMax(Constants.Elevator.kElevatorMasterPort, MotorType.kBrushed);
        ElevatorSlave = new SparkMax(Constants.Elevator.kElevatorSlavePort, MotorType.kBrushed);


        SparkMaxConfigMaster = new SparkMaxConfig();
        SparkMaxConfigMaster.idleMode(IdleMode.kBrake);
        ElevatorMaster.configure(SparkMaxConfigMaster, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);

        SparkMaxConfigElevatorSlave = new SparkMaxConfig();
        SparkMaxConfigElevatorSlave.idleMode(IdleMode.kBrake);
        SparkMaxConfigElevatorSlave.follow(ElevatorMaster);
        ElevatorSlave.configure(SparkMaxConfigElevatorSlave, SparkMax.ResetMode.kResetSafeParameters, SparkMax.PersistMode.kPersistParameters);

}
    public void setElevatorSpeed(double speed) {
        ElevatorMaster.set(speed);
        SmartDashboard.putNumber("Elevator Speed", speed);
    }

    public void periodic() {
        SmartDashboard.putNumber("Elevator Master Current", ElevatorMaster.getAppliedOutput());
        SmartDashboard.putNumber("Elevator Slave Current", ElevatorSlave.getAppliedOutput());

    }
}

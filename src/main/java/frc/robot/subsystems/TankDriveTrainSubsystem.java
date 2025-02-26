package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TankDriveTrainSubsystem extends SubsystemBase {
    private SparkMax LeftMaster;
    private SparkMax LeftSlave;
    private SparkMax RightMaster;
    private SparkMax RightSlave;
    private SparkMaxConfig SparkMaxConfigMaster;
    private SparkMaxConfig SparkMaxConfigRightSlave;
    private SparkMaxConfig SparkMaxConfigLeftSlave;


    public TankDriveTrainSubsystem() {
        LeftMaster = new SparkMax(Constants.DriveConstants.kLeftMasterPort, MotorType.kBrushed);
        LeftSlave = new SparkMax(Constants.DriveConstants.kLeftSlavePort, MotorType.kBrushed);
        RightMaster = new SparkMax(Constants.DriveConstants.kRightMasterPort, MotorType.kBrushed);
        RightSlave = new SparkMax(Constants.DriveConstants.kRightSlavePort, MotorType.kBrushed);

      

        SparkMaxConfigMaster = new SparkMaxConfig();
        SparkMaxConfigMaster.idleMode(IdleMode.kBrake);
       

        SparkMaxConfigRightSlave = new SparkMaxConfig();
        SparkMaxConfigRightSlave.idleMode(IdleMode.kBrake);
        SparkMaxConfigRightSlave.follow(RightMaster);
        

        SparkMaxConfigLeftSlave = new SparkMaxConfig();
        SparkMaxConfigLeftSlave.idleMode(IdleMode.kBrake);
        SparkMaxConfigLeftSlave.follow(LeftMaster);

        LeftMaster.configure(SparkMaxConfigMaster, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
        LeftSlave.configure(SparkMaxConfigLeftSlave, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
        RightMaster.configure(SparkMaxConfigMaster, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
        RightSlave.configure(SparkMaxConfigRightSlave, SparkBase.ResetMode.kResetSafeParameters, SparkBase.PersistMode.kPersistParameters);
        
    }
    public void setLeftSpeed(double speed) {
        LeftMaster.set(speed);  // Set the speed of the left motor
    }
    public void setRightSpeed(double speed) {
        RightMaster.set(speed); // Set the speed of the right motor
    }
    public void setSpeed(double leftSpeed, double rightSpeed) {
        setLeftSpeed(leftSpeed);
        setRightSpeed(rightSpeed);  // Set the speed of both motors
    }
    public void StopRobot() {
        LeftMaster.set(0);
        RightMaster.set(0);  // Stop the robot
    }
}

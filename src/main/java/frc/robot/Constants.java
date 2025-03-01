

package frc.robot;


public final class Constants {
  public final class DriveConstants {
    public static final int kLeftMasterPort = 3;
    public static final int kLeftSlavePort = 4;
    public static final int kRightMasterPort = 1;
    public static final int kRightSlavePort = 2;
  }
  public final class Elevator {
    public static final int kElevatorMasterPort = 5;
    public static final int kElevatorSlavePort = 6;
  }

  public final class OIConstants {
    public static final int kDriverControllerPortLeft = 1;
    public static final int kDriverControllerPortRight = 2;
    public static final int m_accessoryJoystick = 0;
    public static int kIntakeButton = 1;
    public static int kOuttakeButton = 3;
  }
  public final class Intake{
    public static final int kIntakePort = 9;   
  }
  public final class RotatingArm{
    public static final int kRotatorPort = 8; // Pov up and Pov down
  }
}

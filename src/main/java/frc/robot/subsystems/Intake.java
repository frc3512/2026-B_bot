package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import dev.doglog.DogLog;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {

  private final TalonFX extensionMotor;
  private final TalonFX primaryRollerMotor;
  private final TalonFX secondaryRollerMotor;
  private final TalonFX tertiaryRollerMotor;

  public Intake() {

    extensionMotor = new TalonFX(Constants.IntakeConstants.extensionMotorID);
    primaryRollerMotor = new TalonFX(Constants.IntakeConstants.primaryRollerMotorID);
    secondaryRollerMotor = new TalonFX(Constants.IntakeConstants.secondaryRollerMotorID);
    tertiaryRollerMotor = new TalonFX(Constants.IntakeConstants.tertiaryRollerMotorID);

    extensionMotor.getConfigurator().apply(IntakeConstants.extensionMotorConfig);
    primaryRollerMotor.getConfigurator().apply(IntakeConstants.primaryRollerMotorConfig);
    secondaryRollerMotor.getConfigurator().apply(IntakeConstants.secondaryRollerMotorConfig);
    tertiaryRollerMotor.getConfigurator().apply(IntakeConstants.extensionMotorConfig);

    rezeroExtension();
  }

  public void setRollerSpeed(double speed) {
    primaryRollerMotor.set(speed);
    secondaryRollerMotor.set(speed);
    tertiaryRollerMotor.set(speed);
  }

  public void rollerSpeed1(double speed) {
    primaryRollerMotor.set(speed);
  }

  public void rollerSpeed2(double speed) {
    secondaryRollerMotor.set(speed);
  }

  public void rollerSpeed3(double speed) {
    tertiaryRollerMotor.set(speed);
  }

  public void setExtensionSpeed(double speed) {
    extensionMotor.set(speed);
  }

  public void rezeroExtension() {
    extensionMotor.setPosition(0.0);
  }

  public void setExtensionPosition(double position) {
    extensionMotor.setPosition(position);
  }

  public void periodic() {
    super.periodic();

    DogLog.log(
        "Intake/Extension Position: " + extensionMotor.getPosition(),
        "Intake/Extension Speed: " + extensionMotor.get(),
        "Intake/Roller Speed: " + primaryRollerMotor.get());
  }
}

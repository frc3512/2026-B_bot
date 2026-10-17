package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import dev.doglog.DogLog;
import edu.wpi.first.wpilibj2.command.Command;
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
    primaryRollerMotor.set(-speed);
    secondaryRollerMotor.set(-speed);
  }

  public void hopperRollerSpeed(double speed) {
    tertiaryRollerMotor.set(-speed);
  }

  public void setExtensionSpeed(double speed) {
    extensionMotor.set(speed);
  }

  public void extensionPosition(double position) {
    extensionMotor.setPosition(position);
  }

  public Command extend() {
    return runOnce(() -> setExtensionSpeed(-0.5));
  }

  public Command stow() {
    return runOnce(() -> setExtensionSpeed(0.25));
  }

  public Command stopExtension() {
    return runOnce(() -> setExtensionSpeed(0.0));
  }

  public Command rollers(double speed) {
    return runOnce(() -> setRollerSpeed(speed));
  }

  public Command hopperRoller(double speed) {
    return runOnce(() -> hopperRollerSpeed(speed));
  }

  public Command stopRollers() {
    return runOnce(() -> setRollerSpeed(0.0));
  }

  public void rezeroExtension() {
    extensionMotor.setPosition(0.0);
  }

  public void periodic() {
    super.periodic();

    DogLog.log("Intake/Extension Position: ", extensionMotor.getRotorPosition().getValueAsDouble());
    DogLog.log("Intake/Extension Speed: ", extensionMotor.get());
    DogLog.log("Intake/Roller Speed: ", primaryRollerMotor.get());
  }
}

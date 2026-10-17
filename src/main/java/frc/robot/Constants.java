// Copyright (c) 2021-2026 Littleton Robotics
// http://github.com/Mechanical-Advantage
//
// Use of this source code is governed by a BSD
// license that can be found in the LICENSE file
// at the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.RobotBase;

/**
 * This class defines the runtime mode used by AdvantageKit. The mode is always "real" when running
 * on a roboRIO. Change the value of "simMode" to switch between "sim" (physics sim) and "replay"
 * (log replay from a file).
 */
public final class Constants {
  public static final Mode simMode = Mode.SIM;
  public static final Mode currentMode = RobotBase.isReal() ? Mode.REAL : simMode;

  public static enum Mode {
    /** Running on a real robot. */
    REAL,

    /** Running a physics simulator. */
    SIM,

    /** Replaying from a log file. */
    REPLAY
  }

  public static class IntakeConstants {

    public static final int extensionMotorID = 10;
    public static final int primaryRollerMotorID = 20;
    public static final int secondaryRollerMotorID = 30;
    public static final int tertiaryRollerMotorID = 40;

    public static final double stowPos = 0.5;
    public static final double extendPos = 12.0;

    public static final TalonFXConfiguration extensionMotorConfig =
        new TalonFXConfiguration()
            .withMotorOutput(
                new MotorOutputConfigs()
                    .withInverted(InvertedValue.CounterClockwise_Positive)
                    .withNeutralMode(NeutralModeValue.Coast))
            .withSlot0(new Slot0Configs().withKP(3).withKI(0.0).withKD(0.0))
            .withFeedback(new FeedbackConfigs().withSensorToMechanismRatio(30.0 / 11.0))
            .withCurrentLimits(
                new CurrentLimitsConfigs()
                    .withStatorCurrentLimit(60)
                    .withStatorCurrentLimitEnable(true)
                    .withSupplyCurrentLimit(20)
                    .withSupplyCurrentLimitEnable(true));

    public static final TalonFXConfiguration primaryRollerMotorConfig =
        new TalonFXConfiguration()
            .withMotorOutput(
                new MotorOutputConfigs()
                    .withInverted(InvertedValue.CounterClockwise_Positive)
                    .withNeutralMode(NeutralModeValue.Coast))
            .withCurrentLimits(
                new CurrentLimitsConfigs()
                    .withStatorCurrentLimit(40)
                    .withStatorCurrentLimitEnable(true)
                    .withSupplyCurrentLimit(30)
                    .withSupplyCurrentLimitEnable(true));

    public static final TalonFXConfiguration secondaryRollerMotorConfig =
        new TalonFXConfiguration()
            .withMotorOutput(
                new MotorOutputConfigs()
                    .withInverted(InvertedValue.Clockwise_Positive)
                    .withNeutralMode(NeutralModeValue.Coast))
            .withCurrentLimits(
                new CurrentLimitsConfigs()
                    .withStatorCurrentLimit(40)
                    .withStatorCurrentLimitEnable(true)
                    .withSupplyCurrentLimit(30)
                    .withSupplyCurrentLimitEnable(true));

    public static final TalonFXConfiguration tertiaryRollerMotorConfig =
        new TalonFXConfiguration()
            .withMotorOutput(
                new MotorOutputConfigs()
                    .withInverted(InvertedValue.Clockwise_Positive)
                    .withNeutralMode(NeutralModeValue.Coast))
            .withCurrentLimits(
                new CurrentLimitsConfigs()
                    .withStatorCurrentLimit(40)
                    .withStatorCurrentLimitEnable(true)
                    .withSupplyCurrentLimit(30)
                    .withSupplyCurrentLimitEnable(true));
  }
}

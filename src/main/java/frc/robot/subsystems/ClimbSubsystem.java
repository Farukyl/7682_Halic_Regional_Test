// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase {

  CANSparkMax climbMax1 = new CANSparkMax(3, MotorType.kBrushless);
  CANSparkMax climbMax2 = new CANSparkMax(3, MotorType.kBrushless);

  MotorControllerGroup climbControllerGroup = new MotorControllerGroup(climbMax1, climbMax2);
  /** Creates a new Climb. */
  public ClimbSubsystem() {}

  public void climbIn(double speed) {
    climbControllerGroup.set(speed);
  }

  public void climbStop(){
    climbControllerGroup.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

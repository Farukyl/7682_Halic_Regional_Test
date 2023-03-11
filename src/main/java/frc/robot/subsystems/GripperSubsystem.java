// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GripperSubsystem extends SubsystemBase {

  CANSparkMax gripper = new CANSparkMax(1, MotorType.kBrushless);

  MotorControllerGroup gripperControllerGroup = new MotorControllerGroup(gripper);
  /** Creates a new ClampSubsystem. */
  public GripperSubsystem() {}

  public void gripperIn(double speed){
    gripperControllerGroup.set(speed);
  }

  public void gripperStop(){
    gripperControllerGroup.stopMotor();
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase {

  CANSparkMax climbMax1 = new CANSparkMax(3, MotorType.kBrushless);
  CANSparkMax climbMax2 = new CANSparkMax(3, MotorType.kBrushless);

  MotorControllerGroup climbControllerGroup = new MotorControllerGroup(climbMax1, climbMax2);

  PIDController climbPidController = new PIDController(0.1, 0, 0);

  double centimeterSetPoint;
  /** Creates a new Climb. */
  public ClimbSubsystem() {}

  public void climbEncoderReset() {
    climbMax1.getEncoder().setPosition(0);  
  }

  public double climbEncoderCentimeter(){
    double climbCentimeter = climbMax1.getEncoder().getPosition()*150;
    return climbCentimeter;
  }

  public void climbPID(double centimeterSetPoint){
    double climbPidControl = climbPidController.calculate(climbEncoderCentimeter(),centimeterSetPoint);
    climbMax1.set(climbPidControl);
  }

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

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmTurnSubsytem extends SubsystemBase {

  CANSparkMax armSparkMax1 = new CANSparkMax(5, MotorType.kBrushless);
  CANSparkMax armSparkMax2 = new CANSparkMax(6, MotorType.kBrushless);

  MotorControllerGroup armControllerGroup = new MotorControllerGroup(armSparkMax1, armSparkMax2);

  PIDController armPidController = new PIDController(0.1, 0, 0);

  double degreeSetPoint;

  /** Creates a new ArmTurnSubsytem. */
  public ArmTurnSubsytem() {}

  public void armEncoderReset(){
    armSparkMax1.getEncoder().setPosition(0);
  }

  public double armEncoderDegree(){
    double armDegree = armSparkMax1.getEncoder().getPosition()*180;
    return armDegree;
    
  }

  public void armPID(double degreeSetPoint){
    double armPidControl = armPidController.calculate(armEncoderDegree(), degreeSetPoint);
    armControllerGroup.set(armPidControl);

  }

  public void ArmTurnIn(double speed) {
    armControllerGroup.set(speed);
  }

  public void ArmTurnStop() {
    armControllerGroup.stopMotor();
    
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

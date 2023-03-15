// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TurretSubsystem extends SubsystemBase {

  CANSparkMax turret = new CANSparkMax(1, MotorType.kBrushless);

  MotorControllerGroup turreControllerGroup = new MotorControllerGroup(turret);

  PIDController turretPidController = new PIDController(0.1, 0, 0);

  double degreeSetPoint;

  
  /** Creates a new TurretSubsystem. */
  public TurretSubsystem() {
  }

  public void turretEncoderReset(){
    turret.getEncoder().setPosition(0);
  }

  public double turretEncoderDegree() { 
    double turretDegree = turret.getEncoder().getPosition()*360;
    return turretDegree;
  }

  public void turretPID(double degreeSetPoint) {
    double turretPIDcontrol = turretPidController.calculate(turretEncoderDegree(), degreeSetPoint);
    turreControllerGroup.set(turretPIDcontrol);
    SmartDashboard.putNumber("turretEncoderPosition", turretEncoderDegree());
  
  }


  public void turret(double speed){
    turreControllerGroup.set(speed);
  }
  public void stopTurret(){
      turreControllerGroup.stopMotor();
    }
  @Override
  public void periodic() {
      // This method will be called once per scheduler run
  }
}

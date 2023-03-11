// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {


  WPI_VictorSPX vSpx1 = new WPI_VictorSPX(1);
  WPI_VictorSPX vSpx2 = new WPI_VictorSPX(2);

  WPI_VictorSPX vSpx3 = new WPI_VictorSPX(3);
  WPI_VictorSPX vSpx4 = new WPI_VictorSPX(4);
  

  MotorControllerGroup lControllerGroup = new MotorControllerGroup(vSpx1, vSpx2);
  MotorControllerGroup rControllerGroup = new MotorControllerGroup(vSpx3, vSpx4);

  DifferentialDrive drive = new DifferentialDrive(lControllerGroup, rControllerGroup);

  Joystick joystick = new Joystick(0);
  Joystick stick = new Joystick(1);
  
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    rControllerGroup.setInverted(true);
  }

  public void ArcadeDrive(){
    drive.arcadeDrive(joystick.getRawAxis(2)*0.6, joystick.getRawAxis(1)*0.6);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

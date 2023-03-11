// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TurretSubsystem;

public class TurretPIDCommand extends CommandBase {
  TurretSubsystem turretSubsystem;
  double degreeSetPoint; 
  /** Creates a new TurretPIDCommand. */
  public TurretPIDCommand(TurretSubsystem turretSubsystem, double degreeSetPoint ) {
    this.turretSubsystem = turretSubsystem;
    this.degreeSetPoint = degreeSetPoint;
    addRequirements(turretSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    turretSubsystem.turretPID(degreeSetPoint);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    turretSubsystem.stopTurret();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

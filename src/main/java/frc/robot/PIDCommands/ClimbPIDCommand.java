// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.PIDCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;

public class ClimbPIDCommand extends CommandBase {
  ClimbSubsystem climbSubsystem;
  double centimeterSetPoint;
  /** Creates a new ClimbPIDCommand. */
  public ClimbPIDCommand(ClimbSubsystem climbSubsystem, double centimeterSetPoint) {
    this.climbSubsystem = climbSubsystem;
    this.centimeterSetPoint = centimeterSetPoint;
    addRequirements(climbSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    climbSubsystem.climbEncoderReset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    climbSubsystem.climbPID(centimeterSetPoint);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    climbSubsystem.climbStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

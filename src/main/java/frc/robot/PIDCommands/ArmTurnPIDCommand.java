// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.PIDCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmTurnSubsytem;

public class ArmTurnPIDCommand extends CommandBase {
  ArmTurnSubsytem armTurnSubsytem;
  double degreeSetPoint;
  /** Creates a new ArmTurnPIDCommand. */
  public ArmTurnPIDCommand(ArmTurnSubsytem armTurnSubsytem, double degreeSetPoint) {
    this.armTurnSubsytem = armTurnSubsytem;
    this.degreeSetPoint = degreeSetPoint;
    addRequirements(armTurnSubsytem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    armTurnSubsytem.armEncoderReset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    armTurnSubsytem.armPID(degreeSetPoint);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    armTurnSubsytem.ArmTurnStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

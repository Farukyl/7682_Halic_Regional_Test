// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RepeatCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArmTurnCommand;
import frc.robot.commands.ClimbCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.GripperCommand;
import frc.robot.commands.TurretCommand;
import frc.robot.subsystems.ArmTurnSubsytem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GripperSubsystem;
import frc.robot.subsystems.TurretSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  ArmTurnSubsytem armTurnSubsytem = new ArmTurnSubsytem();
  GripperSubsystem gripperSubsystem = new GripperSubsystem();
  TurretSubsystem turretSubsystem = new TurretSubsystem();
  ClimbSubsystem climbSubsystem = new ClimbSubsystem();
  DriveSubsystem driveSubsystem = new DriveSubsystem();
  Joystick joystick;
  Joystick stick;
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    stick = new Joystick(1);
    joystick = new Joystick(0);
    configureButtonBindings();
    driveSubsystem.setDefaultCommand(new DriveCommand(driveSubsystem));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(joystick, 1).whileTrue(new RepeatCommand(new GripperCommand(gripperSubsystem, 1)));
    new JoystickButton(joystick, 2).whileTrue(new RepeatCommand(new GripperCommand(gripperSubsystem, -1)));;
    new JoystickButton(joystick, 3).whileTrue(new RepeatCommand(new TurretCommand(turretSubsystem, 1)));
    new JoystickButton(joystick, 4).whileTrue(new RepeatCommand(new TurretCommand(turretSubsystem, -1)));
    new JoystickButton(stick, 1).whileTrue(new RepeatCommand(new ClimbCommand(climbSubsystem, 1)));
    new JoystickButton(stick, 2).whileTrue(new RepeatCommand(new ClimbCommand(climbSubsystem, -1)));
    new JoystickButton(stick, 3).whileTrue(new RepeatCommand(new ArmTurnCommand(armTurnSubsytem, 1)));
    new JoystickButton(stick, 4).whileTrue(new RepeatCommand(new ArmTurnCommand(armTurnSubsytem, -1)));


  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}

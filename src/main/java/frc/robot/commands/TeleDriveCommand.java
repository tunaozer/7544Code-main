// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive_Subsystem;

public class TeleDriveCommand extends CommandBase {
  public final Joystick driver_Controller;
  private final Drive_Subsystem drive_Subsystem;

  public TeleDriveCommand(Joystick driver_Controller, Drive_Subsystem drive_Subsystem) {
    this.driver_Controller = driver_Controller;
    this.drive_Subsystem = drive_Subsystem;
    addRequirements(drive_Subsystem);
  }  
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  public void execute() {
    drive_Subsystem.arcadeDrive(getSpeed(), getRotation(),true);
  }
  private double getSpeed() {
    double speed =-driver_Controller.getRawAxis(1);
    return speed;
  }
  private double getRotation() {
    double rotation = driver_Controller.getRawAxis(2);
    return rotation;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

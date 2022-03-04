// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class Drive_Subsystem extends SubsystemBase {
  private final WPI_VictorSPX left_Master_Motor = new WPI_VictorSPX(MotorConstants.kLeft_Master_Port);
  private final WPI_VictorSPX left_Slave_Motor = new WPI_VictorSPX(MotorConstants.kLeft_Slave_Port);

  private final WPI_VictorSPX right_Master_Motor = new WPI_VictorSPX(MotorConstants.kRight_Master_Port);
  private final WPI_VictorSPX right_Slave_Motor = new WPI_VictorSPX(MotorConstants.kRight_Slave_Port);
  private DifferentialDrive m_drive = new DifferentialDrive(left_Master_Motor, right_Master_Motor);

  private boolean isSlowMode = false;
  public Drive_Subsystem() {
    left_Slave_Motor.follow(left_Master_Motor);
    right_Slave_Motor.follow(right_Master_Motor);

    right_Master_Motor.setInverted(true);
    left_Master_Motor.setInverted(false);
    left_Slave_Motor.setInverted(false);
    right_Slave_Motor.setInverted(true);
    
    right_Master_Motor.setSafetyEnabled(false);
    right_Slave_Motor.setSafetyEnabled(false);
    left_Master_Motor.setSafetyEnabled(false);
    left_Slave_Motor.setSafetyEnabled(false);
    m_drive.setSafetyEnabled(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive(double speed, double rotation, boolean useSquares) {

    var xSpeed = speed;
    var zRotation = rotation;

    if (xSpeed == 1) {
      zRotation *= 0.5;
    } else
      zRotation *= 0.7;

    if (useSquares) {
      xSpeed *= Math.abs(xSpeed);
      zRotation *= Math.abs(zRotation);
    }

    if (isSlowMode) {
      xSpeed *= 0.3;
      zRotation *= 0.4;

    }

    xSpeed = Deadband(xSpeed);
    zRotation = Deadband(zRotation);

    left_Master_Motor.set(ControlMode.PercentOutput, xSpeed, DemandType.ArbitraryFeedForward, +zRotation);
    right_Master_Motor.set(ControlMode.PercentOutput, xSpeed, DemandType.ArbitraryFeedForward, -zRotation);

  }
  public void changeSlowMode() {
    if (isSlowMode)
      isSlowMode = false;
    else
      isSlowMode = true;

  }
  double Deadband(double value) {
    /* Upper deadband */
    if (value >= +0.09)
      return value;

    /* Lower deadband */
    if (value <= -0.09)
      return value;

    /* Outside deadband */
    return 0;
  }
}

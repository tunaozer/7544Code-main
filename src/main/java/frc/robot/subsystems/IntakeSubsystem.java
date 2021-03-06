// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants.MotorConstants;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeInSubsystem. */
  private final WPI_VictorSPX m_intake = new WPI_VictorSPX(MotorConstants.Intake_Motor_Port);
  public IntakeSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void Intake_In(){
    m_intake.set(1);
  }
  public void Intake_Out(){
    m_intake.set(-1);
  }
}

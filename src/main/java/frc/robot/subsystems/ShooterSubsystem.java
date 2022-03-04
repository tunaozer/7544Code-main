// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants.MotorConstants;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new Shooter. */
  private final WPI_VictorSPX m_climber_winch = new WPI_VictorSPX(MotorConstants.kShooter_Motor_PortLeft);
  public ShooterSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void Shoot_Out(){
    m_climber_winch.set(1);
  }
  public void Shoot_In(){
    m_climber_winch.set(-1);
  }
}



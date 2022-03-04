// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class Climber_Subsystem extends SubsystemBase {
  private final WPI_VictorSPX right_Climb_Motor = new WPI_VictorSPX(MotorConstants.Elevator_Motor_Port_right);
  private final WPI_VictorSPX left_Climb_Motor = new WPI_VictorSPX(MotorConstants.Elevator_Motor_Port_left);
  public Climber_Subsystem() {
    right_Climb_Motor.follow(left_Climb_Motor);
    right_Climb_Motor.setInverted(true);
    left_Climb_Motor.setInverted(false);
}


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void Climb_Up(){
    right_Climb_Motor.set(1);
    left_Climb_Motor.set(1);
  }
  public void Climb_None(){
    right_Climb_Motor.set(0);
    left_Climb_Motor.set(0);
  }

  public void Climb_Down(){
    right_Climb_Motor.set(-1);
    left_Climb_Motor.set(-1);
  
}
}

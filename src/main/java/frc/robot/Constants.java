// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final class MotorConstants {

        public static final int kLeft_Master_Port = 3;
        public static final int kLeft_Slave_Port = 2;
        public static final int kRight_Master_Port = 1;
        public static final int kRight_Slave_Port = 0;

        public static final int Intake_Motor_Port = 4;
        
        public static final int Elevator_Motor_Port_right = 8;
        public static final int Elevator_Motor_Port_left=7;
        
        public static final int kShooter_Motor_PortLeft = 5;
        
    }

   
}

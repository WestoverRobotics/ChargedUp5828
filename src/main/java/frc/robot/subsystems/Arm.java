// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

public class Arm extends SubsystemBase {

  private CANSparkMax armMotor;
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput;
  private RelativeEncoder armEncoder;

  /** Creates a new Arm. */
  public Arm() {
    armMotor = new CANSparkMax(5,MotorType.kBrushless);
    armEncoder = armMotor.getEncoder();
    armMotor.setIdleMode(IdleMode.kBrake);
  }

  //Commands
  public void armUp() {
    armMotor.set(.2);
  }
  public void armDown() {
    armMotor.set(-.1);
  }
  public void armStop() {
    armMotor.stopMotor();
  }
  public void armTop() {
    if(armEncoder.getPosition() < 5) {
      armMotor.set(.1);
    } else {
      armMotor.set(0);
    }
  }
    public void armBottom() {
      if(armEncoder.getPosition() > 5) {
        armMotor.set(-.1);
      } else {
        armMotor.set(0);
    }
  }
  //encoder stuff
    public void resetEncoder() {
      armEncoder.setPosition(0);
    }
}
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

  //DriveTrain Motor Controllers
  WPI_TalonSRX _rghtFront = new WPI_TalonSRX(3);
  WPI_TalonSRX _rghtFollower = new WPI_TalonSRX(4);
  WPI_TalonSRX _leftFront = new WPI_TalonSRX(1);
  WPI_TalonSRX _leftFollower = new WPI_TalonSRX(2);
  
  private final DifferentialDrive m_drive;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    //Differential Drive
    m_drive = new DifferentialDrive(_leftFront, _rghtFront);    
    /* factory default values */
    _rghtFront.configFactoryDefault();
    _rghtFollower.configFactoryDefault();
    _leftFront.configFactoryDefault();
    _leftFollower.configFactoryDefault();

     /* set up followers */
     _rghtFollower.follow(_rghtFront);
     _leftFollower.follow(_leftFront);

     /* [3] flip values so robot moves forward when stick-forward/LEDs-green */
     _rghtFront.setInverted(true); // !< Update this
     _leftFront.setInverted(false); // !< Update this

     /*
      * set the invert of the followers to match their respective master controllers
      */
     _rghtFollower.setInverted(InvertType.FollowMaster);
     _leftFollower.setInverted(InvertType.FollowMaster);

     /*
      * [4] adjust sensor phase so sensor moves positive when Talon LEDs are green
      */
     _rghtFront.setSensorPhase(true);
     _leftFront.setSensorPhase(true);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void curvatureDrive(double speed, double rotation, boolean quickturn){
    m_drive.curvatureDrive(speed, rotation, quickturn);
  }
}


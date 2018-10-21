package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;


@Autonomous (name="Autonomous7", group="Linear OpMode")
public class Autonomous7 extends LinearOpMode{
    ElapsedTime runtime = new ElapsedTime();
    private Servo teammarkerservo = null;
    
    
    
    @Override
    public void runOpMode() {
        DriveTrain driveTrain = new DriveTrain();
        driveTrain.init(hardwareMap);
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
        //teammarkerservo = hardwareMap.get(Servo.class, "teammarkerservo");
        
        waitForStart();
        runtime.reset();
        //get in position for right most mineral
        driveTrain.turnRight(0.2);
        sleep(300); //check how much it rotates
        //Move forward to the minerals
        driveTrain.moveForward(0.5);
        sleep(600);
        //Align with Mineral
        driveTrain.turnLeft(0.2);
        sleep(300);
        //Drive to depot after knocking mineral
        driveTrain.moveForward(0.5);
        sleep(100);
        //Drop team marker in depot
        //dropMarker(0.5);
        //sleep(2000);
        //Get in position to got to crater
        driveTrain.turnRight(0.6);
        sleep(1100);
        //Move forward to the crater
        driveTrain.moveForward(1.0);
        sleep(4000);
    } 
        public void dropMarker(double power)
        {
            
           //teammarkerservo.setPosition(power);
           
        }
    }

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous 
(name="Autonomous1", group="Linear Opmode")
public class Autonomous1twopointo extends LinearOpMode {
    ElapsedTime runtime = new ElapsedTime();
    private DcMotor armmotor = null;
    private DcMotor frontrightmotor = null;
    private DcMotor frontleftmotor = null;
    private DcMotor backrightmotor = null;
    private DcMotor backleftmotor = null;
    
    
       @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        
    armmotor = hardwareMap.get(DcMotor.class, "armmotor");
    frontrightmotor = hardwareMap.get(DcMotor.class, "frontrightmotor");
    frontleftmotor = hardwareMap.get(DcMotor.class, "frontleftmotor");
    backrightmotor = hardwareMap.get(DcMotor.class, "backrightmotor");
    backleftmotor = hardwareMap.get(DcMotor.class, "backleftmotor");
    
    
    
    armmotor.setPower(0);
    
        waitForStart();
        runtime.reset();
        
        Up(0.3);
        Sleep(500);
        
        Down(-1.0);
        sleep(3000);
    }  
    
    public void Up(double power)
        {
            
           armmotor.setPower(power);
        } 
}

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
@TeleOp(name = "Holonomic", group = "Linear OpMode")
public class Holonomic extends LinearOpMode {
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontleftmotor = null;
    private DcMotor frontrightmotor = null;
    private DcMotor backleftmotor = null;
    private DcMotor backrightmotor = null;
    private DcMotor armmotor1= null;
    private DcMotor armmotor2= null;
    private Servo rightservo = null;
    private Servo leftservo = null;
    //private DcMotor arm = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        frontleftmotor  = hardwareMap.get(DcMotor.class, "frontleftmotor");
        frontrightmotor = hardwareMap.get(DcMotor.class, "frontrightmotor");
        backleftmotor = hardwareMap.get(DcMotor.class, "backleftmotor");
       backrightmotor = hardwareMap.get(DcMotor.class, "backrightmotor");
        armmotor1 = hardwareMap.get(DcMotor.class, "armmotor1");
        armmotor2 = hardwareMap.get(DcMotor.class, "armmotor2");
        rightservo = hardwareMap.get(Servo.class, "rightservo");
        leftservo = hardwareMap.get(Servo.class, "leftservo");
        //arm = hardwareMap.get(DcMotor.class, "arm");
        //leftmotor = hardwareMap.get(DcMotor.class, "leftmotor");
        
        frontleftmotor.setPower(0);
        frontrightmotor.setPower(0);
        backleftmotor.setPower(0);
        backrightmotor.setPower(0);
        armmotor1.setPower(0);
        armmotor2.setPower(0);
        rightservo.setPosition(0.0);
        leftservo.setPosition(0.0);
    
    

        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        frontleftmotor.setDirection(DcMotor.Direction.REVERSE);
        //backleftmotor.setDirection(DcMotor.Direction.REVERSE);
        frontrightmotor.setDirection(DcMotor.Direction.REVERSE);
        //arm.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Setup a variable for each drive wheel to save power level for telemetry
        double frontleftPower;
        double frontrightPower;
        double backleftPower;
        double backrightPower;
        double arm1Power;
        double arm2Power;
        
            //double armPower;
            
        
            // left stick controls direction
        // right stick X controls rotation

        //double gamepad1LeftY = -gamepad1.left_stick_y;
        //double gamepad1LeftX = gamepad1.left_stick_x;
        //double gamepad1RightX = gamepad1.right_stick_x;
        
        //formulas for holonomic drive
        
        //double frontleftmotor = gamepad1.left_stick_y;
        //double frontrightmotor = gamepad1.left_stick_y;
        //double backrightmotor= -gamepad1.right_stick_y;
        //double backleftmotor= gamepad1.right_stick_y;
        
        

            // Choose to drive using either Tank Mode, or POV Mode
            // Comment out the method that's not used.  The default below is POV.

            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
           frontleftPower  = -gamepad1.left_stick_y ;
            frontrightPower = -gamepad1.left_stick_y;
            backleftPower = -gamepad1.right_stick_y ;
            backrightPower = -gamepad1.right_stick_y ;
            arm1Power = gamepad2.right_stick_y;
            arm2Power = gamepad2.left_stick_y;
            
            //armPower   = -gamepad2.right_stick_y;
            // Send calculated power to wheels
            frontleftmotor.setPower(frontleftPower);
            frontrightmotor.setPower(frontrightPower);
            backrightmotor.setPower(backrightPower);
            backleftmotor.setPower(backleftPower);
            armmotor1.setPower(arm1Power);
            armmotor2.setPower(arm2Power);
            
            
            
            if (gamepad1.x){
            rightservo.setPosition(0.7);
            leftservo.setPosition(0.3);
        }
        else if (gamepad1.y){
            rightservo.setPosition(0.6);
            leftservo.setPosition(0.4);
        }
            //arm.setPower(armPower);
            
            // Tank Mode uses one stick to control each wheel.
            // - This requires no math, but it is hard to drive forward slowly and keep straight.
            // leftPower  = -gamepad1.left_stick_y ;
            // rightPower = -gamepad1.right_stick_y ;

            // Send calculated power to wheels
            //leftDrive.setPower(leftPower);
            //rightDrive.setPower(rightPower);

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            //telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}


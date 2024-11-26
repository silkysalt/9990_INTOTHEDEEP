package org.firstinspires.ftc.teamcode.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Drivetrain extends LinearOpMode {
    public DcMotor topLeftDriveMotor;
    public DcMotor bottomLeftDriveMotor;
    public DcMotor topRightDriveMotor;
    public DcMotor bottomRightDriveMotor;
    public static DcMotor armmotorLeft;
    public DcMotor armmotorRight;
    public DcMotor armmotorThird;
    public static DcMotor armslider;
    //all unnecessary code from last year
    public static CRServo claw1;
    //public static CRServo wrist;
    //public DcMotor armmotorTop;
    //public DcMotor armmotorBottom;
    //public CRServo leftScoop;
    //public CRServo rightScoop;
    //public CRServo rightWheel;
    //public CRServo leftWheel;
    //public CRServo droneLauncher;
    public DcMotorEx rightOdo;
    public DcMotorEx leftOdo;
    public DcMotorEx midOdo;
    public double Kp = 8.5;
    public double Ki = 0;
    public double Kd = 0;

    HardwareMap hwMap;

    public void runOpMode() {

    }


    public void init(HardwareMap ahwMap) {

        /**
         * Assigns the parent hardware map to local ArtemisHardwareMap class variable
         * **/
        hwMap = ahwMap;

        /**
         * Hardware initialized and String Names are in the Configuration File for Hardware Map
         * **/

        // Control HUb
        topLeftDriveMotor = hwMap.get(DcMotor.class, "frontleft");
        bottomLeftDriveMotor = hwMap.get(DcMotor.class, "backleft");
        topRightDriveMotor = hwMap.get(DcMotor.class, "frontright");
        bottomRightDriveMotor = hwMap.get(DcMotor.class, "backright");
        armmotorLeft = hwMap.dcMotor.get("amleft");
        armmotorRight = hwMap.dcMotor.get("amright");
        /* NEW ARM MOTORS
                         |
                         v                 */
        armmotorThird = hwMap.dcMotor.get("amthird");
        armslider = hwMap.dcMotor.get("amslider");
        //wrist = hwMap.crservo.get("wrist");
        claw1 = hwMap.crservo.get("claw");
        //rightWheel = hwMap.crservo.get("rightwheel");
        //leftWheel = hwMap.crservo.get("leftwheel");
        //rightOdo = hwMap.get(DcMotorEx.class, "rightodo");
        //rightOdo.setDirection(DcMotorSimple.Direction.REVERSE);
        //leftOdo = hwMap.get(DcMotorEx.class, "amtop");
        //midOdo = hwMap.get(DcMotorEx.class, "middleodo");



        /**
         * Allow the 4 wheel motors to be run without encoders since we are doing a time based autonomous
         * **/
        topLeftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bottomLeftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        topRightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bottomRightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        /**
         *Since we are putting the motors on different sides we need to reverse direction so that one wheel doesn't pull us backwards
         * **/
        //THIS IS THE CORRECT ORIENTATION
        topLeftDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        topRightDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        bottomRightDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        
        /**
         * Reverses shooter motor to shoot the correct way and same with the conveyor motor
         * **/

        /**
         * We are setting the motor 0 mode power to be brake as it actively stops the robot and doesn't rely on the surface to slow down once the robot power is set to 0
         * **/
        /**
        topLeftDriveMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bottomLeftDriveMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        topRightDriveMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bottomRightDriveMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
         **/


        /** 2024 CODE
         set the arm motors to brake
         */
        armmotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armmotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armslider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        /*
        NEEDED TO NOT BREAK THE DARN ROBOT!!!
         */
        armslider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armslider.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



        /**
         *The 4 mecanum wheel motors, intake, conveyor, and shooter motor/servo are set to 0 power to keep it from moving when the user presses the INIT button
         * **/
        topLeftDriveMotor.setPower(0);
        bottomLeftDriveMotor.setPower(0);
        topRightDriveMotor.setPower(0);
        bottomRightDriveMotor.setPower(0);

    }

    public void power(double output) {
        topLeftDriveMotor.setPower(-output);
        bottomLeftDriveMotor.setPower(-output);
        topRightDriveMotor.setPower(output);
        bottomRightDriveMotor.setPower(output);
    }

    public void moveRobot(double leftStickY, double leftStickX, double rightStickX) {
        /**
         * Wheel powers calculated using gamepad 1's inputs leftStickY, leftStickX, and rightStickX
         * **/
        double y = -leftStickY * .65; // Remember, Y stick value is reversed
        double x = leftStickX * 1.1 * .65; // Counteract imperfect strafing
        double rx = rightStickX * .65;
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;
        topLeftDriveMotor.setPower(frontLeftPower);
        bottomLeftDriveMotor.setPower(backLeftPower);
        topRightDriveMotor.setPower(frontRightPower);
        bottomRightDriveMotor.setPower(backRightPower);
    }

    public void moveRobotSlow(double leftStickY, double leftStickX, double rightStickX) {
        double y = -leftStickY * .3; // Remember, Y stick value is reversed
        double x = leftStickX * 1.1 * .3; // Counteract imperfect strafing
        double rx = rightStickX * .3;
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;
        topLeftDriveMotor.setPower(frontLeftPower);
        bottomLeftDriveMotor.setPower(backLeftPower);
        topRightDriveMotor.setPower(frontRightPower);
        bottomRightDriveMotor.setPower(backRightPower);

    }

    public void armMovement(Gamepad gamepad1, Gamepad gamepad2) throws InterruptedException {


        //!!!!MOVEMENT FOR ARM!!!!
        if (gamepad2.right_trigger > 0) { // move arm forward
            armmotorLeft.setPower(.35 * gamepad2.right_trigger);
            armmotorRight.setPower(.35 * gamepad2.right_trigger);
            armmotorThird.setPower(.35 * gamepad2.right_trigger);
        } else if (gamepad2.left_trigger > 0) { // move arm backward
            armmotorLeft.setPower(-.35 * gamepad2.left_trigger);
            armmotorRight.setPower(-.35 * gamepad2.left_trigger);
            armmotorThird.setPower(-.35 * gamepad2.left_trigger);

        } else {
            armmotorLeft.setPower(0);
            armmotorRight.setPower(0);
            armmotorThird.setPower(0);
        }

        if (gamepad2.right_bumper) { // extend arm
            armslider.setPower(1);
        } else if (gamepad2.left_bumper) { //retract arm
            if (armslider.getCurrentPosition()<0) {
                armslider.setPower(-1);
            }
        } else {
            armslider.setPower(0);
        }

        /*claw functions: PLEASE TEST BEFORE MODIFYING
                |
                v        */
        if (gamepad2.b) {
            claw1.setPower(.6);
        }
        if (gamepad2.a) {
            claw1.setPower(-.6);
        }


        /*if (gamepad1.back) {
            double hang = 1.5;
            armmotorTop.setPower(hang);
            armmotorBottom.setPower(hang);
            sleep(10000000);
            }
*/




    }



}











package org.firstinspires.ftc.teamcode.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


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
    public static Servo claw1; // GOD DAMN IT
    public DcMotorEx rightOdo;
    public DcMotorEx leftOdo;
    public DcMotorEx midOdo;
    public double Kp = 8.5;
    public double Ki = 0;
    public double Kd = 0;

    public int hangConstant;
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
        claw1 = hwMap.servo.get("claw"); // IDK WHY I CALLED THIS CLAW1 FUCK THIS CLUB
        //rightOdo = hwMap.get(DcMotorEx.class, "rightodo");
        //rightOdo.setDirection(DcMotorSimple.Direction.REVERSE);
        //leftOdo = hwMap.get(DcMotorEx.class, "amtop");
        //midOdo = hwMap.get(DcMotorEx.class, "middleodo");



        //set up driving mode
        topLeftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bottomLeftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        topRightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bottomRightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        //THIS IS THE CORRECT ORIENTATION, 3 OF THE MOTORS ARE REVERSED FOR SOME GOD DAMN REASON
        topLeftDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        topRightDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        bottomRightDriveMotor.setDirection(DcMotor.Direction.REVERSE);



        /** 2024 CODE
         set the arm motors to brake TO MAKE SURE THAT WE DO NOT FUCKING FUCK ANYTHING
         */
        armmotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armmotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armmotorThird.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
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



    public void moveRobot(double leftStickY, double leftStickX, double rightStickX) { // INCREASED POWER FROM LAST YEAR!!! MORE POWER = MORE GOOD...?
        /**
         * Wheel powers calculated using gamepad 1's inputs leftStickY, leftStickX, and rightStickX
         * hfhghjksfdhjksdfjhlsfdhjlfdshjadfhjashsaj AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA FRIIICK  we reused this shit and it intentionally has shitty strafing because fuck mecanum wheels
         * **/
        double y = -leftStickY * 1; // Remember, Y stick value is reversed
        double x = leftStickX * 1.1 * 1; // Counteract imperfect strafing
        double rx = rightStickX * 0.5;
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
        // execute the robot!!!! we are like the salem witch trials in here
        if (hangConstant==1) {
            double hang = -.55;
            armmotorLeft.setPower(hang);
            armmotorRight.setPower(hang);
            armmotorThird.setPower(hang);
        }

        //!!!!MOVEMENT FOR ARM!!!!
        // i had to code thids and figure out what way the motors were going because if it fucks up it breaks the whole thing and i would be angry and annoyed and stupid if it did stupid stuff ugh
        if (gamepad2.right_trigger > 0) { // move arm up
            if (gamepad2.x) {
                armmotorLeft.setPower(.8 * gamepad2.right_trigger);
                armmotorRight.setPower(.8 * gamepad2.right_trigger);
                armmotorThird.setPower(.8 * gamepad2.right_trigger);
            } else {
                armmotorLeft.setPower(.4 * gamepad2.right_trigger);
                armmotorRight.setPower(.4 * gamepad2.right_trigger);
                armmotorThird.setPower(.4 * gamepad2.right_trigger);
            }

        } else if (gamepad2.left_trigger > 0) { // move arm down
            if (gamepad2.x) { // increase power when pressed!! INCREASE POWER INCREASE POWER INCREASE POWER!!!!!!
                armmotorLeft.setPower(-.8 * gamepad2.left_trigger);
                armmotorRight.setPower(-.8 * gamepad2.left_trigger);
                armmotorThird.setPower(-.8 * gamepad2.left_trigger);
            }   else {
                armmotorLeft.setPower(-.4 * gamepad2.left_trigger);
                armmotorRight.setPower(-.4 * gamepad2.left_trigger);
                armmotorThird.setPower(-.4 * gamepad2.left_trigger);
            }

        } else {
            armmotorLeft.setPower(0);
            armmotorRight.setPower(0);
            armmotorThird.setPower(0);
        }

        // added when armslider was new

        if (gamepad2.right_bumper) { // extend arm
            armslider.setPower(-1);
        } else if (gamepad2.left_bumper) { //retract arm
            if (armslider.getCurrentPosition()<0) {
                armslider.setPower(1);
            }
        } else {
            armslider.setPower(0);
        }

        /*claw functions: PLEASE TEST BEFORE MODIFYING
                |
                v        */
        if (gamepad2.b) { // MODIFIED FROM LAST YEAR, NEW LIMITS AND NEW CLAW ATTACHED
            claw1.setPosition(0);
        }
        if (gamepad2.a) {
            claw1.setPosition(0.25);
        }
        if (gamepad2.back) { // WAS*** NOT GAMEPAD 2
            hangConstant = 1;
        }
    }
}











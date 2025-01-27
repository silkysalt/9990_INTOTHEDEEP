package org.firstinspires.ftc.teamcode.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous(name="Autonomous Left 2025", group="Robot")
public class AutoLeft extends LinearOpMode {
    public DcMotor topLeftDriveMotor;
    public DcMotor bottomLeftDriveMotor;
    public DcMotor topRightDriveMotor;
    public DcMotor bottomRightDriveMotor;
    public static DcMotor armmotorLeft;
    public DcMotor armmotorRight;
    public DcMotor armmotorThird;
    public static DcMotor armslider;
    public static Servo claw1;

    public int hangConstant;
    HardwareMap hwMap;

    public void runOpMode() {
        init(hardwareMap);
        waitForStart();
        claw1.setPosition(0);
        sleep(100);
        armmotorLeft.setPower(0.45);
        armmotorRight.setPower(0.45);
        armmotorThird.setPower(0.45);
        sleep(1600);
        armmotorLeft.setPower(0);
        armmotorRight.setPower(0);
        armmotorThird.setPower(0);
        armslider.setPower(-0.45);
        sleep(1300);
        armslider.setPower(0);
        armmotorLeft.setPower(0);
        armmotorRight.setPower(0);
        armmotorThird.setPower(0);
        topLeftDriveMotor.setPower(0.4);
        bottomLeftDriveMotor.setPower(0.4);
        topRightDriveMotor.setPower(0.4);
        bottomRightDriveMotor.setPower(0.4);
        sleep(1400);
        topLeftDriveMotor.setPower(0);
        bottomLeftDriveMotor.setPower(0);
        topRightDriveMotor.setPower(0);
        bottomRightDriveMotor.setPower(0);
        sleep(400);
        topLeftDriveMotor.setPower(0.45);
        bottomLeftDriveMotor.setPower(0.45);
        topRightDriveMotor.setPower(0.45);
        bottomRightDriveMotor.setPower(0.45);
        sleep(200);
        topLeftDriveMotor.setPower(0);
        bottomLeftDriveMotor.setPower(0);
        topRightDriveMotor.setPower(0);
        bottomRightDriveMotor.setPower(0);
        sleep(200);
        claw1.setPosition(0.25);
        topLeftDriveMotor.setPower(-0.45);
        bottomLeftDriveMotor.setPower(-0.45);
        topRightDriveMotor.setPower(-0.45);
        bottomRightDriveMotor.setPower(-0.45);
        sleep(900);
        topLeftDriveMotor.setPower(0);
        bottomLeftDriveMotor.setPower(0);
        topRightDriveMotor.setPower(0);
        bottomRightDriveMotor.setPower(0);
        armslider.setPower(0.5);
        sleep(1000);
        armslider.setPower(0);
        armmotorLeft.setPower(-0.5);
        armmotorRight.setPower(-0.5);
        armmotorThird.setPower(-0.5);
        sleep(600);
        armmotorLeft.setPower(0);
        armmotorRight.setPower(0);
        armmotorThird.setPower(0);
//        topLeftDriveMotor.setPower(.5);
//        bottomLeftDriveMotor.setPower(-0.5);
//        topRightDriveMotor.setPower(-.5);
//        bottomRightDriveMotor.setPower(.5);
//        sleep(2300);
//        topLeftDriveMotor.setPower(0);
//        bottomLeftDriveMotor.setPower(0);
//        topRightDriveMotor.setPower(0);
//        bottomRightDriveMotor.setPower(0);
//        sleep(200);
//        topLeftDriveMotor.setPower(-.45);
//        bottomLeftDriveMotor.setPower(-.45);
//        topRightDriveMotor.setPower(-.45);
//        bottomRightDriveMotor.setPower(-.45);
//        sleep(300);
//        topLeftDriveMotor.setPower(0);
//        bottomLeftDriveMotor.setPower(0);
//        topRightDriveMotor.setPower(0);
//        bottomRightDriveMotor.setPower(0);

    }


    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        // Control Hub
        topLeftDriveMotor = hwMap.get(DcMotor.class, "frontleft");
        bottomLeftDriveMotor = hwMap.get(DcMotor.class, "backleft");
        topRightDriveMotor = hwMap.get(DcMotor.class, "frontright");
        bottomRightDriveMotor = hwMap.get(DcMotor.class, "backright");

        // Expansion Hub
        armmotorLeft = hwMap.dcMotor.get("amleft");
        armmotorRight = hwMap.dcMotor.get("amright");
        /* NEW ARM MOTORS
                         |
                         v                 */
        armmotorThird = hwMap.dcMotor.get("amthird");
        armslider = hwMap.dcMotor.get("amslider");
        //wrist = hwMap.crservo.get("wrist");
        claw1 = hwMap.servo.get("claw");
        topLeftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bottomLeftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        topRightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bottomRightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        //THIS IS THE CORRECT ORIENTATION, 3 OF THE MOTORS ARE REVERSED FOR SOME GOD DAMN REASON
        topLeftDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        topRightDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        bottomRightDriveMotor.setDirection(DcMotor.Direction.REVERSE);

        topLeftDriveMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        topRightDriveMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bottomLeftDriveMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bottomRightDriveMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        armmotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armmotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armmotorThird.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armslider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);



    }

}

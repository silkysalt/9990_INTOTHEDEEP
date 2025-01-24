package org.firstinspires.ftc.teamcode.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous(name="Autonomous 2025", group="Robot")
public class Auto extends LinearOpMode {
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
        armmotorLeft.setPower(0.5);
        armmotorRight.setPower(0.5);
        armmotorThird.setPower(0.5);
        sleep(1200);
        armslider.setPower(-0.5);
        sleep(300);
        armmotorLeft.setPower(0);
        armmotorRight.setPower(0);
        armmotorThird.setPower(0);
        topLeftDriveMotor.setPower(0.45);
        bottomLeftDriveMotor.setPower(0.45);
        topRightDriveMotor.setPower(0.45);
        bottomRightDriveMotor.setPower(0.45);
        sleep(1100);
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
        sleep(600);
        topLeftDriveMotor.setPower(0);
        bottomLeftDriveMotor.setPower(0);
        topRightDriveMotor.setPower(0);
        bottomRightDriveMotor.setPower(0);
        armslider.setPower(0.5);
        sleep(1200);
        armmotorLeft.setPower(-0.5);
        armmotorRight.setPower(-0.5);
        armmotorThird.setPower(-0.5);
        sleep(800);
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

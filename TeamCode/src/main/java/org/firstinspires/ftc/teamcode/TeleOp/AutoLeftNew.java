package org.firstinspires.ftc.teamcode.TeleOp;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="Autonomous Left 2025", group="Robot")
public class AutoLeftNew extends LinearOpMode {

    public ColorSensor colorSensor;    // Hardware Device Object
    public DistanceSensor distanceSensor;

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
        claw1.setPosition(1);
        sleep(100);
        moveArm(0.5,1500);

    }


    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;
        colorSensor = hwMap.get(ColorSensor.class, "sensor_color");
        distanceSensor = hwMap.get(DistanceSensor.class, "sensor_color");

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


        // ARM SLIDER MOTOR
        armslider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armslider.setMode(DcMotor.RunMode.RUN_TO_POSITION);



    }
    public void moveForward(double power, long time) {
        topLeftDriveMotor.setPower(power);
        bottomLeftDriveMotor.setPower(power);
        topRightDriveMotor.setPower(power);
        bottomRightDriveMotor.setPower(power);
        sleep(time);
        topLeftDriveMotor.setPower(0);
        bottomLeftDriveMotor.setPower(0);
        topRightDriveMotor.setPower(0);
        bottomRightDriveMotor.setPower(0);
    }
    public void moveLeft(double power, long time) {
        topLeftDriveMotor.setPower(-power);
        bottomLeftDriveMotor.setPower(power);
        topRightDriveMotor.setPower(power);
        bottomRightDriveMotor.setPower(-power);
        sleep(time);
        topLeftDriveMotor.setPower(0);
        bottomLeftDriveMotor.setPower(0);
        topRightDriveMotor.setPower(0);
        bottomRightDriveMotor.setPower(0);
    }
    public void moveRight(double power, long time) {
        topLeftDriveMotor.setPower(power);
        bottomLeftDriveMotor.setPower(-power);
        topRightDriveMotor.setPower(-power);
        bottomRightDriveMotor.setPower(power);
        sleep(time);
        topLeftDriveMotor.setPower(0);
        bottomLeftDriveMotor.setPower(0);
        topRightDriveMotor.setPower(0);
        bottomRightDriveMotor.setPower(0);
    }
    public void moveBackward(double power, long time) {
        topLeftDriveMotor.setPower(-power);
        bottomLeftDriveMotor.setPower(-power);
        topRightDriveMotor.setPower(-power);
        bottomRightDriveMotor.setPower(-power);
        sleep(time);
        topLeftDriveMotor.setPower(0);
        bottomLeftDriveMotor.setPower(0);
        topRightDriveMotor.setPower(0);
        bottomRightDriveMotor.setPower(0);
    }
    public void turnLeft(double power, long time) {
        topLeftDriveMotor.setPower(-power);
        bottomLeftDriveMotor.setPower(-power);
        topRightDriveMotor.setPower(power);
        bottomRightDriveMotor.setPower(power);
        sleep(time);
        topLeftDriveMotor.setPower(0);
        bottomLeftDriveMotor.setPower(0);
        topRightDriveMotor.setPower(0);
        bottomRightDriveMotor.setPower(0);
    }
    public void turnRight(double power, long time) {
        topLeftDriveMotor.setPower(power);
        bottomLeftDriveMotor.setPower(power);
        topRightDriveMotor.setPower(-power);
        bottomRightDriveMotor.setPower(-power);
        sleep(time);
        topLeftDriveMotor.setPower(0);
        bottomLeftDriveMotor.setPower(0);
        topRightDriveMotor.setPower(0);
        bottomRightDriveMotor.setPower(0);
    }
    public void moveArm(double power, long time) {
        armmotorRight.setPower(power);
        armmotorThird.setPower(power);
        armmotorLeft.setPower(power);
        sleep(time);
        armmotorRight.setPower(0);
        armmotorThird.setPower(0);
        armmotorLeft.setPower(0);
    }


}

package org.firstinspires.ftc.teamcode.Autonomous;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="New new Auto Left 2025", group="Robot")
public class AutoNewNewLeft extends LinearOpMode {

    public ColorSensor colorSensor;    // Hardware Device Object
    public DistanceSensor distanceSensor;

    public DcMotor topLeftDriveMotor;
    public DcMotor bottomLeftDriveMotor;
    public DcMotor topRightDriveMotor;
    public DcMotor bottomRightDriveMotor;
    public DcMotor armmotorLeft;
    public DcMotor armmotorRight;
    public DcMotor armmotorThird;
    public DcMotor armslider;
    public Servo claw1;
    public double c = 0.5;
    public int hangConstant;
    HardwareMap hwMap;

    public void runOpMode() {
        init(hardwareMap);
        waitForStart();
        claw1.setPosition(1);
        sleep(100);

        //moveForward(500,0.25);
        //turnLeft(1130,0.25);
        moveRight(300,.5);
        moveArm(2200,0.5);
        moveArmSlider(2050,1);
        moveForward(850,0.25);
        turnLeft(350,.5);
        moveForward(175,.5);
        claw1.setPosition(0.75);
        sleep(1000);
        moveBackward(450,0.25);
        moveArmSlider(-2050,1);
        moveArm(-2000,0.5);
        turnRight(1300,0.25);
        moveForward(450,.5);
        moveLeft(400,.35);
        moveArmSlider(650,1);
        moveArm(-50,0.5);
        claw1.setPosition(1);
        sleep(1000);
        moveArm(2050,.5);
        moveBackward(450,.5);
        turnLeft(1200,.5);
        moveArmSlider(1650,0.5);
        moveForward(600,.5);
        claw1.setPosition(.75);
        sleep(1000);
        moveBackward(450,.5);
        moveArmSlider(-2050,1);
        moveArm(-1800,0.5);
        turnRight(1500,0.25);





//        moveForward(200,0.25);
//        turnLeft(600,0.25); // 90 Degree turn
//        moveForward(400,0.25);
//        turnLeft(400,0.25);

//        turnRight(900,0.25);
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

        //Correct Orientation
        //topLeftDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        bottomLeftDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        topRightDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        armslider.setDirection(DcMotor.Direction.REVERSE);
        //bottomRightDriveMotor.setDirection(DcMotor.Direction.REVERSE);

        topLeftDriveMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        topRightDriveMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bottomLeftDriveMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        bottomRightDriveMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        armmotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armmotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armmotorThird.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        armslider.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        // ARM SLIDER MOTOR
        topLeftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topRightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomLeftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomRightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armmotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armmotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armmotorThird.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armslider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armslider.setDirection(DcMotor.Direction.REVERSE);



    }
    public void moveForward(int position, double power) {
//        topLeftDriveMotor.setPower(power);
//        bottomLeftDriveMotor.setPower(power);
//        topRightDriveMotor.setPower(power);
//        bottomRightDriveMotor.setPower(power);
//        sleep(time);
//        topLeftDriveMotor.setPower(0);
//        bottomLeftDriveMotor.setPower(0);
//        topRightDriveMotor.setPower(0);
//        bottomRightDriveMotor.setPower(0);
        topLeftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topRightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomLeftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomRightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        topLeftDriveMotor.setTargetPosition(position);
        topRightDriveMotor.setTargetPosition(position);
        bottomLeftDriveMotor.setTargetPosition(position);
        bottomRightDriveMotor.setTargetPosition((int) (position*c));

        topLeftDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        topRightDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bottomLeftDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bottomRightDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(topLeftDriveMotor.isBusy()){
            topLeftDriveMotor.setPower(power);
            topRightDriveMotor.setPower(power);
            bottomLeftDriveMotor.setPower(power);
            bottomRightDriveMotor.setPower(power);
        }




    }
    public void moveLeft(int position, double power) {
//        topLeftDriveMotor.setPower(-power);
//        bottomLeftDriveMotor.setPower(power);
//        topRightDriveMotor.setPower(power);
//        bottomRightDriveMotor.setPower(-power);
//        sleep(time);
//        topLeftDriveMotor.setPower(0);
//        bottomLeftDriveMotor.setPower(0);
//        topRightDriveMotor.setPower(0);
//        bottomRightDriveMotor.setPower(0);
        topLeftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topRightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomLeftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomRightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        topLeftDriveMotor.setTargetPosition(-position);
        topRightDriveMotor.setTargetPosition(position);
        bottomLeftDriveMotor.setTargetPosition(position);
        bottomRightDriveMotor.setTargetPosition(-(int) (position*c));

        topLeftDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        topRightDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bottomLeftDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bottomRightDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (topLeftDriveMotor.isBusy()){
            topLeftDriveMotor.setPower(power);
            topRightDriveMotor.setPower(power);
            bottomLeftDriveMotor.setPower(power);
            bottomRightDriveMotor.setPower(power);
        }
    }
    public void moveRight(int position, double power) {
//        topLeftDriveMotor.setPower(power);
//        bottomLeftDriveMotor.setPower(-power);
//        topRightDriveMotor.setPower(-power);
//        bottomRightDriveMotor.setPower(power);
//        sleep(time);
//        topLeftDriveMotor.setPower(0);
//        bottomLeftDriveMotor.setPower(0);
//        topRightDriveMotor.setPower(0);
//        bottomRightDriveMotor.setPower(0);
        topLeftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topRightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomLeftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomRightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        topLeftDriveMotor.setTargetPosition(position);
        topRightDriveMotor.setTargetPosition(-position);
        bottomLeftDriveMotor.setTargetPosition(-position);
        bottomRightDriveMotor.setTargetPosition((int) (position*c));

        topLeftDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        topRightDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bottomLeftDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bottomRightDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (topLeftDriveMotor.isBusy()){
            topLeftDriveMotor.setPower(power);
            topRightDriveMotor.setPower(power);
            bottomLeftDriveMotor.setPower(power);
            bottomRightDriveMotor.setPower(power);
        }
    }
    public void moveBackward(int position, double power) {
//        topLeftDriveMotor.setPower(-power);
//        bottomLeftDriveMotor.setPower(-power);
//        topRightDriveMotor.setPower(-power);
//        bottomRightDriveMotor.setPower(-power);
//        sleep(time);
//        topLeftDriveMotor.setPower(0);
//        bottomLeftDriveMotor.setPower(0);
//        topRightDriveMotor.setPower(0);
//        bottomRightDriveMotor.setPower(0);
        topLeftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topRightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomLeftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomRightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        topLeftDriveMotor.setTargetPosition(-position);
        topRightDriveMotor.setTargetPosition(-position);
        bottomLeftDriveMotor.setTargetPosition(-position);
        bottomRightDriveMotor.setTargetPosition(-(int) (position*c));

        topLeftDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        topRightDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bottomLeftDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bottomRightDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while (topLeftDriveMotor.isBusy()){
            topLeftDriveMotor.setPower(power);
            topRightDriveMotor.setPower(power);
            bottomLeftDriveMotor.setPower(power);
            bottomRightDriveMotor.setPower(power);
        }
    }
    public void turnLeft(int position, double power) {
//        topLeftDriveMotor.setPower(-power);
//        bottomLeftDriveMotor.setPower(-power);
//        topRightDriveMotor.setPower(power);
//        bottomRightDriveMotor.setPower(power);
//        sleep(time);
//        topLeftDriveMotor.setPower(0);
//        bottomLeftDriveMotor.setPower(0);
//        topRightDriveMotor.setPower(0);
//        bottomRightDriveMotor.setPower(0);
        topLeftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topRightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomLeftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomRightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        topLeftDriveMotor.setTargetPosition(-position);
        topRightDriveMotor.setTargetPosition(position);
        bottomLeftDriveMotor.setTargetPosition(-position);
        bottomRightDriveMotor.setTargetPosition((int) (position*c));

        topLeftDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        topRightDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bottomLeftDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bottomRightDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(topLeftDriveMotor.isBusy()){
            topLeftDriveMotor.setPower(power);
            topRightDriveMotor.setPower(power);
            bottomLeftDriveMotor.setPower(power);
            bottomRightDriveMotor.setPower(power);
        }
    }
    public void turnRight(int position, double power) {
//        topLeftDriveMotor.setPower(power);
//        bottomLeftDriveMotor.setPower(power);
//        topRightDriveMotor.setPower(-power);
//        bottomRightDriveMotor.setPower(-power);
//        sleep(time);
//        topLeftDriveMotor.setPower(0);
//        bottomLeftDriveMotor.setPower(0);
//        topRightDriveMotor.setPower(0);
//        bottomRightDriveMotor.setPower(0);
        topLeftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        topRightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomLeftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        bottomRightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        topLeftDriveMotor.setTargetPosition(position);
        topRightDriveMotor.setTargetPosition(-position);
        bottomLeftDriveMotor.setTargetPosition(position);
        bottomRightDriveMotor.setTargetPosition(-(int) (position*c));

        topLeftDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        topRightDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bottomLeftDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bottomRightDriveMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(topLeftDriveMotor.isBusy()){
            topLeftDriveMotor.setPower(power);
            topRightDriveMotor.setPower(power);
            bottomLeftDriveMotor.setPower(power);
            bottomRightDriveMotor.setPower(power);
        }
    }
    public void moveArm(int position, double power) {
//        armmotorRight.setPower(power);
//        armmotorThird.setPower(power);
//        armmotorLeft.setPower(power);
//        sleep(time);
//        armmotorRight.setPower(0);
//        armmotorThird.setPower(0);
//        armmotorLeft.setPower(0);
        armmotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armmotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armmotorThird.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        armmotorLeft.setTargetPosition(position);
        armmotorRight.setTargetPosition(position);
        armmotorThird.setTargetPosition(position);

        armmotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armmotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armmotorThird.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        while(armmotorLeft.isBusy()){
            armmotorLeft.setPower(power);
            armmotorRight.setPower(power);
            armmotorThird.setPower(power);
        }
    }
    public void moveArmSlider(int position, double power) {
        armslider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        armslider.setTargetPosition(position);
        armslider.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        while(armslider.isBusy()){
            armslider.setPower(power);
        }

    }




}

package org.firstinspires.ftc.teamcode.TeleOp;
;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class TestingOpMode extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Drivetrain drivetrain = new Drivetrain();
        drivetrain.init(hardwareMap);
        waitForStart();
        while (opModeIsActive()){
            //no odometry because i am dumb
            telemetry.addData("top left drive", drivetrain.topLeftDriveMotor.getCurrentPosition());
            telemetry.addData("top right drive", drivetrain.topRightDriveMotor.getCurrentPosition());
            telemetry.addData("bottom left drive", drivetrain.bottomLeftDriveMotor.getCurrentPosition());
            telemetry.addData("bottom right drive", drivetrain.bottomRightDriveMotor.getCurrentPosition());
            telemetry.addData("arm motor left", drivetrain.armmotorLeft.getCurrentPosition());
            telemetry.addData("arm motor right", drivetrain.armmotorRight.getCurrentPosition());
            telemetry.addData("arm motor third", drivetrain.armmotorThird.getCurrentPosition());
            telemetry.addData("arm slider pos", drivetrain.armslider.getCurrentPosition());
            telemetry.addData("servo arm pos", drivetrain.claw1.getPosition());
            telemetry.update();



            if (gamepad1.a) {
                drivetrain.topLeftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                drivetrain.topRightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                drivetrain.bottomLeftDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                drivetrain.bottomRightDriveMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                drivetrain.armmotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                drivetrain.armmotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                drivetrain.armmotorThird.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                drivetrain.armslider.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

                drivetrain.topLeftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                drivetrain.bottomLeftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                drivetrain.topRightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                drivetrain.bottomRightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                drivetrain.armmotorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                drivetrain.armmotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                drivetrain.armmotorThird.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                drivetrain.armslider.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            }
            //drivetrain.armScoopMovement(gamepad1, gamepad2);
            double lsy = gamepad1.left_stick_y;
            double lsx = gamepad1.left_stick_x;
            double rsx = gamepad1.right_stick_x;

            if (gamepad1.left_trigger > 0){
                drivetrain.moveRobot(.1* lsy, .1*  lsx, .1*  rsx);
                drivetrain.armMovement(gamepad1, gamepad2,0.85);
            }
            else{
                drivetrain.moveRobot(lsy, lsx, rsx);
                drivetrain.armMovement(gamepad1, gamepad2,0.85);
            }
        }
    }
}

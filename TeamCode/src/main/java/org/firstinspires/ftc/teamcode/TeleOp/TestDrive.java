package org.firstinspires.ftc.teamcode.TeleOp;

import static org.firstinspires.ftc.teamcode.TeleOp.Drivetrain.armslider;
import static org.firstinspires.ftc.teamcode.TeleOp.Drivetrain.claw1;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TestDrive extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Drivetrain drivetrain = new Drivetrain();
        drivetrain.init(hardwareMap);
        waitForStart();
        while (opModeIsActive()){
            //no odometry because they keep changing our shit
            //telemetry.addData("rightodo", drivetrain.rightOdo.getCurrentPosition());
            //telemetry.addData("leftodo", drivetrain.leftOdo.getCurrentPosition());
            //telemetry.addData("midodo", drivetrain.midOdo.getCurrentPosition());
            telemetry.addData("armsliderpos", armslider.getCurrentPosition());
            telemetry.addData("servoarmpos", claw1.getPosition());
            telemetry.update();




            //drivetrain.armScoopMovement(gamepad1, gamepad2);
            double lsy = gamepad1.left_stick_y;
            double lsx = gamepad1.left_stick_x;
            double rsx = gamepad1.right_stick_x;

            if (gamepad1.left_trigger > 0){
                drivetrain.moveRobot(.4* lsy, .4*  lsx, .4*  rsx);
                drivetrain.armMovement(gamepad1, gamepad2);
            }
            else{
                drivetrain.moveRobot(lsy, lsx, rsx);
                drivetrain.armMovement(gamepad1, gamepad2);
            }
        }
    }
}

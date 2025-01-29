package org.firstinspires.ftc.teamcode.tuning;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ProfileAccelConstraint;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.TranslationalVelConstraint;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.TankDrive;

public final class SplineTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d beginPose = new Pose2d(-10, 62, Math.toRadians(270));
        if (TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) {
            MecanumDrive drive = new MecanumDrive(hardwareMap, beginPose);
            waitForStart();
            Actions.runBlocking(

                    drive.actionBuilder(beginPose)
                            .lineToY(35)
//                            .lineToX(30)
//                            .turn(Math.toRadians(90))
//                            .lineToY(30)
//                            .turn(Math.toRadians(90))
//                            .lineToX(0)
//                            .turn(Math.toRadians(90))
//                            .lineToY(0)
//                            .turn(Math.toRadians(90))
                            .build());
//                            .splineTo(new Vector2d(-5, 50), Math.toRadians(-90), new TranslationalVelConstraint(20.0), new ProfileAccelConstraint(-10.0, 10.0))
//                            .waitSeconds(1)
//                            //.back(16)
//                            .strafeTo(new Vector2d(-5.5, 55))
//                            .splineToConstantHeading(new Vector2d(-36, 28), Math.toRadians(-90))
//                            .splineTo(new Vector2d(-43, 5), Math.toRadians(-90))
//                            //.back(50)
//                            .strafeTo(new Vector2d(-48, 55))
//                            .waitSeconds(.5)
//                            .splineTo(new Vector2d(-47, 5), Math.toRadians(-90))
//                            //.strafeRight(4)
//                            .strafeTo(new Vector2d(-51, 5))
//                            //.back(50)
//                            .strafeTo(new Vector2d(-51, 55))
//                            .waitSeconds(.5)
//                            .splineTo(new Vector2d(-57, 5), Math.toRadians(-90))
//                            //.strafeRight(3.25)
//                            .strafeTo(new Vector2d(-60.25, 5))
//                            //.back(55)
//                            .strafeTo(new Vector2d(-60.25, 60))
//                            .waitSeconds(3) //take out of time
//                            .build());
//                        .splineTo(new Vector2d(-5,35), Math.toRadians(-90))
//                        .waitSeconds(3)
//                        .back(16)
//                        .splineToConstantHeading(new Vector2d(-36,28), Math.toRadians(-90))
//                        .splineTo(new Vector2d(-43,5), Math.toRadians(-90))
//                        .back(50)
//                        .waitSeconds(.5)
//                        .splineTo(new Vector2d(-47, 5), Math.toRadians(-90))
//                        .strafeRight(4)
//                        .back(50)
//                        .waitSeconds(.5)
//                        .splineTo(new Vector2d(-57, 5), Math.toRadians(-90))
//                        .strafeRight(3.25)
//                        .back(55)
//                        .waitSeconds(3) //take out of time


        } else if (TuningOpModes.DRIVE_CLASS.equals(TankDrive.class)) {
            TankDrive drive = new TankDrive(hardwareMap, beginPose);

            waitForStart();

            Actions.runBlocking(
                    drive.actionBuilder(beginPose)
                            .splineTo(new Vector2d(30, 30), Math.PI / 2)
                            .splineTo(new Vector2d(0, 60), Math.PI)
                            .build());
        } else {
            throw new RuntimeException();
        }
    }
}



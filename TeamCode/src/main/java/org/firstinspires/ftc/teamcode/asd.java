
//package org.firstinspires.ftc.teamcode;
//
//// RR-specific imports
//import com.acmerobotics.dashboard.config.Config;
//
//// Non-RR imports
//import com.acmerobotics.roadrunner.Pose2d;
//import com.acmerobotics.roadrunner.ProfileAccelConstraint;
//import com.acmerobotics.roadrunner.TranslationalVelConstraint;
//import com.acmerobotics.roadrunner.Vector2d;
//import com.acmerobotics.roadrunner.ftc.Actions;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//
//@Config
//@Autonomous(name = "autonomous 2025", group = "Autonomous")
//public class asd extends LinearOpMode {
//    public void runOpMode() throws InterruptedException {
//        // instantiate your MecanumDrive at a particular pose.
//        Pose2d initialPose = new Pose2d(-16, 62, 29.823);
//        MecanumDrive drive = new MecanumDrive(hardwareMap, initialPose);
//        waitForStart();
//        Actions.runBlocking(
//
//                drive.actionBuilder(beginPose)
//                        .splineTo(new Vector2d(-5, 50), Math.toRadians(-90), new TranslationalVelConstraint(20.0), new ProfileAccelConstraint(-10.0, 10.0))
//                        .waitSeconds(100)
//                        //.back(16)
//                        .strafeTo(new Vector2d(-5.5, 55))
//                        .splineToConstantHeading(new Vector2d(-36, 28), Math.toRadians(-90))
//                        .splineTo(new Vector2d(43, 5), Math.toRadians(-90))
//                        //.back(50)
//                        .strafeTo(new Vector2d(48, 55))
//                        .waitSeconds(.5)
//                        .splineTo(new Vector2d(47, 5), Math.toRadians(-90))
//                        //.strafeRight(4)
//                        .strafeTo(new Vector2d(51, 5))
//                        //.back(50)
//                        .strafeTo(new Vector2d(51, 55))
//                        .waitSeconds(.5)
//                        .splineTo(new Vector2d(57, 5), Math.toRadians(-90))
//                        //.strafeRight(3.25)
//                        .strafeTo(new Vector2d(60.25, 5))
//                        //.back(55)
//                        .strafeTo(new Vector2d(60.25, 60))
//                        .waitSeconds(3) //take out of time
//                        .build());
//    }
//}


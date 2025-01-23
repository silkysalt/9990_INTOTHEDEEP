package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;

import org.rowlandhall.meepmeep.MeepMeep;
import org.rowlandhall.meepmeep.roadrunner.DefaultBotBuilder;
import org.rowlandhall.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(500);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive -> drive.trajectorySequenceBuilder(new Pose2d(-16, 62, 29.823))
                        //.splineTo(new Vector2d(30, 30), Math.PI / 2)
                        //.splineTo(new Vector2d(0, 60), Math.PI)
                        //.build());
                        // funny .splineTo(new Vector2d(0.0, 40.0), 0.0)
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
                        .splineTo(new Vector2d(-5,40), Math.toRadians(-90))
                        .waitSeconds(3)
                        //.back(16)
                        .strafeTo(new Vector2d(-5.5, 55))
                        .splineToConstantHeading(new Vector2d(-36,28), Math.toRadians(-90))
                        .splineTo(new Vector2d(-43,5), Math.toRadians(-90))
                        //.back(50)
                        .strafeTo(new Vector2d(-48, 55))
                        .waitSeconds(.5)
                        .splineTo(new Vector2d(-47, 5), Math.toRadians(-90))
                        //.strafeRight(4)
                        .strafeTo(new Vector2d(-51, 5))
                        //.back(50)
                        .strafeTo(new Vector2d(-51, 55))
                        .waitSeconds(.5)
                        .splineTo(new Vector2d(-57, 5), Math.toRadians(-90))
                        //.strafeRight(3.25)
                        .strafeTo(new Vector2d(-60.25, 5))
                        //.back(55)
                        .strafeTo(new Vector2d(-60.25, 60))
                        .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_INTOTHEDEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
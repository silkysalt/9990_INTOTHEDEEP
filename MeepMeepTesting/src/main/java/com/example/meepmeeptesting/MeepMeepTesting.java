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
                        .splineTo(new Vector2d(-5,35), Math.toRadians(-90))
                        .waitSeconds(3)
                        .back(16)
                        .splineToConstantHeading(new Vector2d(-36,28), Math.toRadians(-90))
                        .splineTo(new Vector2d(-43,5), Math.toRadians(-90))
                        .back(50)
                        .waitSeconds(1)
                        .splineTo(new Vector2d(-47, 5), Math.toRadians(-90))
                        .strafeRight(4)
                        .back(50)
                        .waitSeconds(1)
                        .splineTo(new Vector2d(-57, 5), Math.toRadians(-90))
                        .strafeRight(3.25)
                        .back(55)
                        .waitSeconds(3)

                        .build());


        meepMeep.setBackground(MeepMeep.Background.FIELD_INTOTHEDEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}
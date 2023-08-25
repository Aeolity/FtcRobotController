package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class testOPmode extends LinearOpMode{
    private Gyroscope imu;
    private DcMotor frontRight;
    private DcMotor frontLeft;
    private DcMotor backRight;
    private DcMotor backLeft;
    //private DigitalChannel digitalTouch;
    //private DistanceSensor sensorColorRange;
    private Servo servoTest;


    @Override
    public void runOpMode() {
        imu = hardwareMap.get(Gyroscope.class, "imu");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        //digitalTouch = hardwareMap.get(DigitalChannel.class, "digitalTouch");
        //sensorColorRange = hardwareMap.get(DistanceSensor.class, "sensorColorRange");


        telemetry.addData("Status", "Initialized");
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        double tgtPowerLeft=0;
        double tgtPowerRight=0;


        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            tgtPowerLeft = this.gamepad1.left_stick_y;
            tgtPowerRight = -this.gamepad1.right_stick_y;


            frontLeft.setPower(tgtPowerLeft);
            backLeft.setPower(tgtPowerLeft);
            frontRight.setPower(tgtPowerRight);
            backRight.setPower(tgtPowerRight);


            telemetry.addData("Target Power Left", tgtPowerLeft);
            telemetry.addData("Target Power Right", tgtPowerRight);
            telemetry.addData("Motor Power frontRight", frontRight.getPower());
            telemetry.addData("Motor Power frontLeft", frontLeft.getPower());
            telemetry.addData("Motor Power backRight", backRight.getPower());
            telemetry.addData("Motor Power backLeft", backLeft.getPower());
            telemetry.addData("Status", "Running");
            telemetry.update();

        }
    }
}


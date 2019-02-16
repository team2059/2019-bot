package frc.robot.commands.Elevator;

import frc.robot.RobotMap;
import frc.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class PIDCarriageElevate extends PIDCommand {

    public PIDCarriageElevate(double inches) {
        super(RobotMap.carriageElevatorP, RobotMap.carriageElevatorI, RobotMap.carriageElevatorD);

        setSetpoint(inches);
    }

    protected void initialize() {
        setTimeout(6);
    }

    @Override
    protected double returnPIDInput() {
        return CommandBase.elevator.getCarriageEncoder();
    }

    @Override
    protected void usePIDOutput(double speed) {
        CommandBase.elevator.carriageElevator(speed);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut()  || Math.abs(getSetpoint() - getPosition()) < .5;
    }

    protected void end() {
        System.out.println("End");
        setTimeout(0);
    }

    protected void interrupted() {
        end();
    }
}

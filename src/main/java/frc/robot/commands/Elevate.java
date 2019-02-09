package frc.robot.commands;

public class Elevate extends CommandBase {

    double speed;
    public Elevate(double s){
      speed = s;
    }

    @Override
    protected void initialize(){}

    @Override
    protected void execute(){
      elevator.mainElevate(speed);
    }

    @Override
    protected void interrupted(){
      end();
    }

    protected boolean isFinished() {
      return isTimedOut();
    }

    @Override
    protected void end(){
        elevator.mainElevate(0);
    }
}

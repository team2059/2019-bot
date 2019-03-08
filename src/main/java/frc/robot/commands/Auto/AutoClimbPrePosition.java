package frc.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Arm.PIDWrist;
import frc.robot.commands.Elevator.PIDCarriageElevate;
import frc.robot.commands.Elevator.PIDElevate;


public class AutoClimbPrePosition extends CommandGroup {

    public AutoClimbPrePosition(int level) {
        if (level == 2){
            addParallel(new PIDCarriageElevate(12));
            addSequential(new PIDWrist(40));
        } else {
            addParallel(new PIDCarriageElevate(23));
            addSequential(new PIDWrist(40));
        }
    }
}

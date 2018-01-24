package org.usfirst.frc.team2832.robot.commands;

import org.usfirst.frc.team2832.robot.Controls;
import org.usfirst.frc.team2832.robot.Robot;
import org.usfirst.frc.team2832.robot.subsystems.Lift;

import edu.wpi.first.wpilibj.command.Command;

public class LiftDistance extends Command {

	private double currentPos;
	private double heightScale;
	private double heightSwitch;
	private double heightIntake;
	//Number of encoder counts to raise to
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public LiftDistance() {
		requires(Robot.lift);
	}
	
	protected void execute() {
		currentPos = Lift.liftEncoder.getRaw();

		if(Robot.controls.getButtonPressed(Controls.Controllers.CONTROLLER_MAIN, Controls.Buttons.X)) {//Change button (D-pad?)
			if(currentPos < heightScale) {
				while(currentPos < heightScale) {
					Lift.talonLift.set(0.1);
				}
			}
			else if(currentPos > heightScale) {
				while(currentPos > heightScale) {
					Lift.talonLift.set(-0.1);
				}
			}
			
		}
		if(Robot.controls.getButtonPressed(Controls.Controllers.CONTROLLER_MAIN, Controls.Buttons.A)) {
			if(currentPos < heightSwitch) {
				while(currentPos < heightSwitch) {
					Lift.talonLift.set(0.2);
				}
			}
			
		}
		if(Robot.controls.getButtonPressed(Controls.Controllers.CONTROLLER_MAIN, Controls.Buttons.B)) {
			if(currentPos > heightIntake) {
				while(currentPos > heightIntake) {
					Lift.talonLift.set(0.1);
				}
			}
		}
	}
}
	

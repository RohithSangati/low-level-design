package command;

import receiver.AirConditioner;

public class TurnOnAcCommand implements ICommand {

	AirConditioner airConditioner;

	public TurnOnAcCommand(AirConditioner airConditioner) {
		this.airConditioner = airConditioner;
	}

	public void execute() {
		airConditioner.turnOnAc();
	}
	
	public void undo() {
		airConditioner.turnOffAc();
	}

}

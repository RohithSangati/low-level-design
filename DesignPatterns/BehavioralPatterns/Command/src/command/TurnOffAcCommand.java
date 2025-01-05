package command;

import receiver.AirConditioner;

public class TurnOffAcCommand implements ICommand {

	AirConditioner airConditioner;

	public TurnOffAcCommand(AirConditioner airConditioner) {
		this.airConditioner = airConditioner;
	}

	public void execute() {
		airConditioner.turnOffAc();
	}
	
	public void undo() {
		airConditioner.turnOnAc();
	}

}

import Invoker.RemoteControl;
import command.TurnOffAcCommand;
import command.TurnOnAcCommand;
import receiver.AirConditioner;

public class CommandApplication {

	public static void main(String[] args) {

		AirConditioner airConditioner = new AirConditioner();

		RemoteControl remote = new RemoteControl();

		remote.setCommand(new TurnOnAcCommand(airConditioner));

		remote.pressButton();

		remote.pressButton();

		System.out.println("========================================");

		remote.undo();

		System.out.println("----------------------------------------");

		remote.setCommand(new TurnOffAcCommand(airConditioner));

		remote.pressButton();

		System.out.println("========================================");

		remote.undo();

	}

}
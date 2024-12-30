package Factory;

import Modal.Computer;
import Modal.PC;
import Modal.Server;

public class ComputerFactory {

	public static Computer getComputer(String type, String ram, String cpu, String hdd) {
		switch (type) {
			case "PC":
				return new PC(ram,cpu,hdd);
			case "SERVER":
				return new Server(ram, cpu, hdd);
		}
		return null;
	}

}

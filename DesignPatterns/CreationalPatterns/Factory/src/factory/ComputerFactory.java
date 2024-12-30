package factory;

import model.Computer;
import model.PC;
import model.Server;

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

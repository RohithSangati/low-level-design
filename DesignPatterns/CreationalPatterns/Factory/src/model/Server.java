package model;

public class Server implements Computer {

	private String ram;
	private String cpu;
	private String hdd;

	public Server(String ram, String cpu, String hdd) {
		this.ram = ram;
		this.cpu = cpu;
		this.hdd = hdd;
	}

	public String getRAM() {
		return this.ram;
	}

	public String getCPU() {
		return this.cpu;
	}

	public String getHDD() {
		return this.hdd;
	}

}

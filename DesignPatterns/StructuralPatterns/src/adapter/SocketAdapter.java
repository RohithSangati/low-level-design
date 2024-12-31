package adapter;

import model.Volt;

public interface SocketAdapter {

	public Volt get120Volts();

	public Volt get12Volts();

	public Volt get3Volts();

}

package adapter;

import model.Socket;
import model.Volt;

public class SocketAdapterImpl implements SocketAdapter {

	Socket socket;

	public SocketAdapterImpl() {
		socket = new Socket();
	}

	@Override
	public Volt get120Volts() {
		return modifyVolts(socket.getVolts(), 1);
	}

	@Override
	public Volt get12Volts() {
		return modifyVolts(socket.getVolts(), 10);
	}

	@Override
	public Volt get3Volts() {
		return modifyVolts(socket.getVolts(), 40);
	}

	public Volt modifyVolts(Volt volt, int degradeNumber) {
		return new Volt(volt.getVolts() / degradeNumber);
	}

}

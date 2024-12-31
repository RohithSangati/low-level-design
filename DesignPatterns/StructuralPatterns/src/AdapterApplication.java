import adapter.SocketAdapter;
import adapter.SocketAdapterImpl;

public class AdapterApplication {

	public static void main(String[] args) {

		SocketAdapter socketAdapter = new SocketAdapterImpl();
		
		//Converting default Socket 120V to 3V using adapter
		System.out.println(socketAdapter.get3Volts().getVolts());
		
		//Converting default Socket 120V to 12V using adapter
		System.out.print(socketAdapter.get12Volts().getVolts());

	}

}
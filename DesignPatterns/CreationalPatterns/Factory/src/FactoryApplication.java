import factory.ComputerFactory;
import model.Computer;

public class FactoryApplication {

	// Making Factory class as Singleton as we don't need object for it
	private FactoryApplication() {
	};

	public static void main(String[] args) {

		Computer pc = ComputerFactory.getComputer("PC", "2GB", "2.5Ghz", "512GB");
		System.out.println(pc.toString());

		Computer server = ComputerFactory.getComputer("SERVER", "16GB", "5GHZ", "1TB");
		System.out.println(server.toString());

	}
}
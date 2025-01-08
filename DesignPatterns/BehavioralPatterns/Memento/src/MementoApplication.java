import memento.ConfigurationCareTaker;
import memento.ConfigurationMemento;
import memento.ConfigurationOriginator;

public class MementoApplication {

	public static void main(String[] args) {

		ConfigurationOriginator config = new ConfigurationOriginator(10, 20);
		ConfigurationCareTaker careTaker = new ConfigurationCareTaker();

		System.out.println(config);
		System.out.println("===============================");

		ConfigurationMemento memento = config.createMemento();
		careTaker.addMemento(memento);

		config.setHeight(123);

		System.out.println(config);
		System.out.println("===============================");

		memento = config.createMemento();
		careTaker.addMemento(memento);

		config.setWidth(230);

		System.out.println(config);
		System.out.println("===============================");

		config.restorMemento(careTaker);

		System.out.println(config);
		System.out.println("===============================");

	}
}
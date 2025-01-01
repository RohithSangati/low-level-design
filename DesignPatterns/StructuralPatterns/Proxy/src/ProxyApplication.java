import model.Monument;
import model.Person;
import proxy.TajMahalProxy;

public class ProxyApplication {

	public static void main(String[] agrs) {

		Monument tajMahalProxy = new TajMahalProxy();
		tajMahalProxy.enter(new Person("DoraBabu"));
		tajMahalProxy.enter(new Person("Moulika"));
		tajMahalProxy.enter(new Person("Varalakshmi"));
		tajMahalProxy.enter(new Person("Madhava Reddy"));
		tajMahalProxy.enter(new Person("Rohith"));
	}

}
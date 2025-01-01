package proxy;

import model.Monument;
import model.Person;
import model.TajMahal;

public class TajMahalProxy implements Monument {

	public static int MAX_ALLOWED_PERSONS = 4;
	public static int currentCount = 0;
	public TajMahal tajMahal;

	public TajMahalProxy() {
		tajMahal = new TajMahal();
	}

	public void enter(Person person) {
		if (currentCount < MAX_ALLOWED_PERSONS) {
			tajMahal.enter(person);
			currentCount++;
		} else {
			System.out.println("Max limit reached to enter TajMahal.Person - " + person.getName() + " is not allowd");
		}

	}

}

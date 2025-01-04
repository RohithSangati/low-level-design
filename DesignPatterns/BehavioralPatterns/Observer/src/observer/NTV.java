package observer;

import observable.NewsAgencyObservable;

public class NTV implements NewsObserver {

	public void update(NewsAgencyObservable observable) {
		System.out.println("NTV recieved update from news agency - " + observable.getNews());
	}

}

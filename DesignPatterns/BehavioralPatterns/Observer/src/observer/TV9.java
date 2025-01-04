package observer;

import observable.NewsAgencyObservable;

public class TV9 implements NewsObserver {

	public void update(NewsAgencyObservable observable) {
		System.out.println("Tv9 received updated from news agency - " + observable.getNews());
	}
	
}

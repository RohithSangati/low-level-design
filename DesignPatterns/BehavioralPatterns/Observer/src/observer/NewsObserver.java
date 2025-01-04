package observer;

import observable.NewsAgencyObservable;

public interface NewsObserver {

	public void update(NewsAgencyObservable observable);

}

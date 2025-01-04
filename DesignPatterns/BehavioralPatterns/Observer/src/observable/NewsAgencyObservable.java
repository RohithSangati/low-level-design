package observable;

import observer.NewsObserver;

public interface NewsAgencyObservable {

	public void addNewsObserver(NewsObserver newsObserver);

	public void notifyObservers();

	public void setNews(String news);

	public String getNews();

}

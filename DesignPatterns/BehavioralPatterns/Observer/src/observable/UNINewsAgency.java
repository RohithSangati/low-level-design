package observable;

import java.util.ArrayList;
import java.util.List;

import observer.NewsObserver;

public class UNINewsAgency implements NewsAgencyObservable {

	private List<NewsObserver> newsChannels;
	private String news;

	public UNINewsAgency() {
		this.newsChannels = new ArrayList<>();
	}

	public void addNewsObserver(NewsObserver newsObserver) {
		this.newsChannels.add(newsObserver);
	}

	public void notifyObservers() {
		for (NewsObserver newsChannel : newsChannels) {
			newsChannel.update(this);
		}
	}

	public void setNews(String news) {
		this.news = news;
		notifyObservers();
	}

	public String getNews() {
		return this.news;
	}

}

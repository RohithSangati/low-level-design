import observable.NewsAgencyObservable;
import observable.UNINewsAgency;
import observer.NTV;
import observer.TV9;

public class ObserverApplication {

	public static void main(String[] args) {

		NewsAgencyObservable newsAgency = new UNINewsAgency();

		newsAgency.addNewsObserver(new TV9());

		newsAgency.addNewsObserver(new NTV());
		
		
		newsAgency.setNews("India won the toss and Elected to bat first!!!!");
		
		System.out.println("================================================");
		
		newsAgency.setNews("India won the match!!!!!!!!");

	}

}
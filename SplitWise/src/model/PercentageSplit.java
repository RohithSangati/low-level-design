package model;

public class PercentageSplit extends Split {

	double perCentage;

	public PercentageSplit(double perCentage, double amount,User user) {
		super(amount * perCentage / 100.0,user);
	}

}

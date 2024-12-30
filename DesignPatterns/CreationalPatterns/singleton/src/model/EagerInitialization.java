package model;

public class EagerInitialization{
	
	private static EagerInitialization INSTANCE = new EagerInitialization();
	
	private EagerInitialization() {}

	public static EagerInitialization getSingletonInstance() {
		return INSTANCE;
	}

}

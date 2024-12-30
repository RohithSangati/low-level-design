package model;

public class LazyInitialization {
	
	private static LazyInitialization INSTANCE;
	
	private LazyInitialization() {}
	
	public static LazyInitialization getSingletonInstance() {
		if(INSTANCE == null) {
			INSTANCE = new LazyInitialization();
		}
		return INSTANCE;
	}

}

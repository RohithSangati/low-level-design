package model;

public class ThreadSafeInitialization {
	
	private static ThreadSafeInitialization INSTANCE;
	
	private ThreadSafeInitialization() {};
	
	public static synchronized ThreadSafeInitialization getSingletonInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ThreadSafeInitialization();
		}
		return INSTANCE;
	}

}

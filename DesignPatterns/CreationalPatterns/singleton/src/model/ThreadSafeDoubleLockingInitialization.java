package model;


public class ThreadSafeDoubleLockingInitialization {

	private static ThreadSafeDoubleLockingInitialization INSTANCE;

	private ThreadSafeDoubleLockingInitialization() {
	}

	public static ThreadSafeDoubleLockingInitialization getSingletonInstance() {
		if (INSTANCE == null) {
			synchronized (ThreadSafeDoubleLockingInitialization.class) {
				if (INSTANCE == null) {
					INSTANCE = new ThreadSafeDoubleLockingInitialization();
				}
			}
		}
		return INSTANCE;
	}

}

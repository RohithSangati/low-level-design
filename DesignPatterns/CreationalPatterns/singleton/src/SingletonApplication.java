import model.EagerInitialization;
import model.LazyInitialization;
import model.StaticBlockEagerInstantiation;
import model.ThreadSafeDoubleLockingInitialization;
import model.ThreadSafeInitialization;

public class SingletonApplication {

	public static void main(String[] args) {

		// Eager Instantiation
		EagerInitialization eagerObj = EagerInitialization.getSingletonInstance();
		System.out.println(eagerObj.toString());

		// Static Block Eager Instantiation
		StaticBlockEagerInstantiation staticBloackEagerObj = StaticBlockEagerInstantiation.getSingletonInstance();
		System.out.println(staticBloackEagerObj.toString());

		// Lazy Instantiation
		LazyInitialization lazyObj = LazyInitialization.getSingletonInstance();
		System.out.println(lazyObj.toString());

		// ThreasSafe Lazy Instantiation
		ThreadSafeInitialization threadSafeLazyObj = ThreadSafeInitialization.getSingletonInstance();
		System.out.println(threadSafeLazyObj.toString());

		// ThreasSafe Double Locking Instantiation
		ThreadSafeDoubleLockingInitialization threadSafeDoubleLockingObj = ThreadSafeDoubleLockingInitialization
				.getSingletonInstance();
		System.out.println(threadSafeDoubleLockingObj.toString());

	}

}

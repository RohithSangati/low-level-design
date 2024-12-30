package model;

public class StaticBlockEagerInstantiation {
	
	private static StaticBlockEagerInstantiation INSTANCE;
	
	private StaticBlockEagerInstantiation() {}
	
	static {
		try {
			INSTANCE = new StaticBlockEagerInstantiation();
		}catch(Exception e) {
			System.out.println("Exception occured while Instantiating StaticBlockEagerInstantiation object");
		}
	}
	
	public static StaticBlockEagerInstantiation getSingletonInstance() {
		return INSTANCE;
	}
}

package bridge;

public class GreenColour implements ColourBridge{

	public void applyColour(String shape) {
		System.out.println("Green Colour applied for : "+shape);
	}

}

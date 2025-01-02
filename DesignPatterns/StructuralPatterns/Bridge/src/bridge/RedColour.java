package bridge;

public class RedColour implements ColourBridge {

	public void applyColour(String shape) {
		System.out.println("Red Colour Applied for : " + shape);
	}

}

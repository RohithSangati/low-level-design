package element;

import visitor.RoomVisitor;

public class DoubleRoom implements Room {

	public int roomPrice;

	public void accept(RoomVisitor visitor) {
		visitor.visit(this);
	}

}

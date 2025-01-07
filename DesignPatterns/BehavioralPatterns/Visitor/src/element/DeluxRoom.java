package element;

import visitor.RoomVisitor;

public class DeluxRoom implements Room {

	public int roomPrice;

	public void accept(RoomVisitor visitor) {
		visitor.visit(this);
	}

}

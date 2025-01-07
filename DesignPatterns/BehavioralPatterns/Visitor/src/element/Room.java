package element;

import visitor.RoomVisitor;

public interface Room {

	public void accept(RoomVisitor visitor);
	
}

package visitor;

import element.DeluxRoom;
import element.DoubleRoom;
import element.SingleRoom;

public class RoomMaintanceVisitor implements RoomVisitor {

	public void visit(SingleRoom room) {
		System.out.println("Single Room maintanance done");
	}

	public void visit(DoubleRoom room) {
		System.out.println("Double Room maintanance done");
	}

	public void visit(DeluxRoom room) {
		System.out.println("Delux Room maintanance done");
	}

}

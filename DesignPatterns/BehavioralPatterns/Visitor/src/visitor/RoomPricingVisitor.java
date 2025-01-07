package visitor;

import element.DeluxRoom;
import element.DoubleRoom;
import element.SingleRoom;

public class RoomPricingVisitor implements RoomVisitor {

	public void visit(SingleRoom room) {
		System.out.println("Calculated single room price");
		room.roomPrice = 100;
	}

	public void visit(DoubleRoom room) {
		System.out.println("Calculated double room price");
		room.roomPrice = 200;
	}

	public void visit(DeluxRoom room) {
		System.out.println("Calculated delux room price");
		room.roomPrice = 300;
	}

}

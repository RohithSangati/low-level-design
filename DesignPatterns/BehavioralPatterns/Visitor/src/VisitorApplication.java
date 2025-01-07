import element.DoubleRoom;
import element.Room;
import element.SingleRoom;
import visitor.RoomMaintanceVisitor;
import visitor.RoomPricingVisitor;

public class VisitorApplication {

	public static void main(String[] args) {

		Room singleRoom = new SingleRoom();

		singleRoom.accept(new RoomPricingVisitor());
		System.out.println(((SingleRoom) singleRoom).roomPrice);
		singleRoom.accept(new RoomMaintanceVisitor());

		System.out.println("=============================================");

		Room doubleRoom = new DoubleRoom();

		doubleRoom.accept(new RoomPricingVisitor());
		System.out.println(((DoubleRoom) doubleRoom).roomPrice);
		doubleRoom.accept(new RoomMaintanceVisitor());

	}

}
package visitor;

import element.DeluxRoom;
import element.DoubleRoom;
import element.SingleRoom;

public interface RoomVisitor {

	public void visit(SingleRoom room);

	public void visit(DoubleRoom room);

	public void visit(DeluxRoom room);

}

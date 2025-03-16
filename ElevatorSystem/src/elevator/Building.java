package elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Building {
	private String id;
	private List<Floor> floors;

	public Building() {
		id = UUID.randomUUID().toString();
		floors = new ArrayList<>();
	}

	public void addFloor(Floor floor) {
		this.floors.add(floor);
	}

	public String getId() {
		return id;
	}
}

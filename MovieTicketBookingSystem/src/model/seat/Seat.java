package model.seat;

public class Seat {

	private SeatStatus seatStatus;
	private SeatType seatType;
	private int price;

	public Seat(SeatStatus seatStatus, SeatType seatType, int price) {
		super();
		this.seatStatus = seatStatus;
		this.seatType = seatType;
		this.price = price;
	}

	public SeatStatus getSeatStatus() {
		return seatStatus;
	}

	public SeatType getSeatType() {
		return seatType;
	}

	public int getPrice() {
		return price;
	}

	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	
	public void setSeatStatus(SeatStatus seatStatus) {
		this.seatStatus = seatStatus;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}

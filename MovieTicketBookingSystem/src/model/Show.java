package model;

import java.time.LocalDateTime;
import java.util.UUID;

import model.seat.Seat;
import model.seat.SeatStatus;
import model.seat.SeatType;

public class Show {

	private String showId;
	private Movie movie;
	private Theatre theatre;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private Seat[][] seating;

	public Show(Movie movie, Theatre theatre, LocalDateTime startTime, LocalDateTime endTime, int n, int price) {
		super();
		this.showId = UUID.randomUUID().toString();
		this.movie = movie;
		this.theatre = theatre;
		this.startTime = startTime;
		this.endTime = endTime;
		initializeSeating(n, price);
	}

	private void initializeSeating(int n, int price) {
		this.seating = new Seat[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				this.seating[i][j] = new Seat(SeatStatus.AVAILABLE, SeatType.NORMAL, price);
			}
		}
	}

	public void setSeatType(int row, int col, int price, SeatType seatType) {
		if (row < 0 || col < 0 || row >= this.seating.length || col >= this.seating.length) {
			System.out.println("Invalid row number or column");
			return;
		}
		this.seating[row][col].setSeatType(seatType);
		this.seating[row][col].setPrice(price);
		System.out.println("Successfully changed seat type!!!");
	}

	public void setSeatStatus(int row, int col, SeatStatus seatStatus) {
		if (row < 0 || col < 0 || row >= this.seating.length || col >= this.seating.length) {
			System.out.println("Invalid row number or column");
			return;
		}
		this.seating[row][col].setSeatStatus(seatStatus);
		System.out.println("Successfully changed seat status!!!");
	}

	public Movie getMovie() {
		return movie;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public String getShowId() {
		return showId;
	}

	public boolean isSeatAvailable(int row, int col) {
		return this.seating[row][col].getSeatStatus() == SeatStatus.AVAILABLE;
	}

	public void display() {
		for (int i = 0; i < this.seating.length; i++) {
			for (int j = 0; j < this.seating.length; j++) {
				String type = this.seating[i][j].getSeatType() == SeatType.NORMAL ? "N" : "P";
				String status = this.seating[i][j].getSeatStatus() == SeatStatus.AVAILABLE ? "A" : "F";
				System.out.print(type + ":" + status + " | ");
			}
			System.out.println();
		}
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", movie=" + movie + ", theatre=" + theatre + ", startTime=" + startTime
				+ ", endTime=" + endTime;
	}

}

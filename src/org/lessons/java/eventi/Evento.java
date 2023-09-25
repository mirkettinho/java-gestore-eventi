package org.lessons.java.eventi;

import java.time.LocalDate;

public class Evento {

	private String title;
	private LocalDate date;
	private int numSeats;
	private int numBooked;
	
	public Evento (String title, LocalDate date, int numSeats) throws Exception {
		
		this.title = title;
        this.date = dateCheck(date);
        this.numSeats = seatsCheck(numSeats);
        numBooked = 0;
	}
	
	///TITLE
	public String getTitle() {
		
		return title;
	}
	
	public void setTitle(String title) {
		
		this.title = title;
	}
	
	///DATE
	public LocalDate getDate() {
		
		return date;
	}
	
	public void setDate(LocalDate date) {
		
		this.date = date;
	}
	
	///NUM SEATS
	public int getNumSeats() {
		
		return numSeats;
	}
	
	
	///NUM BOOKED
	public int getNumBooked() {
		
		return numBooked;
	}
	
	///RESERVATION
	public void book(int reservation) throws Exception {
		
		if (LocalDate.now().isAfter(date) || numBooked == numSeats) {
			
			throw new Exception("error, there are 2 options:\r\n"
					+ "-event already passed.\r\n"
					+ "-places filled.");
		}
		
		numBooked = numBooked + reservation;
	}
	
	///CANCELLATION
	public void cancel(int cancellation) throws Exception {
		
		if (LocalDate.now().isAfter(date) || numBooked == 0) {
			
			throw new Exception("error, there are 2 options:\r\n"
					+ "-event already passed.\r\n"
					+ "-there are no reservations.");
		}
		
		numBooked = numBooked - cancellation;
	}
	
	///DATE CHECK
	private LocalDate dateCheck(LocalDate date) throws Exception {
		
		if(date.isBefore(LocalDate.now())) {
			
			throw new Exception("The event cannot start in the past!");
		}
		
		return date;
	}
	
	///SEATS CHECK
	private int seatsCheck(int numSeats) throws Exception {
		
		if(numSeats <= 0) {
			
			throw new Exception("number of seats cannot be equal to or less than zero");
		}
		
		return numSeats;
	}
	
	@Override
	public String toString() {
		
		return "Date :" + date + "Title :" + title;
	}
}

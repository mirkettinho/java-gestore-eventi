package org.lessons.java.eventi;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Concerto extends Evento{
	
	LocalTime time;
	BigDecimal price;
	
	public Concerto(String title, LocalDate date, int numSeats, LocalTime time, BigDecimal price) throws Exception {
		
		super(title, date, numSeats);
		
		if (price.signum() <= 0) {
			
			throw new Exception("Price can't be negative or equal to zero");
		}
		
		this.price = price;
		this.time = time;
	}
	
	///TIME
	public LocalTime getTime() {
		
		return time;
	}
	
	public void setTime(LocalTime time) {
		
		this.time = time;
	}
	
	///PRICE
	public BigDecimal getPrice() {
		
		return price;
	}
	
	public void setPrice(BigDecimal price) throws Exception{
		
		if (price.signum() <= 0) {
			
			throw new Exception("Price can't be negative or equal to zero");
		}
		
		this.price = price;
	}
	
	
	///DATA AND TIME FORMATTING
	public LocalDateTime getDateTimeFormat() {
		
		LocalDateTime dateFormat = getDate().atTime(time);
		return dateFormat;
	}
	
	///PRICE FORMATTING
	public String getPriceFormat() {
		
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		String priceFormat = currencyFormat.format(price);
		
		return priceFormat;
	}
	
	
	public String toString() {
		
		return "Name event: " + getTitle() + " date and time: " + getDateTimeFormat() + " price: " + getPriceFormat();
	}
}

package com.hibernatehelloworld.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Flight")
public class Flight {
	@Id
	int id;
	@Column(name="airlines")
	String airlines;
	@Column(name="date1")
	LocalDate date;
	@Column(name="time1")
	LocalTime time;
	@Column(name="source1")
	String source;
	@Column
	String destination;
	@Column
	int ticketprice;
	public Flight() {}
	public Flight(String airlines, LocalDate date, LocalTime time, String source, String destination, int ticketprice) {
		
		this.airlines = airlines;
		this.date = date;
		this.time = time;
		this.source = source;
		this.destination = destination;
		this.ticketprice = ticketprice;
	}
	
	public String getAirlines() {
		return airlines;
	}
	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getTicketprice() {
		return ticketprice;
	}
	public void setTicketprice(int ticketprice) {
		this.ticketprice = ticketprice;
	}
	
	
	
}

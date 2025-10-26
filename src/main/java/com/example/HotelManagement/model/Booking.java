package com.example.HotelManagement.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "bookingDetails")
public class Booking 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String customerName;
	private String customerEmail;
	private Date checkInDate;
	private Date checkOutDate;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	@JsonBackReference(value = "room-booking")
	private Room room;
	
	public Booking() {}
	
	public Booking(String customerName, String customerEmail, Date checkInDate, Date checkOutDate, Room room)
	{
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.room = room;
	}
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	
	public String getCustomerName()
	{
		return customerName;
	}
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}
	
	public String getCustomerEmail()
	{
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail)
	{
		this.customerEmail = customerEmail;
	}
	
	public Date getCheckInDate()
	{
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate)
	{
		this.checkInDate = checkInDate;
	}
	
	public Date getCheckOutDate()
	{
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate)
	{
		this.checkOutDate = checkOutDate;
	}
	
	public Room getRoom()
	{
		return room;
	}
	public void setRoom(Room room)
	{
		this.room = room;
	}
}
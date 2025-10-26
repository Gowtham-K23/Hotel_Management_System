package com.example.HotelManagement.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "room")
public class Room 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String roomNumber;
	private String type;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id", nullable = false)
	@JsonBackReference(value = "hotel-room")
	private Hotel hotel;
	
	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference(value = "room-booking")
	private List<Booking> bookings = new ArrayList<>();
	
	
	Room() {}
	
	Room(String roomNumber, String type, Double price, Hotel hotel)
	{
		this.roomNumber = roomNumber;
		this.type = type;
		this.price = price;
		this.hotel = hotel;
	}
	
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;	
	}
	
	public String getRoomNumber()
	{
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber)
	{
		this.roomNumber = roomNumber;
	}
	
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	
	public Double getPrice()
	{
		return price;
	}
	public void setPrice(Double price)
	{
		this.price = price;
	}
	
	public Hotel getHotel()
	{
		return hotel;
	}
	public void setHotel(Hotel hotel)
	{
		this.hotel = hotel;
	}
}
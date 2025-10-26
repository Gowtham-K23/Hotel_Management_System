package com.example.HotelManagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelManagement.model.Hotel;
import com.example.HotelManagement.service.HotelService;

@RestController
@RequestMapping("/api/hotel")
public class HotelController 
{
	private final HotelService hotelService;
	
	public HotelController(HotelService hotelService)
	{
		this.hotelService = hotelService;
	}
	
	// CREATE
	@PostMapping
	public Hotel addHotel(@RequestBody Hotel hotel)
	{
		return hotelService.saveHotel(hotel);
	}
	
	// GET - ALL
	@GetMapping
	public List<Hotel> getAllHotels()
	{
		return hotelService.getAllHotel();
	}
	
	// GET - ONE
	@GetMapping("/{id}")
	public Hotel getHotelById(@PathVariable Long id)
	{
		return hotelService.getHotelById(id);
	}
	
	// UPDATE HOTEL
	@PutMapping("/{id}")
	public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel hotel)
	{
		return hotelService.updateHotel(id, hotel);
	}
	
	// DELETE
	@DeleteMapping("/{id}")
	public String deleteHotel(@PathVariable Long id)
	{
		hotelService.deleteHotel(id);
		return "Hotel deleted successfully";
	}
}

package com.example.HotelManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.HotelManagement.model.Hotel;
import com.example.HotelManagement.repository.HotelRepository;

@Service
public class HotelService 
{
	private final HotelRepository hotelRepository;
	
	public HotelService(HotelRepository hotelRepository)
	{
		this.hotelRepository = hotelRepository;
	}
	
	// CREATE
	public Hotel saveHotel(Hotel hotel)
	{
		if(hotel.getRooms() != null)
		{
			hotel.getRooms().forEach(room -> room.setHotel(hotel));
		}
		return hotelRepository.save(hotel);
	}
	
	// GET ALL
	public List<Hotel> getAllHotel()
	{
		return hotelRepository.findAll();
	}
	
	// GET - ONE
	public Hotel getHotelById(Long id)
	{
		return hotelRepository.findById(id).orElse(null);
	}
	
	// UPDATE
	public Hotel updateHotel(Long id, Hotel updatedHotel)
	{
		Hotel existing = getHotelById(id);
		if(existing != null)
		{
			existing.setName(updatedHotel.getName());
			existing.setLocation(updatedHotel.getLocation());
			return hotelRepository.save(existing);
		}
		return null;
	}
	
	// DELETE
	public void deleteHotel(Long id)
	{
		hotelRepository.deleteById(id);
	}
}

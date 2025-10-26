package com.example.HotelManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.HotelManagement.model.Hotel;
import com.example.HotelManagement.model.Room;
import com.example.HotelManagement.repository.HotelRepository;
import com.example.HotelManagement.repository.RoomRepository;

@Service
public class RoomService 
{
	private final RoomRepository roomRepository;
	private final HotelRepository hotelRepository;
	
	public RoomService(RoomRepository roomRepository, HotelRepository hotelRepository)
	{
		this.roomRepository = roomRepository;
		this.hotelRepository = hotelRepository;
	}
	
	// CREATE
	public Room saveRoom(Room room)
	{
		if(room.getHotel() != null && room.getHotel().getId() != null)
		{
			Hotel hotel = hotelRepository.findById(room.getHotel().getId()).orElseThrow(() -> new RuntimeException("Hotel not found"));
			room.setHotel(hotel);
		}
		else
		{
			throw new RuntimeException("Hotel ID must be provided");
		}
		return roomRepository.save(room);
	}
	
	// GET - ALL
	public List<Room> getAllRooms()
	{
		return roomRepository.findAll();
	}
	
	// GET - ONE
	public Room getRoomById(Long id)
	{
		return roomRepository.findById(id).orElse(null);
	}
	
	// UPDATE
	public Room updateRoom(Long id, Room updatedRoom)
	{
		Room existing = getRoomById(id);
		if(existing != null)
		{
			existing.setRoomNumber(updatedRoom.getRoomNumber());
			existing.setPrice(updatedRoom.getPrice());
			existing.setType(updatedRoom.getType());
			if(updatedRoom.getHotel() != null && updatedRoom.getHotel().getId() != null)
			{
				Hotel hotel = hotelRepository.findById(updatedRoom.getHotel().getId())
						.orElseThrow(()-> new RuntimeException("Hotel not found"));
				existing.setHotel(hotel);
			}
			return roomRepository.save(existing);
		}
		return null;
	}
	
	// DELETE
	public void deleteRoom(Long id)
	{
		roomRepository.deleteById(id);
	}
}

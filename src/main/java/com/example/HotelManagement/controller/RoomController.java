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

import com.example.HotelManagement.model.Room;
import com.example.HotelManagement.service.RoomService;

@RestController
@RequestMapping("/api/rooms")
public class RoomController
{
	private final RoomService roomService;
	
	public RoomController(RoomService roomService)
	{
		this.roomService = roomService;
	}
	
	// CREATE
	@PostMapping
	public Room addRooms(@RequestBody Room room)
	{
		return roomService.saveRoom(room);
	}
	
	// GET - ALL
	@GetMapping
	public List<Room> getAllRooms()
	{
		return roomService.getAllRooms();
	}
	
	// GET - ONE
	@GetMapping("/{id}")
	public Room getRoomById(@PathVariable Long id)
	{
		return roomService.getRoomById(id);
	}
	
	// UPDATE
	@PutMapping("/{id}")
	public Room updateRoom(@PathVariable Long id, @RequestBody Room room)
	{
		return roomService.updateRoom(id, room);
	}
	
	// DELETE
	@DeleteMapping("/{id}")
	public String deleteRoom(@PathVariable Long id)
	{
		roomService.deleteRoom(id);
		return "Room deleted successfully";
	}
}
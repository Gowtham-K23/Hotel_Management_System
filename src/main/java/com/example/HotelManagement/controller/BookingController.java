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

import com.example.HotelManagement.model.Booking;
import com.example.HotelManagement.service.BookingService;

@RestController
@RequestMapping("/api/booking")
public class BookingController 
{
	private final BookingService bookingService;
	
	public BookingController(BookingService bookingService)
	{
		this.bookingService = bookingService;
	}
	
	// CREATE
	@PostMapping
	public Booking addBooking(@RequestBody Booking booking)
	{
		return bookingService.saveBooking(booking);
	}
	
	// GET - ALL
	@GetMapping
	public List<Booking> getAllBooking()
	{
		return bookingService.getAllBooking();
	}
	
	// GET - ONE
	@GetMapping("/{id}")
	public Booking getBookingById(@PathVariable Long id)
	{
		return bookingService.getBookingById(id);
	}
	
	// UPDATE
	@PutMapping("/{id}")
	public Booking updateBooking(@PathVariable Long id, @RequestBody Booking booking)
	{
		return bookingService.updateBooking(id, booking);
	}
	
	// DELETE
	@DeleteMapping("/{id}")
	public String deleteBooking(@PathVariable Long id)
	{
		bookingService.deleteBooking(id);
		return "Booking deleted successfully";
	}
}
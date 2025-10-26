package com.example.HotelManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.HotelManagement.model.Booking;
import com.example.HotelManagement.model.Room;
import com.example.HotelManagement.repository.BookingRepository;
import com.example.HotelManagement.repository.RoomRepository;

@Service
public class BookingService 
{
	private final RoomRepository roomRepository;
	private final BookingRepository bookingRepository;
	
	public BookingService(RoomRepository roomRepository, BookingRepository bookingRepository)
	{
		this.roomRepository = roomRepository;
		this.bookingRepository = bookingRepository;
	}
	
	// CREATE
	public Booking saveBooking(Booking booking)
	{
		if (booking.getRoom() != null && booking.getRoom().getId() != null) {
            Room room = roomRepository.findById(booking.getRoom().getId())
                    .orElseThrow(() -> new RuntimeException("Room not found"));
            booking.setRoom(room);
        } else {
            throw new RuntimeException("Room id must be provided");
        }
        return bookingRepository.save(booking);
	}
	
	// GET - ALL
	public List<Booking> getAllBooking()
	{
		return bookingRepository.findAll();
	}
	
	// GET - ONE
	public Booking getBookingById(Long id)
	{
		return bookingRepository.findById(id).orElse(null);
	}
	
	// UPDATE
	public Booking updateBooking(Long id, Booking updatedBooking)
	{
		Booking existing = getBookingById(id);
		if(existing != null)
		{
			existing.setCustomerName(updatedBooking.getCustomerName());
			existing.setCustomerEmail(updatedBooking.getCustomerEmail());
			existing.setCheckInDate(updatedBooking.getCheckInDate());
			existing.setCheckOutDate(updatedBooking.getCheckOutDate());
			return bookingRepository.save(existing);
		}
		return null;
	}
	
	// DELETE
	public void deleteBooking(Long id)
	{
		bookingRepository.deleteById(id);
	}
}

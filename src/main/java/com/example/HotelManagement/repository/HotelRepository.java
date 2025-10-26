package com.example.HotelManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HotelManagement.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

}

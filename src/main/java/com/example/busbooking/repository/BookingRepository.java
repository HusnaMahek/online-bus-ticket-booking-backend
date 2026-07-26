package com.example.busbooking.repository;

import com.example.busbooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    // Check if a seat is already booked on a bus
    boolean existsByBusIdAndSeatNumber(Long busId, Integer seatNumber);

    // Get all booked seat numbers for a bus
    @Query("SELECT b.seatNumber FROM Booking b WHERE b.busId = :busId")
    List<Integer> findSeatNumbersByBusId(@Param("busId") Long busId);
}
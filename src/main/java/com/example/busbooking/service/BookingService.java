package com.example.busbooking.service;

import com.example.busbooking.model.Booking;
import com.example.busbooking.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // Create a booking
    public Booking createBooking(Booking booking) {

        boolean alreadyBooked =
                bookingRepository.existsByBusIdAndSeatNumber(
                        booking.getBusId(),
                        booking.getSeatNumber()
                );

        if (alreadyBooked) {
            throw new RuntimeException("This seat is already booked!");
        }

        return bookingRepository.save(booking);
    }

    // Get all bookings 
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Cancel a booking
    public void cancelBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
package com.example.busbooking.service;

import com.example.busbooking.model.Bus;
import com.example.busbooking.repository.BusRepository;
import com.example.busbooking.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusService {

    private final BusRepository busRepository;
    private final BookingRepository bookingRepository;

    public BusService(BusRepository busRepository,
                      BookingRepository bookingRepository) {
        this.busRepository = busRepository;
        this.bookingRepository = bookingRepository;
    }

    public Bus addBus(Bus bus) {
        return busRepository.save(bus);
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAll();
    }

    public List<Bus> searchBuses(String source, String destination) {
        return busRepository.findBySourceAndDestination(source, destination);
    }

    public List<Integer> getAvailableSeats(Long busId) {

        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new RuntimeException("Bus not found"));

        List<Integer> bookedSeats =
                bookingRepository.findSeatNumbersByBusId(busId);

        List<Integer> availableSeats = new ArrayList<>();

        for (int seat = 1; seat <= bus.getTotalSeats(); seat++) {
            if (!bookedSeats.contains(seat)) {
                availableSeats.add(seat);
            }
        }

        return availableSeats;
    }
}
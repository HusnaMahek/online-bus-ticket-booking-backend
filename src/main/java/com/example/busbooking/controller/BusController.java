package com.example.busbooking.controller;

import com.example.busbooking.model.Bus;
import com.example.busbooking.service.BusService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buses")
public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }

    // Add a new bus
    @PostMapping
    public Bus addBus(@RequestBody Bus bus) {
        return busService.addBus(bus);
    }

    // View all buses
    @GetMapping
    public List<Bus> getAllBuses() {
        return busService.getAllBuses();
    }

    // Search buses by source and destination
    @GetMapping("/search")
    public List<Bus> searchBuses(
            @RequestParam String source,
            @RequestParam String destination) {

        return busService.searchBuses(source, destination);
    }
    @GetMapping("/{busId}/available-seats")
    public List<Integer> getAvailableSeats(@PathVariable Long busId) {
        return busService.getAvailableSeats(busId);
    }
}
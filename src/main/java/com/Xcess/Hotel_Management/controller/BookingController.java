package com.Xcess.Hotel_Management.controller;

import com.Xcess.Hotel_Management.dto.BookingDTO;
import com.Xcess.Hotel_Management.entity.Bookings;
import com.Xcess.Hotel_Management.service.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingServices bookingServices;


    @PostMapping
    public Bookings createBooking(@RequestBody Bookings bookings) {
        System.out.println("All bookings: " + bookings);
        return bookingServices.createBooking(bookings);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createBooking(@RequestBody BookingDTO bookingDto) {
        // Simulating saving the booking

        return ResponseEntity.ok("Booking created successfully!");
    }
    @GetMapping("/all")
    public List<BookingDTO> getAllBookings() {

        return bookingServices.getAllBookings();

    }
    @PutMapping("/{id}")
    public Bookings updateBooking(@PathVariable Long id, @RequestBody Bookings updatedBooking) {
        return bookingServices.updateBooking(id, updatedBooking);
    }

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id) {
        return bookingServices.deleteBooking(id);
    }


}


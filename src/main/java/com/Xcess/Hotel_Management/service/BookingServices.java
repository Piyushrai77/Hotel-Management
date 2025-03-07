package com.Xcess.Hotel_Management.service;


import com.Xcess.Hotel_Management.Repo.BookingRepo;
import com.Xcess.Hotel_Management.Repo.RoomTypeRepo;
import com.Xcess.Hotel_Management.dto.BookingDTO;
import com.Xcess.Hotel_Management.entity.Bookings;
import com.Xcess.Hotel_Management.entity.RoomTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServices {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private RoomTypeRepo roomTypeRepo;

    @Transactional
    public Bookings createBooking(Bookings bookings){
       /* List<Bookings> overlappingBookings = bookingRepo.findOverlappingBookings(
                bookings.getRoomNumber(),
                bookings.getStartTime(),
                bookings.getEndTime()
        );

        if (!overlappingBookings.isEmpty()) {
            throw new IllegalArgumentException("Room is not available for the selected time.");
        }

        // Step 2: Fetch and validate the room type
        RoomTypeEntity room = roomTypeRepo.findById(bookings.getRoomType().getId())
                .orElseThrow(() -> new IllegalArgumentException("Room type not found"));

        // Step 3: Assign the room type to the booking
        bookings.setRoomType(room);

        // Step 4: Save the booking and return it
        System.out.println("Saving booking: " + bookings);
        return bookingRepo.save(bookings);    */

        System.out.println("Received booking: " + bookings);  // Debugging Log

        List<Bookings> overlappingBookings = bookingRepo.findOverlappingBookings(
                bookings.getRoomNumber(),
                bookings.getStartTime(),
                bookings.getEndTime()
        );

        if (!overlappingBookings.isEmpty()) {
            throw new IllegalArgumentException("Room is not available for the selected time.");
        }

        RoomTypeEntity room = roomTypeRepo.findById(bookings.getRoomType().getId())
                .orElseThrow(() -> new IllegalArgumentException("Room type not found"));

        bookings.setRoomType(room);

        Bookings savedBooking = bookingRepo.save(bookings);

        System.out.println("Saved booking: " + savedBooking);  // Debugging Log

        return bookingRepo.save(bookings);
    }


    public List<BookingDTO> getAllBookings() {
        return bookingRepo.findAll().stream()
                .map(booking -> new BookingDTO(
                        booking.getId(),
                        booking.getUserEmail(),
                        booking.getRoomNumber(),
                        booking.getStartTime(),
                        booking.getEndTime(),
                        booking.getPrice(),
                        booking.getRoomType()!= null ? booking.getRoomType().getName() : null
                ))
                .collect(Collectors.toList());
    }

    @Transactional
    public Bookings updateBooking(Long id, Bookings updatedBooking) {
        // Fetch the existing booking by ID
        Bookings existingBooking = bookingRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found with ID: " + id));

        // Update fields
        existingBooking.setUserEmail(updatedBooking.getUserEmail());
        existingBooking.setRoomNumber(updatedBooking.getRoomNumber());
        existingBooking.setStartTime(updatedBooking.getStartTime());
        existingBooking.setEndTime(updatedBooking.getEndTime());
        existingBooking.setPrice(updatedBooking.getPrice());

        // Fetch and validate the room type


        // Save and return the updated booking
        return bookingRepo.save(existingBooking);
    }

    @Transactional
    public String deleteBooking(Long id) {
        // Check if the booking exists
        if (!bookingRepo.existsById(id)) {
            throw new IllegalArgumentException("Booking not found with ID: " + id);
        }

        // Delete the booking
        bookingRepo.deleteById(id);
        return "Booking with ID " + id + " deleted successfully.";
    }



}
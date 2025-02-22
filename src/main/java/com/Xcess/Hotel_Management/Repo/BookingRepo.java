package com.Xcess.Hotel_Management.Repo;

import com.Xcess.Hotel_Management.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface BookingRepo extends JpaRepository<Bookings, Long>{

    @Query("SELECT b FROM Bookings b WHERE b.roomNumber = :roomNumber AND " +
            "(:startTime < b.endTime AND :endTime > b.startTime)")
    List<Bookings> findOverlappingBookings(
            @Param("roomNumber") String roomNumber,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime);
            List<Bookings> findByUserEmail(String userEmail);


}



package com.Xcess.Hotel_Management.dto;

import java.time.LocalDateTime;

public class BookingDTO {
    private Long id;
    private String userEmail;
    private String roomNumber;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double price;

    private String roomType;

    public BookingDTO(long id, String userEmail, String roomNumber, LocalDateTime startTime, LocalDateTime endTime, Double price, String roomType) {
        this.id = id;
        this.userEmail = userEmail;
        this.roomNumber = roomNumber;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.roomType = roomType;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getRoomNo() {
        return roomNumber;
    }

    public void setRoomNo(String roomNo) {
        this.roomNumber = roomNo;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }


}

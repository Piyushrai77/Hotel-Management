package com.Xcess.Hotel_Management.entity;

import jakarta.persistence.*;

@Entity
@Table(name="rooms")
public class Room
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long id;

    @Column(name="room_number")
     private String roomNumber;

     @ManyToOne
     @JoinColumn(name="type_id")
    private RoomTypeEntity roomTypeEntity;
     //Getter and Setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomTypeEntity getRoomType() {
        return roomTypeEntity;
    }



    public void setRoomType(RoomTypeEntity roomTypeEntity) {
        this.roomTypeEntity = roomTypeEntity;
    }


}

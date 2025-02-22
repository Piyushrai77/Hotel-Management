package com.Xcess.Hotel_Management.Repo;
import java.util.Optional;
import com.Xcess.Hotel_Management.entity.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;




public interface RoomTypeRepo extends JpaRepository<RoomTypeEntity,Long>{

    Optional<RoomTypeEntity>  findById(Long Id);

    }

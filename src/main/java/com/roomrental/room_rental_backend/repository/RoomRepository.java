package com.roomrental.room_rental_backend.repository;


import com.roomrental.room_rental_backend.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByAvailable(Boolean available);
    List<Room> findByLocationContainingIgnoreCase(String location);
}

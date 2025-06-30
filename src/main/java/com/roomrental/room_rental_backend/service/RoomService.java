package com.roomrental.room_rental_backend.service;


import com.roomrental.room_rental_backend.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.roomrental.room_rental_backend.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    public Optional<Room> getRoomById(Long id) {
        return roomRepository.findById(id);
    }
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }
    public Room updateRoom(Long id, Room roomDetails) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id:" + id));

        room.setTitle(roomDetails.getTitle());
        room.setDescription(roomDetails.getDescription());
        room.setPrice(roomDetails.getPrice());
        room.setLocation(roomDetails.getLocation());
        room.setAvailable(roomDetails.getAvailable());

        return roomRepository.save(room);
    }
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public List<Room> getAvailableRooms() {
        return roomRepository.findByAvailable(true);
    }
}

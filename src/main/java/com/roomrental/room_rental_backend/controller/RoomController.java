package com.roomrental.room_rental_backend.controller;


import jakarta.validation.Valid;
import com.roomrental.room_rental_backend.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.roomrental.room_rental_backend.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:3000")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id)
                .map(room -> ResponseEntity.ok().body(room))
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public Room createRoom(@Valid @RequestBody Room room) {
        return roomService.saveRoom(room);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @Valid @RequestBody Room roomDetails){
        try {
            Room updatedRoom = roomService.updateRoom(id, roomDetails);
            return ResponseEntity.ok(updatedRoom);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRoom(@PathVariable Long id) {
        try {
            roomService.deleteRoom(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }
    @GetMapping("/available")
    public List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

}

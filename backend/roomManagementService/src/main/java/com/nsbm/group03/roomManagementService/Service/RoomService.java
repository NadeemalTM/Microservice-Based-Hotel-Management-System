package com.nsbm.group03.roomManagementService.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsbm.group03.roomManagementService.Entity.Room;
import com.nsbm.group03.roomManagementService.Repository.RoomRepository;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    //View all rooms
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    

    public Room insertRoom(Room room) {
        return roomRepository.save(room);
    }

}

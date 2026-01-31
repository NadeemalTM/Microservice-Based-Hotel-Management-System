package com.nsbm.group03.roomManagementService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsbm.group03.roomManagementService.Entity.Room;
import com.nsbm.group03.roomManagementService.Service.RoomService;

@RestController
@RequestMapping(value = "/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;
    
    //views all rooms
    @GetMapping
    public  List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }
    
    //create a room
    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomService.insertRoom(room);
    }
    
    
}

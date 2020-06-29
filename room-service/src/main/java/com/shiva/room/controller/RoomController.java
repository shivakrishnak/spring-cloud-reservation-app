package com.shiva.room.controller;

import com.shiva.room.model.Room;
import com.shiva.room.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private static Logger log = LoggerFactory.getLogger(RoomController.class);

    private RoomService roomRepository;

    @Autowired
    public RoomController(RoomService roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public List<Room> findAll() {
        log.info("Getting all rooms data");
        return roomRepository.findAll();
    }

}

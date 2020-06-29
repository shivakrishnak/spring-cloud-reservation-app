package com.shiva;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("room-service")
public interface RoomClient {

    @GetMapping("/rooms")
    public List<Room> getAllRooms();

    @GetMapping
    Room getRoom(@PathVariable("roomId") long id);
}

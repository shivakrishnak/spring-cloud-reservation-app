package com.shiva.service;

import com.shiva.model.Guest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("guest-service")
public interface GuestClient {

    @GetMapping("/guests")
    public List<Guest> getAllGuests();

    @GetMapping
    Guest getGuest(@PathVariable("guestId") long id);

}

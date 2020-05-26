package com.shiva.guest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private GuestRepository guestRepository;

    @Autowired
    public GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public List<Guest> findAll(){
        return guestRepository.findAll();
    }

}

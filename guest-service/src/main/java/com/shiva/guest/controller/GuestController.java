package com.shiva.guest.controller;

import com.shiva.guest.model.Guest;
import com.shiva.guest.service.GuestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private static Logger log = LoggerFactory.getLogger(GuestController.class);

    private GuestService guestService;

    @Autowired
    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/all")
    public List<Guest> findAll() {
        log.info("Getting all guests data");
        return guestService.findAll();
    }

}

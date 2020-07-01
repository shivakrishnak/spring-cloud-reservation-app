package com.shiva.service;

import com.shiva.model.Guest;
import com.shiva.model.Reservation;
import com.shiva.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("reservation-service")
public interface ReservationClient {

    @GetMapping("/reservations")
    public List<Reservation> getAllReservations();

}

package com.shiva.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> findAll(){
        return reservationRepository.findAll();
    }

    @GetMapping("/room/{roomId}")
    public Reservation findReservationByRoomId(@PathVariable("roomId") String roomId){
        return reservationRepository.findReservationByRoomId(roomId);
    }

    @GetMapping("/guest/{guestId}")
    public Reservation findReservationByGuestId(@PathVariable("guestId") String guestId){
        return reservationRepository.findReservationByGuestId(guestId);
    }

}

package com.shiva.reservation.service;

import com.shiva.reservation.model.Reservation;
import com.shiva.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Reservation findReservationByRoomId(String roomId) {
        return reservationRepository.findReservationByRoomId(roomId);
    }

    public Reservation findReservationByGuestId(String guestId) {
        return reservationRepository.findReservationByGuestId(guestId);
    }
}

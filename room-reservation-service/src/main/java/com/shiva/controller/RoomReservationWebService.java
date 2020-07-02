package com.shiva.controller;

import com.shiva.model.Guest;
import com.shiva.model.Reservation;
import com.shiva.model.Room;
import com.shiva.model.RoomReservation;
import com.shiva.service.GuestClient;
import com.shiva.service.ReservationClient;
import com.shiva.service.RoomClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@RestController
@RequestMapping("/room-reservations")
@Log4j2
public class RoomReservationWebService {

    public static final String HTTP_ROOM_SERVICE_URL = "http://ROOM-SERVICE/rooms";
    //private RestTemplate restTemplate;

  /*  public RoomReservationWebService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }*/

    private RoomClient roomClient;
    private GuestClient guestClient;
    private ReservationClient reservationClient;

    public RoomReservationWebService(RoomClient roomClient, GuestClient guestClient, ReservationClient reservationClient) {
        this.roomClient = roomClient;
        this.guestClient = guestClient;
        this.reservationClient = reservationClient;
    }

    @GetMapping
    public List<RoomReservation> getRoomReservations() {
        log.info("Getting all room reservations");
        //List<Room> rooms = this.getAllRooms();
        List<RoomReservation> roomReservations = new ArrayList<>();
        List<Reservation> reservations = this.reservationClient.getAllReservations();
        reservations.forEach(reservation -> {
                    log.info("checking reservation for " + reservation.getId());
                    RoomReservation roomReservation = new RoomReservation();
                    Optional<Room> room = getRoomForReservation(reservation.getRoomId());
                    if (room.isPresent()) {
                        setRoomData(roomReservation, room);
                    }
                    Optional<Guest> guest = getGuestForReservation(reservation.getGuestId());
                    if (guest.isPresent()) {
                        setGuestData(reservation, roomReservation, guest);
                    }
                    roomReservations.add(roomReservation);
                }
        );
        log.info("All Reservations : " + roomReservations);
        return roomReservations;
    }

    private void setGuestData(Reservation reservation, RoomReservation roomReservation, Optional<Guest> guest) {
        Guest guestData = guest.get();
        log.info("Guest : " + guestData);
        roomReservation.setGuestId(guestData.getId());
        roomReservation.setFirstName(guestData.getFirstName());
        roomReservation.setLastName(guestData.getLastName());
        roomReservation.setDate(reservation.getResFromDate());
    }

    private void setRoomData(RoomReservation roomReservation, Optional<Room> room) {
        Room roomData = room.get();
        log.info("Room : " + roomData);
        roomReservation.setRoomNumber(roomData.getRoomNumber());
        roomReservation.setRoomName(roomData.getName());
        roomReservation.setRoomId(roomData.getId());
    }

    private Optional<Guest> getGuestForReservation(String guestId) {
        log.info("Fetching Guest data for Id: " + guestId);
        Predicate<? super Guest> findGuest = guest -> guest.getId() == Long.parseLong(guestId);
        return getAllGuests().stream().filter(findGuest).findAny();
    }

    public List<Guest> getAllGuests() {
        return this.guestClient.getAllGuests();
    }

    private Optional<Room> getRoomForReservation(String roomId) {
        log.info("Fetching Room data for Id: " + roomId);
        Predicate<? super Room> findRoom = room -> room.getId() == Long.parseLong(roomId);
        return getAllRooms().stream().filter(findRoom).findAny();
    }

    private List<Room> getAllRooms() {
        return this.roomClient.getAllRooms();
    }


/*    private List<Room> getAllRooms() {
        ResponseEntity<List<Room>> roomResponse = this.restTemplate.exchange(HTTP_ROOM_SERVICE_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Room>>() {
        });
        return roomResponse.getBody();
    }*/
}

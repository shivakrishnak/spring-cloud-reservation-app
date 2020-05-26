package com.shiva.reservation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "RESERVATION")
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "ROOM_ID" )
    private String roomId;

    @Column(name = "GUEST_ID")
    private String guestId;

    @Column(name = "RES_DATE")
    private String resDate;

}

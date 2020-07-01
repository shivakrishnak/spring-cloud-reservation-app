package com.shiva.reservation.model;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservation_generator")
    @SequenceGenerator(name = "reservation_generator", sequenceName = "reservation_sequence", initialValue = 10000)
    private Long id;

    @Column(name = "ROOM_ID" )
    private String roomId;

    @Column(name = "GUEST_ID")
    private String guestId;

    @Column(name = "RES_FROM_DATE")
    private String resFromDate;

    @Column(name = "RES_TO_DATE")
    private String resToDate;


}

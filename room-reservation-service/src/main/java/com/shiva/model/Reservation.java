package com.shiva.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    private Long id;
    private String roomId;
    private String guestId;
    private String resFromDate;
    private String resToDate;
}

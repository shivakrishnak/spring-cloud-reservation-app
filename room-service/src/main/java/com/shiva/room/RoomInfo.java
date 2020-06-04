package com.shiva.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ROOM_INFO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomInfo {

    @Id
    @Column(name = "ROOM_INFO_ID")
    private String id;

    @Column(name = "NAME")
    private  String name;

    @Column(name = "PRICE")
    private BigDecimal price;
}

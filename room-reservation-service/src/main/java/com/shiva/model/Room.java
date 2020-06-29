package com.shiva.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    private Long id;
    private String name;
    private String roomNumber;
    private String bedInfo;
}

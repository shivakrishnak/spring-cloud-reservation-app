package com.shiva.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "INCLUSIONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inclusion {

    @Id
    @Column(name = "INCLUSION_ID")
    private Long id;

    @Column(name = "NAME")
    String names;
}

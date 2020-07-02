package com.shiva.reservation;

import com.shiva.reservation.model.Reservation;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = {"spring.cloud.config.enabled:false"})
@TestPropertySource(locations = {"classpath:test.properties"})
public class ReservationControllerTest {

    @Autowired
    TestRestTemplate rest;

    @Test
    public void testFindAllGuests() {
        List<Reservation> reservation = this.rest.getForObject("/reservations", ArrayList.class);
        log.info("Reservation Data : " + reservation);
        assertTrue(reservation.size() > 0);
    }

}

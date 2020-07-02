package com.shiva.reservation;

import com.shiva.reservation.model.Reservation;
import com.shiva.reservation.repository.ReservationRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReservationRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    public void whenFindById_thenReturnGuest() {
        // given
        Reservation reservation = new Reservation(1L, "1001", "400001", "23/06/2020", "23/06/2020");
        entityManager.merge(reservation);
        entityManager.flush();

        // when
        Optional<Reservation> found = reservationRepository.findById(reservation.getId());

        // then
        Assert.assertNotNull(found.get());
        assertThat(found.get().getId())
                .isEqualTo(reservation.getId());
    }

}
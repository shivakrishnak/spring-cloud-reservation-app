package com.shiva.guest;

import com.shiva.guest.model.Guest;
import com.shiva.guest.repository.GuestRepository;
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
public class GuestRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private GuestRepository guestRepository;

    @Test
    public void whenFindById_thenReturnGuest() {
        // given
        Guest guest = new Guest(1l, "shiva", "krishna", "test@test.com", "Smile Nagar", "India", "Happylore", "1234567890");
        entityManager.merge(guest);
        entityManager.flush();

        // when
        Optional<Guest> found = guestRepository.findById(guest.getId());

        // then
        Assert.assertNotNull(found.get());
        assertThat(found.get().getId())
                .isEqualTo(guest.getId());
    }

}
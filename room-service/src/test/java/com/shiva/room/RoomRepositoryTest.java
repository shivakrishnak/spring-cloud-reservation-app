package com.shiva.room;

import com.shiva.room.model.Room;
import com.shiva.room.model.RoomInfo;
import com.shiva.room.repository.RoomRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RoomRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void whenFindById_thenReturnRoom() {
        // given
        Room room = new Room(1l, "TestRoom", "1000", new RoomInfo("500", "Suite", BigDecimal.ONE));
        entityManager.merge(room);
        entityManager.flush();

        // when
        Optional<Room> found = roomRepository.findById(room.getId());

        // then
        Assert.assertNotNull(found.get());
        assertThat(found.get().getId())
                .isEqualTo(room.getId());
    }

}
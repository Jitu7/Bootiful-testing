package com.example.bootifultesting.repositories;

import com.example.bootifultesting.entity.Reservation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void findReservationByNameTest() {

        Reservation reservation = testEntityManager.persistAndFlush(new Reservation(null, "Jitu"));

        Optional<Reservation> jitu = reservationRepository.findReservationByName("Jitu");

        Assertions.assertThat(jitu.get().getName()).isEqualTo("Jitu");
        Assertions.assertThat(jitu.get().getId()).isGreaterThan(0);
    }
}

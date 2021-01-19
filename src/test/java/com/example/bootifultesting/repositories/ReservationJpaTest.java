package com.example.bootifultesting.repositories;

import com.example.bootifultesting.entity.Reservation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ReservationJpaTest {

    @Autowired
    public TestEntityManager tem;

    @Test
    void mapping() {

        Reservation reservation = tem.persistFlushFind(new Reservation(null, "Jitu"));

        Assertions.assertThat(reservation.getId()).isNotNull();
        Assertions.assertThat(reservation.getName()).isEqualTo("Jitu");

    }
}



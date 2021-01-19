package com.example.bootifultesting.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReservationTest {

    @Test
    void name() {
        Reservation reservation = new Reservation(1, "Jitu");

        Assertions.assertThat(reservation.getId()).isNotNull();
        Assertions.assertThat(reservation.getId()).isEqualTo(1);
        Assertions.assertThat(reservation.getName()).isNotBlank();
        Assertions.assertThat(reservation.getName()).isEqualTo("Jitu");

    }
}

package com.example.bootifultesting.integrationtest;

import com.example.bootifultesting.entity.Reservation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReservationIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void getReservations() {
        ResponseEntity<Reservation> reservationResponseEntity =
                testRestTemplate.getForEntity("/reservations/{name}", Reservation.class, "Jitu");

        assertThat(reservationResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(reservationResponseEntity.getBody()).isInstanceOf(Reservation.class);
    }
}

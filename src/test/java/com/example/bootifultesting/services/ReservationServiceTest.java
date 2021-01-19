package com.example.bootifultesting.services;

import com.example.bootifultesting.entity.Reservation;
import com.example.bootifultesting.exceptions.ReservationNotFoundException;
import com.example.bootifultesting.repositories.ReservationRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class ReservationServiceTest {

    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;

    @BeforeEach
    void setUp() {
        this.reservationService = new ReservationService(reservationRepository);
    }


    @Test
    @DisplayName("get reservation by name returns reservation info")
    void getReservationByName() {

        given(reservationRepository.findReservationByName(anyString()))
                .willReturn(Optional.of(new Reservation(1, "Jitu")));

        Reservation reservation = reservationService.findReservationByName("Jitu");

        Assertions.assertThat(reservation.getName()).isEqualTo("Jitu");

    }

    @Test
    @DisplayName("get reservation by name returns ReservationNotFoundException")
    void getReservationByNameException() {

        given(reservationRepository.findReservationByName(anyString()))
                .willThrow(new ReservationNotFoundException("Reservation with this name not found"));


        assertThrows(ReservationNotFoundException.class,
                () -> reservationService.findReservationByName("Jitu"));
    }
}

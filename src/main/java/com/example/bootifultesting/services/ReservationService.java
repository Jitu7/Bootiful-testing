package com.example.bootifultesting.services;

import com.example.bootifultesting.entity.Reservation;
import com.example.bootifultesting.exceptions.ReservationNotFoundException;
import com.example.bootifultesting.repositories.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public Reservation findReservationByName(String reservationName) {

        return reservationRepository
                .findReservationByName(reservationName)
                .orElseThrow(() -> new ReservationNotFoundException("No Reservation Found with this name"));

    }
}

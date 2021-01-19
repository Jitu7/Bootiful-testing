package com.example.bootifultesting.repositories;

import com.example.bootifultesting.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    Optional<Reservation> findReservationByName(String name);
}

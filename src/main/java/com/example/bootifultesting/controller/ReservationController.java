package com.example.bootifultesting.controller;

import com.example.bootifultesting.entity.Reservation;
import com.example.bootifultesting.services.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping(value = "/reservations/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Reservation getReservationByName(@PathVariable("name") String name) {

        return reservationService.findReservationByName(name);
    }
}

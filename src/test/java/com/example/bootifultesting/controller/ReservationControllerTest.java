package com.example.bootifultesting.controller;

import com.example.bootifultesting.entity.Reservation;
import com.example.bootifultesting.exceptions.ReservationNotFoundException;
import com.example.bootifultesting.services.ReservationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

    @MockBean
    private ReservationService reservationService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getReservationByNameTest() throws Exception {

        given(reservationService.findReservationByName(anyString()))
                .willReturn(new Reservation(1, "Jitu"));

        mockMvc.perform(get("/reservations/{name}", "Jitu"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("@.id").value(1))
                .andExpect(jsonPath("@.name").value("Jitu"))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Reservation Not Found")
    void getReservationByNameTest2() throws Exception {

        given(reservationService.findReservationByName(anyString()))
                .willThrow(new ReservationNotFoundException("Not Found!"));

        mockMvc.perform(get("/reservations/{name}", "Jitu"))
                .andExpect(status().isNotFound());

    }
}

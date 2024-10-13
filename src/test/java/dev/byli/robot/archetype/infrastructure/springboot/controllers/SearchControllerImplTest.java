package dev.byli.robot.archetype.infrastructure.springboot.controllers;

import dev.byli.robot.archetype.core.application.usecases.PullEventsUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class SearchControllerImplTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private PullEventsUseCase pullEventsUseCase;

    @Test
    @DisplayName("Should validate invalid dates")
    void testDates() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/search?starts_at=2024-01-01T00:00:00Z&ends_at=2021-01-01T00:00:00Z")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error.code").value("400 BAD_REQUEST"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error.message").value("Start date must be before end date"));
    }

    @Test
    @DisplayName("Should fetch registries")
    void testDates_2() throws Exception {
        //arrange
        pullEventsUseCase.execute();
        //act
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/search?starts_at=2010-01-03T00:00:00Z&ends_at=2027-01-02T00:00:00Z")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.events").isArray());

    }

}
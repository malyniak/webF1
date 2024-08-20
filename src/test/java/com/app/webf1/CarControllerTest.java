package com.app.webf1;

import com.app.webf1.mapper.team.TeamMapper;
import com.app.webf1.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static com.app.webf1.JsonString.asJsonString;
import static com.app.webf1.TestData.carCreateDto;
import static com.app.webf1.TestData.carUpdateDto;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
public class CarControllerTest extends BaseTest{
    private static final int CAR_ID = 1;
    private static final int ALL_CARS_COUNT = 20;
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private TeamMapper teamMapper;

    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testGetCarById() throws Exception {
        mockMvc.perform(get("/api/car/" + CAR_ID )
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.number").value(1));
    }

    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testGetDriverAll() throws Exception {
        mockMvc.perform(get("/api/car")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(ALL_CARS_COUNT));
    }

    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testGetCarByTeamIfExists() throws Exception {
        var maybeTeam = teamRepository.findById(1);
        var teamDto = teamMapper.toTo(maybeTeam.get());
        var jsonString = asJsonString(teamDto);
        mockMvc.perform(post("/api/car/team")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testGetCarByEngineIfExists() throws Exception {
        mockMvc.perform(post("/api/car/engine")
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("engine", "Honda RBPT"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(4));
    }

    @Test
    @WithMockUser(username = "admin", authorities = {"ADMIN"})
    public void testUpdateCarIfRoleAdmin() throws Exception {
        var jsonString = asJsonString(carUpdateDto());
        mockMvc.perform(post("/api/car/" + CAR_ID)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonString))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testUpdateCarIfRoleUser() throws Exception {
        var jsonString = asJsonString(carUpdateDto());
        mockMvc.perform(post("/api/car/" + CAR_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonString))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    @Transactional
    @WithMockUser(username = "admin", authorities = {"ADMIN"})
    public void testRemoveDriverWithRoleAdmin() throws Exception {
        mockMvc.perform(delete("/api/driver/delete/" + CAR_ID))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testRemoveDriverWithRoleUser() throws Exception {
        mockMvc.perform(delete("/api/driver/delete/" + CAR_ID))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", authorities = {"ADMIN"})
    public void testCreateDriverWithRoleAdmin() throws Exception {
        mockMvc.perform(put("/api/car/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(carCreateDto())))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testCreateDriverWithRoleUser() throws Exception {
        mockMvc.perform(put("/api/car/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(carCreateDto())))
                .andDo(print())
                .andExpect(status().isForbidden());
    }
}

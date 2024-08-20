package com.app.webf1;

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

import static com.app.webf1.TestData.teamCreateDto;
import static com.app.webf1.TestData.teamUpdateDto;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
public class TeamControllerTest extends BaseTest {
    private final static int TEAM_ID = 1;
    private static final int ALL_TEAMS_COUNT = 10;
    @Autowired
    private MockMvc mockMvc;
    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testGetTeamById() throws Exception {
        mockMvc.perform(get("/api/team/" + TEAM_ID )
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Oracle Red Bull Racing"));
    }
    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testGetAllTeam() throws Exception {
        mockMvc.perform(get("/api/team")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(ALL_TEAMS_COUNT));
    }


    @Test
    @WithMockUser(username = "admin", authorities = {"ADMIN"})
    public void testUpdateTeamIfRoleAdmin() throws Exception {
        mockMvc.perform(post("/api/team/" + TEAM_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonString.asJsonString((teamUpdateDto()))))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testUpdateTeamIfRoleUser() throws Exception {
        mockMvc.perform(post("/api/team/" + TEAM_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonString.asJsonString((teamUpdateDto()))))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    @Transactional
    @WithMockUser(username = "admin", authorities = {"ADMIN"})
    public void testRemoveDriverWithRoleAdmin() throws Exception {
        mockMvc.perform(delete("/api/team/" + TEAM_ID))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testRemoveDriverWithRoleUser() throws Exception {
        mockMvc.perform(delete("/api/team/" + TEAM_ID))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", authorities = {"ADMIN"})
    public void testCreateTeamWithRoleAdmin() throws Exception {
        mockMvc.perform(put("/api/team")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonString.asJsonString((teamCreateDto()))))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testCreateTeamWithRoleUser() throws Exception {
        mockMvc.perform(put("/api/team")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonString.asJsonString((teamCreateDto()))))
                .andDo(print())
                .andExpect(status().isForbidden());
    }
}

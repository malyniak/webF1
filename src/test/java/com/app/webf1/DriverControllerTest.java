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

import static com.app.webf1.JsonString.asJsonString;
import static com.app.webf1.TestData.driverUpdateDto;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
public class DriverControllerTest extends BaseTest {
    private static final int ALL_DRIVERS_COUNT = 20;
    private static final String DRIVER_LASTNAME_WITH_ID1 = "Verstappen";
    private static final int DRIVER_ID = 1;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testGetDriverById() throws Exception {
        mockMvc.perform(get("/api/driver/" + DRIVER_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lastname").value(DRIVER_LASTNAME_WITH_ID1));
    }


    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testGetDriverAll() throws Exception {
        mockMvc.perform(get("/api/driver")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(ALL_DRIVERS_COUNT));
    }

    @Test
    @WithMockUser(username = "admin", authorities = {"ADMIN"})
    public void testUpdateDriver() throws Exception {
        mockMvc.perform(post("/api/driver/" + DRIVER_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(driverUpdateDto())))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testUpdateDriverWithRoleUser() throws Exception {
        mockMvc.perform(post("/api/driver/" + DRIVER_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(driverUpdateDto())))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    public void testUpdateDriverUnAuthorized() throws Exception {
        mockMvc.perform(post("/api/driver/" + DRIVER_ID)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(driverUpdateDto())))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    @Transactional
    @WithMockUser(username = "admin", authorities = {"ADMIN"})
    public void testRemoveDriverWithRoleAdmin() throws Exception {
        mockMvc.perform(delete("/api/driver/delete/" + DRIVER_ID))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    @Transactional
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testRemoveDriverWithRoleUser() throws Exception {
        mockMvc.perform(delete("/api/driver/delete/" + DRIVER_ID))
                .andDo(print())
                .andExpect(status().isForbidden());
    }
}

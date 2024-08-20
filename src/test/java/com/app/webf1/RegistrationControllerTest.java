package com.app.webf1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
public class RegistrationControllerTest extends BaseTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegisterUser() throws Exception {
        mockMvc.perform(put("/api/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"newUser\",\"email\":\"newEmail@gmail.com\",\"phone_number\":\"380986449513\",\"password\":\"password\",\"role\":\"USER\"}"))
                .andExpect(status().isCreated());
    }
    @Test
    public void testRegisterUserWithDuplicateData() throws Exception {
        mockMvc.perform(put("/api/registration")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"user\",\"email\":\"user@gmail.com\",\"phone_number\":\"380986449542\",\"password\":\"password\",\"role\":\"USER\"}"))
                .andExpect(status().isConflict());
    }
}

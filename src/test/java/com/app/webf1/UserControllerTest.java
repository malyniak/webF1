package com.app.webf1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest extends BaseTest {
    private static final int ALL_USERS_COUNT = 2;
    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "dev", authorities = {"DEV"})
    public void testGetUserByIdWithRoleDev() throws Exception {
        mockMvc.perform(get("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", authorities = {"USER"})
    public void testGetUserByIdWithRoleUser() throws Exception {
        mockMvc.perform(get("/api/users/1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "dev", authorities = {"DEV"})
    public void testUserNotFound() throws Exception {
        mockMvc.perform(get("/api/users/100"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound());
    }

    @Test
    void getUnauthorized() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/users"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "dev", authorities = {"DEV"})
    public void getAll() throws Exception {
        mockMvc.perform(get("/api/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(ALL_USERS_COUNT))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "dev", authorities = {"DEV"})
    public void testCreateUser() throws Exception {
        mockMvc.perform(put("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"newUser\",\"email\":\"newEmail@gmail.com\",\"phone_number\":\"380986449513\",\"password\":\"password\",\"role\":\"USER\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser(username = "dev", authorities = {"DEV"})
    public void testCreateUserWithDuplicateData() throws Exception {
        mockMvc.perform(put("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\":\"user\",\"email\":\"user@gmail.com\",\"phone_number\":\"380986449513\",\"password\":\"password\",\"role\":\"USER\"}"))
                .andExpect(status().isConflict());
    }
}

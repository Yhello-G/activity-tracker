package com.manuel.taskmanager.controller;

import com.manuel.taskmanager.model.User;
import com.manuel.taskmanager.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RegisterControllerTest {

    @Mock
    UserService userServiceMock;

    @InjectMocks
    RegisterController registerController;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(registerController).build();
    }

    @Test
    public void showRegisterForm_shouldReturnStatusOkAndRegisterFormAsViewNameAndUserAsAttribute() throws Exception {
        Long id = 1L;

        verifyZeroInteractions(userServiceMock);

        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("views/registerForm"))
                .andExpect(model().attribute("user", instanceOf(User.class)));
    }
}
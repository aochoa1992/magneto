package com.magneto.magneto.controller;

import com.magneto.magneto.dto.User;
import com.magneto.magneto.services.impl.UserService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

class UserControllerTest {

    UserController userController;

    @Mock
    UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userController = new UserController(userService);
    }

    @Test
    void getToken() {
        User user = new User();
        user.setUserName("Alejo");
        user.setToken("Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiQWxlam8iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjU5NTczNDg2LCJleHAiOjE2NTk1NzQwODZ9.UQGDWKwlFUt0oCiYqNxvnB1ULICGFqID_zsI9DAwJtWsqsVjT8znVtb2DZCeWLoyfZBYgXYQ2Pz4qZ_wlaSe6Q");

        when(userService.getJWTToken(user.getUserName())).thenReturn(user.getToken());

        User result = userController.login(user);

        Assert.assertEquals(result, user);
    }
}

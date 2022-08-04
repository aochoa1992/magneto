package com.magneto.magneto.services.impl;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

class UserServiceTest {
    UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        userService = new UserService();
    }

    @Test
    void getJWTToken() {
        String token = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJzb2Z0dGVrSldUIiwic3ViIjoiQWxlam8iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjU5NTc1ODg1LCJleHAiOjE2NTk1NzY0ODV9.AF-p13mFTt5886tZ3vcQLuMx6kNqXo3cqial1Q6b3jJGzB0x79Tk9sydW3wp_GR5GPK-zhSH36wBkjjmqF3iaQ";

        String result = userService.getJWTToken("Alejo");
        Assert.assertNotEquals(result, token);
    }
}

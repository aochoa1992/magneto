package com.magneto.magneto.controller;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

class HealthTest {

    Health health;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        health = new Health();
    }

    @Test
    void health() {
        String result = health.health();
        Assert.assertEquals("Magneto Ok!!", result);
    }

}

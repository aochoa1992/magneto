package com.magneto.magneto.utils;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

class InputValidationsTest {

    InputValidations inputValidations;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        inputValidations = new InputValidations();
    }

    @Test
    void validateString_success() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCGA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCTTA");
        dna.add("TCACTG");

        boolean result = inputValidations.validateString(dna.toString());

        validateResponse(result, true);
    }

    @Test
    void validateString_fail() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCKA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCTTA");
        dna.add("TCACTG");

        boolean result = inputValidations.validateString(dna.toString());

        validateResponse(result, false);
    }

    @Test
    void validateEachSequence_success() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCKA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCTTA");
        dna.add("TCACTG");

        boolean result = inputValidations.validateEachSequence(dna);

        validateResponse(result, true);
    }

    @Test
    void validateEachSequence_fail() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCKAA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");
        dna.add("CCCTTA");
        dna.add("TCACTG");

        boolean result = inputValidations.validateEachSequence(dna);

        validateResponse(result, false);
    }

    @Test
    void validateSizeArray_success() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCKA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");

        boolean result = inputValidations.validateSizeArray(dna);

        validateResponse(result, true);
    }

    @Test
    void validateSizeArray_fail() {
        List<String> dna = new ArrayList<>();
        dna.add("ATG");
        dna.add("CAG");
        dna.add("TTA");

        boolean result = inputValidations.validateSizeArray(dna);

        validateResponse(result, false);
    }

    @Test
    void validateObliqueProcess_success() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCKA");
        dna.add("CAGTGC");
        dna.add("TTATGT");
        dna.add("AGAAGG");

        boolean result = inputValidations.validateObliqueProcess(dna);
        validateResponse(result, true);
    }

    @Test
    void validateObliqueProcess_fail() {
        List<String> dna = new ArrayList<>();
        dna.add("ATGCKA");
        dna.add("CAGTGC");
        dna.add("TTATGT");

        boolean result = inputValidations.validateObliqueProcess(dna);
        //Assert.assertEquals(result, false);
        validateResponse(result, false);
    }

    void validateResponse(boolean result, boolean value) {
        Assert.assertEquals(result, value);
    }
}

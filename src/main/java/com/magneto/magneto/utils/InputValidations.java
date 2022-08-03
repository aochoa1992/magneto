package com.magneto.magneto.utils;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class InputValidations {

    public boolean validateString(String dna) {
        Scanner scanner = new Scanner(dna);
        String validationResult = scanner.findInLine("[BDEFHIJKLMNÑOPQRSUVWYZ]+");
        if (validationResult != null) {
            scanner.close();
            return false;
        }
        scanner.close();
        return true;
    }

    public boolean validateEachSequence(List<String> dna) {
        String rowAux = dna.get(0);
        for (String row : dna) {
            if(rowAux.length() == row.length()) {
                rowAux = row;
            }
            else {
                return false;
            }
        }
        return true;
    }

    public boolean validateSizeArray(List<String> dna) {
        return (dna.get(0).length() > 3 || dna.size() > 3);
    }

    public boolean validateObliqueProcess(List<String> dna) {
        return (dna.get(0).length() > 3 && dna.size() > 3);
    }
}

package com.magneto.magneto.services.impl;

import com.magneto.magneto.services.IDnaService;
import com.magneto.magneto.services.IMutantService;
import com.magneto.magneto.utils.InputValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MutantService implements IMutantService {

    private char auxLetter = ' ';
    private int countLetter = 0;
    private IDnaService dnaService;
    private InputValidations inputValidations;

    @Autowired
    public MutantService(IDnaService dnaService, InputValidations inputValidations) {
        this.dnaService = dnaService;
        this.inputValidations = inputValidations;
    }

    public boolean isMutant(List<String> dna) {
        int sizeSequence = 0;
        boolean isMutant = false;
        sizeSequence = getResultHorizontal(dna, dna.size(), dna.get(0).length());
        sizeSequence = sizeSequence + getResultVertical(dna, dna.size(), dna.get(0).length());

        if(inputValidations.validateObliqueProcess(dna)) {
            sizeSequence = sizeSequence + getResultOblique(dna, false);
            sizeSequence = sizeSequence + getResultOblique(dna, true);
        }

        if (sizeSequence > 2) {
            isMutant = true;
        }
        dnaService.saveDNA(dna, isMutant);
        return isMutant;
    }

    private int getResultHorizontal(List<String> listDna, int rows, int colums) {
        int sizeSequence = 0;
        for (int i = 0; i < rows; i ++) {
            countLetter = 0;
            auxLetter = ' ';
            for(int j = 0; j < colums; j ++) {
                countLetter = validateSequence(lettersSequence(listDna.get(i).charAt(j)), countLetter);
                if(countLetter == 4){
                    sizeSequence++;
                    break;
                }
            }
        }
        return sizeSequence;
    }

    private int getResultVertical(List<String> listDna, int rows, int colums) {
        int sizeSequence = 0;
        for (int i = 0; i < colums; i ++) {
            countLetter = 0;
            auxLetter = ' ';
            for(int j = 0; j < rows; j ++) {
                countLetter = validateSequence(lettersSequence(listDna.get(j).charAt(i)), countLetter);
                if(countLetter == 4){
                    sizeSequence++;
                    break;
                }
            }
        }
        return sizeSequence;
    }

    private int getResultOblique(List<String> dna, boolean isReverse) {
        int dnaSize = dna.size();
        int stringLength = dna.get(0).length();
        int cycle = dnaSize + dna.get(0).length() -1;
        int sizeSequence = 0;

        for(int f = 0; f < cycle; f ++) {
            countLetter = 0;
            auxLetter = ' ';
            for (int k = 0; k <= f; k++) {
                if (isReverse) {
                    countLetter = validateSequence(logicReverse(stringLength, f, k, dnaSize, dna), countLetter);
                } else {
                    countLetter = validateSequence(logic(f, k, dnaSize, dna), countLetter);
                }
                if (countLetter == 4) {
                    sizeSequence++;
                    break;
                }
            }
        }

        return sizeSequence;
    }

    private boolean logicReverse(int stringLength, int f, int k, int dnaSize, List<String> dna) {
        int letterPosition = (stringLength - 1) - k;
        int arrayPosition =  f - k;

        if(arrayPosition < dnaSize && letterPosition >= 0) {
            char letter = dna.get(arrayPosition).charAt(letterPosition);
            return lettersSequence(letter);
        }
        return false;
    }

    private boolean logic(int f, int k, int dnaSize, List<String> dna) {
        int aux = k;
        if(k < dnaSize) {
            if (dna.get(k).length() <= f) {
                aux = (f + k) - (dna.get(k).length() - 1);
            }

            if (aux < dna.get(k).length()) {
                char letter = dna.get(aux).charAt(f - aux);
                return lettersSequence(letter);
            }
        }
        return false;
    }

    private boolean lettersSequence(char letter) {
        if(auxLetter == ' ') {
            auxLetter = letter;
            return true;
        } else {
            if(auxLetter == letter) {
                return true;
            } else {
                auxLetter = letter;
            }
        }
        return false;
    }

    private int validateSequence(boolean result, int countLetter) {
        int count = countLetter;
        if(result) {
            count ++;
        } else {
            count = 1;
        }
        return count;
    }
}

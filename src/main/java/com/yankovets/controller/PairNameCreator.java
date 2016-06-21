package com.yankovets.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairNameCreator {
    private final static byte NOTATION = 36;                 //9 - Arabic numerals + 26 - Latin characters
    private final static byte ASCII_CODE_FIGURE_ZERO = 48;   //48 - ASCII code of '0'
    private final static byte ASCII_CODE_A = 65;             //65 - ASCII code of capital 'A'

//      1    2    3    4    5    6    7    8    9   10
    /*{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
       'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
       'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
       'U', 'V', 'W', 'X', 'Y', 'Z'}*/
    private final static List<Long> pawsNotation = new ArrayList<Long>();
    private final static char[] alphabet = new char[NOTATION];

    public PairNameCreator() {
        fillPawsNotation(Long.MAX_VALUE);
        fillAlphabet();
    }

    public String getPairName(long decNumber) {

        String pairName = "";
        int k = 0;
        int item = 0;
        boolean isFlag = false;

        if (decNumber < 0) return "Error";
        if (decNumber == 0) {
            pairName += Character.toString(alphabet[(byte) item]);
        }
        else {

            while ((k >= 0) && (decNumber >= 0)) {
                if (decNumber <= NOTATION) {
                    pairName += Character.toString(alphabet[(byte) decNumber]);
                } else {

                    if (!isFlag) {
                        k = 0;
                        for (int i = 0; i < pawsNotation.size(); i++) {
                            if (pawsNotation.get(i) > decNumber) {
                                k = i - 1;
                                break;
                            } else if (i == pawsNotation.size() - 1) {
                                k = i;
                            }
                        }
                        isFlag = true;
                    }

                    item = (int) (decNumber / pawsNotation.get(k));
                    pairName += Character.toString(alphabet[(byte) item]);
                    decNumber -= item * pawsNotation.get(k);
                }
                k--;
            }
        }
        return pairName;
    }

    private void fillPawsNotation(long decNumber) {
        pawsNotation.add((long) 1);
        pawsNotation.add((long) NOTATION);

        long amount = NOTATION;
        while ((decNumber / (amount)) >= NOTATION) {
            amount *= NOTATION;
            pawsNotation.add(amount);
        }
    }

    private void fillAlphabet() {
        byte asciiCharCode = ASCII_CODE_FIGURE_ZERO;
        for (int i = 0; i < NOTATION; i++) {
            if (i <= 9) {
                if (i != 9) {
                    alphabet[i] = (char) asciiCharCode;
                    asciiCharCode++;
                } else {
                    alphabet[i] = (char) asciiCharCode;
                    asciiCharCode = ASCII_CODE_A;
                }
            } else {
                alphabet[i] = (char) asciiCharCode;
                asciiCharCode++;
            }
        }
    }

    public void print() {
        System.out.println(Arrays.toString(alphabet));
        System.out.println(pawsNotation.toString());
    }
}

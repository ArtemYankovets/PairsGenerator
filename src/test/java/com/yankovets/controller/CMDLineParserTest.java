package com.yankovets.controller;

import org.junit.Test;

import java.util.Arrays;

public class CMDLineParserTest {

    @Test
    public void Test() {
        String[] argsLine = {"c:/programmers.txt", "c:/pair_programmers.txt", "­add", "Пушкин Александр", "Стивен Кинг", "Агата Кристи", "­del", "2", "10", "33"};

        CMDLineParser parser = new CMDLineParser(argsLine);
        System.out.println(Arrays.toString(argsLine));
        parser.pareseLine();
        System.out.println("New Users: " + parser.getNewUsers());
        System.out.println("Del Users: " + parser.getDelUserNumbers());
    }

}

package com.yankovets.controller;

import com.yankovets.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CMDLineParser {

    private final String[] scrLine;

    private String srcFileName = "programmers.txt";
    private String dstFileName = "pair_programmers.txt";
    private String add = "add";
    private String del = "del";

    private String srcFilePass;
    private String dstFilePass;

    private boolean isAdd;
    private boolean isDel;

    private List<User> newUsers = new ArrayList<>();
    private List<Long> delUserNumbers = new ArrayList<>();

    public CMDLineParser(String[] scrLine) {
        this.scrLine = scrLine;
    }

    public void pareseLine() {
        boolean isValid = false;

        if ((scrLine[0].contains(srcFileName)) && (scrLine[1].contains(dstFileName))) {
            srcFilePass = scrLine[0];
            dstFilePass = scrLine[1];
            isValid = true;
        }

        if (!isValid) {
            //write to Error.txt
        } else {
            int i = 2;
            if ((i < scrLine.length) && (scrLine[i].contains(add))) {
                i++;
                isAdd = true;
                while ((i < scrLine.length) && !scrLine[i].contains(del)) {
                    newUsers.add(newUserNamesParser(scrLine[i]));
                    i++;
                }
            }
            if ((i < scrLine.length) && (scrLine[i].contains(del))) {
                i++;
                isDel = true;
                while ((i < scrLine.length)) {
                    delUserNumbers.add(Long.parseLong(scrLine[i]));
                    i++;
                }
            }
        }
    }


    private User newUserNamesParser(String strNames) {
        String[] partsOfNames = new String[2];
        int k = 0;
        int startPos = 0;
        int endPos = startPos;
        boolean f = false;
        char[] charNames = strNames.toCharArray();

        do {
            if ((endPos < charNames.length) && (charNames[endPos] != ' '))  {
                if (!f) {
                    startPos = endPos;
                    f = true;
                }
            } else {
                f = false;
                partsOfNames[k++] = strNames.substring(startPos, endPos);
            }
        } while (endPos++ < charNames.length);
        return new User(Long.valueOf(-1), '\u0000', partsOfNames[0], partsOfNames[1]);
    }

    @Override
    public String toString() {
        return "CMDLineParser{" +
                "scrLine=" + Arrays.toString(scrLine) +
                '}';
    }

    public List<User> getNewUsers() {
        return newUsers;
    }

    public List<Long> getDelUserNumbers() {
        return delUserNumbers;
    }
}

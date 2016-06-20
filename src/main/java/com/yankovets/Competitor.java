package com.yankovets;

import java.util.ArrayList;
import java.util.List;

public class Competitor {

    private final String lastName;
    private final String firstName;
    private final static byte ASCII_CODE_NUMBER_SIGN = 35;             //35 - ASCII code of capital '#'

    private static boolean isRemoved;
    List<Group> listOfGroups = new ArrayList<>();

    public Competitor(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.isRemoved = false;

    }

    public void compatitorRemoving(){
        for (Group group : listOfGroups) {
            group.setPairNumber((char)ASCII_CODE_NUMBER_SIGN + group.getPairNumber());
        }
    }

    private void printListOfPairs(){
        for (Group group : listOfGroups) {
            System.out.println(group.getPairNumber());
        }
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public static boolean isRemoved() {
        return isRemoved;
    }

    @Override
    public String toString() {
        return "Competitor " + lastName + " "
                + firstName + ":\t" +
                ", listOfGroups=" + listOfGroups +
                '}';
    }
}

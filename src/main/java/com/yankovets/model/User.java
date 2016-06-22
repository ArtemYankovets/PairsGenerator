package com.yankovets.model;

import java.util.List;

public class User extends Model{
    private final String firstName;
    private final String secondName;
    private boolean isRemoved;
    private final static byte ASCII_CODE_NUMBER_SIGN = 35;             //35 - ASCII code of capital '#'

    private List<Group> groups;

       public User(Long id, char numerSign, String firstName, String secondName) {
        super(id);
        this.firstName = firstName;
        this.secondName = secondName;
        if (numerSign == ASCII_CODE_NUMBER_SIGN) this.isRemoved = true;
        else this.isRemoved = false;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void remove(){
        this.isRemoved = true;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", isRemoved=" + isRemoved +
                ", groups=" + groups +
                '}';
    }
}

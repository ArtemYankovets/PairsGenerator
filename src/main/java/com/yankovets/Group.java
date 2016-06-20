package com.yankovets;

import java.util.Arrays;

public class Group {
    private final Competitor[] compatitors = new Competitor[2];
    private boolean isOnePersonInGroupe;
    private String pairNumber;
    private final static byte ASCII_CODE_CARET = 94;             //94 - ASCII code of capital '^'

    public Group(Competitor firstCompetitor, Competitor secondCompetitor, String pairNumber) {
        final int checker = setNamesOfCompatitors(firstCompetitor, secondCompetitor);
        switch (checker) {
            case -1:
                System.out.println("Error");
            case 0:
                this.isOnePersonInGroupe = true;
                setPairNumber(pairNumber);
                break;
            case 1:
                this.isOnePersonInGroupe = false;
                setPairNumber((char)ASCII_CODE_CARET + pairNumber);
        }
    }

    private int setNamesOfCompatitors (Competitor firstCompetitor, Competitor secondCompetitor) {
        int i = 0;
        int checker = 0;
        if ((firstCompetitor == null) || ((firstCompetitor.getFirstName().equals("")) || (firstCompetitor.getLastName().equals("")))) {
            checker = 1;
        } else {
            compatitors[i++] = firstCompetitor;
        }

        if ((secondCompetitor == null) || ((secondCompetitor.getFirstName().equals("")) || (secondCompetitor.getLastName().equals("")))) {
            if (checker == 1) checker = -1;
            else checker = 1;
        } else {
            compatitors[i++] = secondCompetitor;
        }
        return checker;
    }

    public Competitor[] getCompatitors() {
        return compatitors;
    }

    public void setPairNumber(String pairNumber) {
        this.pairNumber = pairNumber;
    }

    public String getPairNumber() {
        return pairNumber;
    }

    @Override
    public String toString() {
        return "Group{" +
                "compatitors=" + Arrays.toString(compatitors) +
                ", pairNumber='" + pairNumber + '\'' +
                '}';
    }
}

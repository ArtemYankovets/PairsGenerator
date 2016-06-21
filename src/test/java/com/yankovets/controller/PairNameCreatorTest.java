package com.yankovets.controller;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PairNameCreatorTest {

    @Test
    public void PairName_0_To_0(){
        PairNameCreator creator = new PairNameCreator();
        String genPairName = creator.getPairName(0);
        assertEquals("0", genPairName);
    }

    @Test
    public void PairName_10_To_A(){
        PairNameCreator creator = new PairNameCreator();
        String genPairName = creator.getPairName(10);
        assertEquals("A", genPairName);
    }

    @Test
    public void PairName_360_To_A0(){
        PairNameCreator creator = new PairNameCreator();
        String genPairName = creator.getPairName(360);
        assertEquals("A0", genPairName);
    }

    @Test
    public void PairName_7000000_To_A0(){
        PairNameCreator creator = new PairNameCreator();
        String genPairName = creator.getPairName(7000000);
        assertEquals("4618G", genPairName);
    }

    @Test
    public void PairName_LongMaxValue_To_1Y2P0IJ32E8E7(){
        PairNameCreator creator = new PairNameCreator();
        String genPairName = creator.getPairName(Long.MAX_VALUE);
        assertEquals("1Y2P0IJ32E8E7", genPairName);
    }
}
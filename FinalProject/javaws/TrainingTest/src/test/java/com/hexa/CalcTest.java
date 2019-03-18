package com.hexa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CalcTest{
    @Test

    public void checkAdd(){
        Calc c = new Calc();
        int v = c.add(5,5);
        assertEquals(10,v);
    }

    @Test
    public void checkName(){
        Calc c = new Calc();
        c.setName("Hi");
        assertTrue(c.isNameAvailable());

        c.setName("");
        assertFalse(c.isNameAvailable());
    }
}
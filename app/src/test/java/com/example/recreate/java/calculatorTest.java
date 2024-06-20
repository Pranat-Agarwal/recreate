package com.example.recreate.java;

import junit.framework.TestCase;

public class calculatorTest extends TestCase {

    calculator calculator;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        calculator=new calculator();
    }

    public void testAdd(){
        int expect = 30;
        int ex=40;
        int actual= calculator.add(10,20);
        assertEquals(expect,actual);
        assertEquals(ex,actual);
    }

    public void testmul(){
        int exp=20;
        int ac=calculator.mul(4,5);
        assertEquals(exp,ac);
    }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
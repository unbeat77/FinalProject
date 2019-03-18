package com.hexa;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;



/**
 * Unit test for simple App.
 */
public class LearnInvocationTest {
    /**
     * Rigorous Test :-)
     */
    @BeforeClass
    public static void init(){
        System.out.println("Before class each is called once");
    }

    @Before
    public void calledBeforeOfEachTest(){
        System.out.println("Before this  method will be invoked before executing each test");
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println("Learning JUnit");
        assertTrue( true );
    }

    @Test
    public void test2(){
        System.out.println("Test 2 invoked");
    }

    @After
    public void calledAfterEachTest(){
        System.out.println("After This method is invoked after each test");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("After class is called once");
    }
}

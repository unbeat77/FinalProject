package com.hexa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class StudentTest{

    @Test

    public void testStudentInfo(){
        Student s = null;
        assertNull(s);

        Student s1 = new Student();
        assertNotNull("student not null" + s1);

        Student s2 = new Student();
        s2.setName("Dus");
        assertEquals("Dus", s2.getName());
        s2.setRegNo(10);
        assertEquals(10, s2.getRegno());

        assertNotEquals("latha", s2.getName());
        assertNotEquals(11, s2.getRegno());
    }

    @Test

    public void testStudentCons (){
        Student s1 = new Student(12, "Anu");
        assertNotNull(s1);
        assertEquals(12, s1.getRegno());
        assertEquals("Anu", s1.getName());
    }

    @Test
    public void testStudentObejects() {
        Student expected = new Student(12 , "Anu");
        Student actual = new Student(12, "Anu");

        assertEquals(expected, actual);

        Student act2 = new Student(100, "lavanya");
        assertNotEquals(expected, act2);
    }
}
package com.hexa;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class  StudentFactoryTest{

    @Test
    public void updateTest(@Mocked final StudentDAO sdao) {
        final String expected = "Data updated";

        new Expectations() {{
            System.out.println("mocked update");
            sdao.update(3500, "Lavi");
            result = any;
        }
        };



        new MockUp<StudentFactory>() {
            @Mock
                StudentDAO getDAO(){
                    System.out.println("mocked DAO");
                    return sdao;
                }
            };

        StudentFactory sd = new StudentFactory();
        String actual = sd.upDateData(3500, "Lavi");
        assertEquals(expected, actual);
    }

    @Test
    public void testStudentList(@Mocked final StudentDAO sdao) {
        int expectedSize = 1;
        final List<Student> lstexp = new ArrayList<Student>();
        final Student s = new Student(3000, "latha");
        lstexp.add(s);
        new Expectations() {{
            System.out.println("mocked getAllStudents");
            
            sdao.getStudentList();
            result = lstexp;
        }};

        new MockUp<StudentFactory>() {
            @Mock
            StudentDAO getDAO(){
                System.out.println("mocked Dao");
                return sdao;
            }
        };
        StudentFactory sd = new StudentFactory();
        List<Student> stArr = sd.getStudentDetails();
        assertEquals(expectedSize, stArr.size());
    }

    @Test
     public void getStudentTest(
         @Mocked final StudentDAO sdao) {

        final Student ste = new Student(3265,"Anitha");
        new Expectations() { {

            System.out.println("mocked getStudents");
            sdao.getStudent(3265);
            result = ste;
        }};

        new MockUp<StudentFactory>() {
            @Mock
            StudentDAO getDAO(){
                System.out.println("mocked DAO");
                return sdao;
            }
        };
        StudentFactory sd = new StudentFactory();
        Student stA = sd.getStudents(3265);
        assertEquals(ste, stA);
     }

     @Test
     public void insertDataTest(@Mocked final StudentDAO sdao) {
         final String expected = "Data inserted";
         

         new Expectations() {{
             System.out.println("mock insert");

             sdao.insert(3500, "Lavi");
             result = any;

         }
         };

        new MockUp<StudentFactory>() {
        @Mock
            StudentDAO getDAO(){
                System.out.println("mocked DAO");
                return sdao;
            }
        };

        StudentFactory sd = new StudentFactory();
        String actual = sd.insertData(3500, "Lavi");
        assertEquals(expected, actual);
    }
}
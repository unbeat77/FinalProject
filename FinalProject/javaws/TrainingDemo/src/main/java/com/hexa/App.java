package com.hexa;

import java.util.List;

public class App {
    public static void main(String[] args) {
        StudentFactory st = new StudentFactory();
        List<Student> l = st.getAllStudents();
        for(Student s:l)
        System.out.println(s);
        
    }
}

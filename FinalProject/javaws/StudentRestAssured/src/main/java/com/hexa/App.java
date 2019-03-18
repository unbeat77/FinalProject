package com.hexa;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Student mapper" );
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the student regno: ");
        int regNo = sc.nextInt();
        System.out.println("Enter the student name: ");
        String name = sc.next();

        /*
        System.out.println("Enter the student regno to modify: ");
        int rregNo = sc.nextInt();
        System.out.println("Enter the student name to replace: ");
        String nname = sc.next();
        */

        StudentFactory sf = new StudentFactory();
        
        String msg = sf.insertData(regNo,name);
        System.out.println(msg);
       
        //String msg1 = sf.upDateData(regNo,name);
        //System.out.println(msg1);

        //Student stu = sf.getStudents(101);
        //System.out.println(stu);
       
        List<Student> ls = sf.getStudentDetails();
        for(Student s: ls)
        System.out.println(s);
        sc.close();

    }
}


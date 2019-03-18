package com.hexa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException
    {
        System.out.println( "Welcome to Student mapper" );
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the student regno: ");
        int regNo = sc.nextInt();
        System.out.println("Enter the student name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Enter dob");
        String d1 = sc.nextLine();
        DateTimeFormatter formatter =
                      DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.parse(d1, formatter);
        //dob = dateFormat.parse(date);
        System.out.println("Enter the marks");
        int marks = sc.nextInt();
        char grade = StudentFactory.MarksCal(marks);

    

        StudentFactory sf = new StudentFactory();
        
        String msg = sf.insertData(regNo,name,date,grade);
        System.out.println(msg);
       
       
        List<Student> ls = sf.getStudentDetails();
        for(Student s: ls)
        System.out.println(s);
        sc.close();

    }
}


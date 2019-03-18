//StudentFactory.java 

package com.hexa;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.skife.jdbi.v2.DBI;
public class StudentFactory {
   
    public List<Student>getStudentDetails()
    {
        StudentDAO mDao = getDAO();
        List<Student> lst = mDao.getStudentList();
        return lst;

    }
    public String upDateData(int regNo, String name) {
        StudentDAO mDao = getDAO();
        mDao.update(regNo, name);
        return "Data updated";
    }
    public String insertData(int regNo, String name, LocalDate dob, char grade) {
        StudentDAO mDao = getDAO();
        mDao.insert(regNo, name, dob, grade);
        return "Data inserted";
    }
    public Student getStudents(int regNo) {
        StudentDAO mDao = getDAO();
        Student s = mDao.getStudent(regNo);
        return s;
    }
    
    public StudentDAO getDAO() 
    {
        DBI dbi = DBConnection.getConnection();
        StudentDAO mDao = dbi.onDemand(StudentDAO.class);
        return mDao;
    }

    public static char MarksCal(int marks){
        if (marks > 80){
            System.out.println('O');
            return 'O';
        }
        else if (marks > 70 && marks < 80){
            System.out.println('A');
            return 'A';
        }
        else if (marks > 60 && marks < 70){
            System.out.println('B');
            return 'B';
        }
        else {
            System.out.println('F');
            return 'F';
        }
    }
}

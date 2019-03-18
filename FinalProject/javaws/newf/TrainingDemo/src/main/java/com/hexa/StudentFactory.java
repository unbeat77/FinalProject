package com.hexa;

import java.util.List;

import org.skife.jdbi.v2.DBI;

public class StudentFactory {
    public StudentDAO getDAO(){
        DBI dbi = DBConnection.getConnection();
        StudentDAO mDao=dbi.onDemand(StudentDAO.class);
        return mDao;
    }
public List<Student> getAllStudents(){
    StudentDAO mDao = getDAO();
    List<Student> lst = mDao.getStudentList();
    return lst;
}
}
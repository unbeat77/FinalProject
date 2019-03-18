//StudentFactory.java 


package com.hexa;

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
        int ret = -1;
        try{
            StudentDAO mDao = getDAO();
        ret = mDao.update(regNo, name);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        String retStr;
        if (ret>0)
            retStr = "Data Updated";
        else
            retStr = "Not updated";
        return retStr;
    }
    public String insertData(int regNo, String name) {
        int ret = -1;
        try{
            StudentDAO mDao = getDAO();
            ret = mDao.insert(regNo, name);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        String retStr;
        if (ret>0)
            retStr = "Data inserted";
        else
            retStr = "Data not inserted";
        return retStr;
    }
    public Student getStudents(int regNo) {
        StudentDAO mDao = getDAO();
        Student s = mDao.getStudent(regNo);
        return s;
    }
    
    public StudentDAO getDAO() {
        DBI dbi = DBConnection.getConnection();
        StudentDAO mDao = dbi.onDemand(StudentDAO.class);
        return mDao;
    }
}

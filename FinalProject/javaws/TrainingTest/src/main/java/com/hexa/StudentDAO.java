//StudentDAO.java

package com.hexa;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
public interface StudentDAO{
    @SqlQuery("SELECT * from Student")
    @Mapper(StudentMapper.class)
    List<Student> getStudentList();
    
    @SqlQuery("SELECT * from Student where regNo=:regNo")
    @Mapper(StudentMapper.class)
    Student getStudent(@Bind("regNo") int regNo);
    
    @SqlUpdate("insert into STUDENT values (:regNo,:name, :dob, :Grade)")
    @Mapper(StudentMapper.class)
    void insert(@Bind("regNo") int regNo,@Bind("name") String name,@Bind("dob") LocalDate dob,@Bind("Grade") char grade);
   
    
    @SqlUpdate("update STUDENT set name=:name where regNo=:regNo")
    @Mapper(StudentMapper.class)
    void update(@Bind("regNo") int regNo,@Bind("name") String name);
    
    
}

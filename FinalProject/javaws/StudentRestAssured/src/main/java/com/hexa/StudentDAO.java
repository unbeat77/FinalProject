//StudentDAO.java

package com.hexa;

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
    
    @SqlUpdate("insert into STUDENT values (:regNo,:name)")
    @Mapper(StudentMapper.class)
    int insert(@Bind("regNo") int regNo,@Bind("name") String name);
   
    
    @SqlUpdate("update STUDENT set name=:name where regNo=:regNo")
    @Mapper(StudentMapper.class)
    int update(@Bind("regNo") int regNo,@Bind("name") String name);
    
    
}

package com.hexa;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface StudentDAO{
    @SqlQuery("Select * from Student")
    @Mapper(StudentMapper.class)
    List<Student> getStudentList();
}
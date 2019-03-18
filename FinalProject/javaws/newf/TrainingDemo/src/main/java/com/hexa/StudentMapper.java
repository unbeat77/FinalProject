package com.hexa;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class StudentMapper implements ResultSetMapper<Student>{
    @Override
    public Student map(int index, ResultSet rs, StatementContext ctx) throws SQLException{
    return new Student(rs.getInt("regno"), rs.getString("name"));
}
}

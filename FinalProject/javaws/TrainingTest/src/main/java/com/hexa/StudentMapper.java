//StudentMapper.java


package com.hexa;
import java.sql.SQLException;
import java.sql.ResultSet;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;;

public class StudentMapper implements ResultSetMapper<Student> {
@Override
public Student map(int index, ResultSet rs, StatementContext ctx)
throws SQLException{
    return new Student(rs.getInt("regNo"),
    rs.getString("name"));
}
}


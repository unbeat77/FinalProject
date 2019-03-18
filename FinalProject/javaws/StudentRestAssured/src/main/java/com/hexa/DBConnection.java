// DBConnection.java

package com.hexa;
import org.skife.jdbi.v2.DBI;

public class DBConnection{
private static DBI dbi =null;
public static DBI getConnection() {
    try{
        Class.forName("com.mysql.jdbc.Driver");
    if ( dbi == null)
    {
        dbi = new DBI("jdbc:mysql://localhost:3306/student?useSSL=false","root","Password123");
    }
} catch(Exception e){}
return dbi;
}
}

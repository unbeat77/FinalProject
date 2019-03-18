package com.hexa;

import org.skife.jdbi.v2.DBI;
public class DBConnection{
    private static DBI dbi = null;

    public static DBI getConnection(){
        if (dbi == null){
            dbi = new DBI("jdbc:mysql://localhost:3306/ftp?useSSL=false", "root", "");
        }
        return dbi;
    }
}
package com.hexaware.FTP108.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.FTP108.model.Customers;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class CustomersMapper implements ResultSetMapper<Customers> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @throws SQLException in case there is an error in fetching data from the resultset
     * @return Menu
     */
  public final Customers map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    return new Customers(rs.getInt("C_ID"),
    rs.getString("C_NAME"),
    rs.getInt("C_WALLET"),
    rs.getString("C_PASSWORD"),
    rs.getString("C_EMAIL"),
    rs.getInt("C_PHONE"),
    rs.getString("C_ADDRESS"));
  }
}

package com.hexaware.FTP108.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.hexaware.FTP108.model.Vendor;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 * VendorMapper class used to fetch menu data from database.
 * @author hexware
 */
public class VendorMapper implements ResultSetMapper<Vendor> {
    /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped customer object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final Vendor map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
    return new Vendor(rs.getInt("V_ID"),
    rs.getString("V_NAME"), rs.getString("V_USERNAME"), rs.getString("V_PASS"),
    rs.getString("V_EMAIL"), rs.getString("V_PHONE"), rs.getString("V_ADDRESS"));
  }
}

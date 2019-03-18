package com.hexaware.FTP108.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.hexaware.FTP108.model.Orders;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * OrdersMapper class used to fetch Orders data from database.
 * @author hexware
 */
public class OrdersMapper implements ResultSetMapper<Orders> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Orders map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Orders
       */
    return new Orders(rs.getInt("O_ID"), rs.getInt("C_ID"), rs.getInt("FOOD_ID"),
                      rs.getInt("FOOD_QTY"), rs.getString("O_REASON"),
                      com.hexaware.FTP108.model.OStatus.valueOf(rs.getString("O_STATUS")),
                      rs.getFloat("O_TOT_PRICE"), rs.getTime("O_EST_TIME"), rs.getTime("O_TIME"),
                      rs.getDate("O_DATE"), rs.getInt("V_ID"));
  }
}

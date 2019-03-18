package com.hexaware.FTP108.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP108.model.Vendor;
import com.hexaware.FTP108.model.Orders;

/**
 * VendorDAO class used to fetch data from data base.
 * 
 * @author hexware
 */
public interface VendorDAO {
  /**
   * @return the all the vendor record.
   */
  @SqlQuery("Select * from Vendor")
  @Mapper(VendorMapper.class)
  List<Vendor> showallVendorDetails();

  /**
   * @param vPassword vendor password to get a vendor record.
   * @param vUserName vendor username to get a vendor record.
   * @return the all the vendor record.
   */
  @SqlQuery("select * FROM VENDOR where V_USERNAME =:vUserName and V_PASS=:vPassword")
  @Mapper(VendorMapper.class)
  Vendor validateVendor(@Bind("vUserName") String vUserName, @Bind("vPassword") String vPassword);

  /**
   * @param vId vendor id to get vendor record.
   * @return the all the vendor record.
   */
  @SqlQuery("Select * from VENDOR where V_ID = :vId")
  @Mapper(VendorMapper.class)
  List<Vendor> showVendorDetailsById(@Bind("vId") int vId);

  /**
   * @param vId    to get orders for vendor Id.
   * @param foodId to get orders for order Id.
   * @return the all the vendor record for a particular vendor and food id.
   */
  @SqlQuery("SELECT * FROM ORDERS where V_ID=:vId AND FOOD_ID=:foodId")
  @Mapper(OrdersMapper.class)
  List<Orders> getNoOfOrdersByfoodId(@Bind("vId") int vId, @Bind("foodId") int foodId);

  /**
   * 
   * @param vId Vendor ID.
   * @param dt1 Fist Date.
   * @param dt2 Last Date.
   * @return Orders array.
   */
  @SqlQuery("select * from orders where V_ID=:vId and O_STATUS='DELIVERED' and O_DATE between :dt1 and :dt2")
  @Mapper(OrdersMapper.class)
  List<Orders> getGST(@Bind("vId") int vId, @Bind("dt1") String dt1, @Bind("dt2") String dt2);
}

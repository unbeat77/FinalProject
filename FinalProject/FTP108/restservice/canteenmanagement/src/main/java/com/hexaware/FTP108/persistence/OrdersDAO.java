package com.hexaware.FTP108.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP108.model.Orders;
import com.hexaware.FTP108.model.Customers;
/**
 * OrdersDAO class used to fetch data from data base.
 * @author hexware
 */
public interface OrdersDAO {
  /**
   * @return the all the Orders record.
   */
  @SqlQuery("Select * from ORDERS order by O_DATE desc")
    @Mapper(OrdersMapper.class)
    List<Orders> showFullOrdersList();
  /**
   * @param cId for getting order details.
   * @return the all the Orders record.
   */
  @SqlQuery("Select * from ORDERS where C_ID = :cId")
    @Mapper(OrdersMapper.class)
    List<Orders> showOrdersFromCId(@Bind("cId") int cId);
 /**
   * @param vId all vendor id record.
   * @return return order table.
   */
  @SqlQuery("Select * from Orders where V_ID =:vId")
    @Mapper(OrdersMapper.class)
    List<Orders> showOrdersFromVid(@Bind("vId") int vId);
   /**
   * @param vId all vendor id record.
   * @return order table.
   */
  @SqlQuery("Select * from Orders where V_ID =:vId AND O_STATUS='PLACE_ORDER'")
    @Mapper(OrdersMapper.class)
    List<Orders> showOrdersFromOst(@Bind("vId") int vId);
  /**
   * @param cId all customer id record.
   * @param foodId all food id vallue.
   * @param foodQty all food quantity record.
   * @param o string value.
   * @param value orders reason.
   * @param oTotprice total price record.
   * @param ot1 estimated time.
   * @param ot2  ordered time.
   * @param od ordered date.
   * @param vId vendor record.
   * @return no of rows affected.
   */
  @SqlUpdate("INSERT INTO ORDERS(C_ID, FOOD_ID, FOOD_QTY, O_STATUS, O_REASON, O_TOT_PRICE ,O_EST_TIME, O_TIME, O_DATE, V_ID) VALUES(:C_ID, :FOOD_ID, :FOOD_QTY, :O_STATUS, :O_REASON, :O_TOT_PRICE, :O_EST_TIME, :O_TIME, :O_DATE, :V_ID)")
    @Mapper(OrdersMapper.class)
    int insertNewOrder(@Bind("C_ID") int cId, @Bind("FOOD_ID") int foodId, @Bind("FOOD_QTY") int foodQty,
      @Bind("O_STATUS") String o, @Bind("O_REASON") String value, @Bind("O_TOT_PRICE") float oTotprice,
      @Bind("O_EST_TIME") String ot1, @Bind("O_TIME") String ot2, @Bind("O_DATE") String od, @Bind("V_ID") int vId);
  /**
   * @param fId food id to get a customer record.
   * @return customer details.
   */
  @SqlQuery("Select * from CUSTOMERS WHERE FOOD_ID=:fId")
    @Mapper(OrdersMapper.class)
    Orders getOrderByFoodId(@Bind("fId") int fId);
  /**
   * @param oId to update the record.
   * @param oR to update the record.
   * @param ost to update the record.
   * @param vId to update the record.
   * @return oId the all the Orders record to get oid.
   */
  @SqlUpdate("UPDATE ORDERS SET O_STATUS=:oStatus, O_REASON=:oR WHERE O_ID=:oId AND V_ID=:vId AND O_STATUS='PLACE_ORDER'")
    int updateOStatus(@Bind("oStatus") String ost, @Bind("oR") String oR, @Bind("oId") int oId, @Bind("vId") int vId);
  /**
   * @param oId to update customer table.
   * @param cWallet to update cwallet.
   * @return oId the all the Orders record to get oid.
   */
  @SqlUpdate("update customers set C_WALLET=:cWallet + (select O_TOT_PRICE from orders where O_ID=:oId) where C_ID=(select C_ID from orders where O_ID=:oId)")
    int walletAdd(@Bind ("cWallet") float cWallet, @Bind("oId") int oId);
  /**
   * @param oId order id to get order details.
   * @return orders is used to get the order details.
   */
  @SqlQuery("Select * from orders WHERE O_ID=:oId")
    @Mapper(OrdersMapper.class)
    Orders getOrderByOId(@Bind("oId") int oId);
  /**
   * @param cid to get a customer details.
   * @return  orders is used to get the order details.
   */
  @SqlQuery("Select * from Customers where C_ID = :cid")
    @Mapper(CustomersMapper.class)
    Customers getWallet(@Bind("cid") int cid);
}

package com.hexaware.FTP108.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP108.model.Customers;
import com.hexaware.FTP108.model.Menu;
/**
 * CustomersDAO class used to fetch data from data base.
 * @author hexware
 */
public interface CustomersDAO {
    /**
     * @return the all the Customers record.
     */
  @SqlQuery("Select * from Customers")
    @Mapper(CustomersMapper.class)
    List<Customers> showAllCustomersDetails();
  /**
    *@return the cid
    *@param cid all customers record.
    */
  @SqlQuery("Select * from Customers where C_ID = :cid")
    @Mapper(CustomersMapper.class)
    List<Customers> showWalletDetails(@Bind("cid") int cid);
  /**
   *@return the cid
   *@param cName  customer name to get all customers record.
   *@param cPassword customer password to get all customers record.
   */
  @SqlQuery("SELECT * FROM CUSTOMERS WHERE C_NAME = :cName AND C_PASSWORD =:cPassword ")
    @Mapper(CustomersMapper.class)
    Customers verifyCustomers(@Bind("cName") String cName, @Bind("cPassword") String cPassword);
  /**
   *@return the cid
   *@param cid customer id to get all customers record.
   */
  @SqlQuery("Select * from Customers where C_ID = :cid")
    @Mapper(CustomersMapper.class)
    List<Customers> showCustById(@Bind("cid") int cid);
 /**
  * @return the foodId
  * @param foodId all customers record.
  */
  @SqlQuery("Select * from Menu where FOOD_ID = :foodId")
  @Mapper(MenuMapper.class)
  List<Menu> getFoodId(@Bind("foodId") int foodId);
  /**
   * @param wAmt to update a wallet amount detail in customer table.
   * @param cId customer id to update customer table.
   */
  @SqlUpdate("update Customers set C_WALLET =C_WALLET-:walletAmt WHERE C_ID=:cId")
  void deductTotalAmt(@Bind("walletAmt") float wAmt, @Bind("cId") int cId);
}

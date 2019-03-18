package com.hexaware.FTP108.factory;

import com.hexaware.FTP108.persistence.CustomersDAO;
import com.hexaware.FTP108.persistence.DbConnection;
import java.util.List;
import com.hexaware.FTP108.model.Customers;
import com.hexaware.FTP108.model.Menu;
/**
 * CustomersFactory class used to fetch Customers data from database.
 * @author hexware
 */
public class CustomersFactory {
  /**
   *  Protected constructor.
   */
  protected CustomersFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static CustomersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(CustomersDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Customers object.
   */
  public static Customers[] show() {
    List<Customers> customers = dao().showAllCustomersDetails();
    return customers.toArray(new Customers[customers.size()]);
  }
  /**
   * Call the data base connection.
   * @return the array of Customers object.
   * @param cName all customer name.
   * @param cPassword all customer password.
   */
  public static Customers verifyCustomer(final String cName, final String cPassword) {
    Customers c = dao().verifyCustomers(cName, cPassword);
    if (c != null) {
      String on = c.getCName();
      String pas = c.getCPassword();
      if (on.equals(cName) && pas.equals(cPassword)) {
        return c;
      } else {
        return null;
      }
    }
    return null;
  }
/**
 * Call the data base connection.
 * @param foodId to place order.
 * @return the array of Customers object.
*/
  public static Menu[] placeOrder(final int foodId) {
    List<Menu> menu = dao().getFoodId(foodId);
    for (Menu m:menu) {
      if (m.getFoodId() == foodId) {
        return menu.toArray(new Menu[menu.size()]);
      }
    }
    Menu[] temp = {};
    return temp;
  }
/**
 * @param cId for displaying wallet details.
 * @return cWallet : wallet amount of customer
 */
  public static Customers[] showWallet(final int cId) {
    List<Customers> cWallet = dao().showWalletDetails(cId);
    return cWallet.toArray(new Customers[cWallet.size()]);
  }
  /**
 * @param cId for displaying customer details.
 * @return  details of customer
 */
  public static Customers[] showCustDetailsById(final int cId) {
    List<Customers> customers = dao().showCustById(cId);
    return customers.toArray(new Customers[customers.size()]);
  }
  /**
   * @param wAmt to get wallet amount.
   * @param cId to get customer ID.
   * @return return 1.
   */
  public static int deductAmt(final float wAmt, final int cId) {
    dao().deductTotalAmt(wAmt, cId);
    return 1;
  }
}

package com.hexaware.FTP108.factory;

import com.hexaware.FTP108.persistence.OrdersDAO;
import com.hexaware.FTP108.model.Customers;
import com.hexaware.FTP108.model.Menu;
import com.hexaware.FTP108.model.Orders;
import com.hexaware.FTP108.persistence.DbConnection;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
/**
 * OrdersFactory class used to fetch Orders data from database.
 * @author hexware
 */
public class OrdersFactory {
  /**
   *  Protected constructor.
   */
  protected OrdersFactory() {
  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrdersDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrdersDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of OrdersDAO object.
   */
  public static Orders[] showOrders() {
    List<Orders> order = dao().showFullOrdersList();
    return order.toArray(new Orders[order.size()]);
  }
  /**
   * Call the data base connection.
   * @return the array of OrdersDAO object.
   * @param cId all the customer id.
   */
  public static List<Orders> cusHistory(final int cId) {
    List<Orders> order = dao().showOrdersFromCId(cId);
    return order;
  }
  /**
   * @param vId to get vendor history.
   * @return the array of OrdersDAO object.
   */
  public static Orders[] venHistory(final int vId) {
    List<Orders> ord = dao().showOrdersFromVid(vId);
    return ord.toArray(new Orders[ord.size()]);
  }

  /**
   * @param vId to get vendor history.
   * @return the array of OrdersDAO object.
   */
  public static Orders[] venHistoryByOst(final int vId) {
    List<Orders> ord = dao().showOrdersFromOst(vId);
    return ord.toArray(new Orders[ord.size()]);
  }
  /**
   * @param cId to get the customer ID.
   * @param foodQty to get food quantity.
   * @param m menu details
   * @param ldm3 LocalDateTime.
   * @return String
   */
  public static String storeQty(final int cId, final int foodQty, final Menu m, final LocalDateTime ldm3) {
    float foodPrice = m.getFoodPrice();
    float oTotPrice = foodPrice * foodQty;

    DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    String ot3 = ldm3.format(dtf3);

    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
    String ot1 = ldm3.format(dtf1);

    Customers cust = dao().getWallet(cId);
    float cWallet = cust.getCWallet();
    if (oTotPrice <= cWallet) {
      int cor = dao().insertNewOrder(cId, m.getFoodId(), foodQty, "PLACE_ORDER", null, oTotPrice, ot1, ot1, ot3, m.getVenId());
      if (cor > 0) {
        System.out.println("-: Order Placed :- \n");
        System.out.println("Vendor Id : " + m.getVenId());
        System.out.println("Food Id : " + m.getFoodId());
        System.out.println("Food Name : " + m.getFoodName());
        System.out.println("Total Price : " + oTotPrice);
        System.out.println("Food Category : " + m.getFoodCategory());
        CustomersFactory.deductAmt(oTotPrice, cId);
        System.out.println("Order Placed");
        return "Order Placed";
      } else {
        System.out.println("Order Is Not Placed Due To Some Technical Issue");
        return "Order Is Not Placed Due To Some Technical Issue";
      }
    } else {
      System.out.println("Insufficient Wallet Amount");
      return "Insufficient Wallet Amount";
    }
  }
  /**
   * @param ost to get the order status.
   * @param oId to get the order ID.
   * @param reason to get the Order Reason.
   * @param vId to get the vendor ID.
   * @return String.
   */
  public static String updateOStatus(final String ost, final String reason, final int oId, final int vId) {
    int cor = dao().updateOStatus(ost, reason, oId, vId);
    if (cor > 0) {
      return "YOUR ORDER IS " + ost;
    } else {
      return "Nothing Updated";
    }
  }
  /**
   * @param oId to get the order ID.
   * @return String.
   */
  public static String walletAdd(final int oId) {
    Orders o = dao().getOrderByOId(oId);
    int cId = o.getCId();
    float oPrice = o.getOTotPrice();
    System.out.println("You cancelled an order \n Total Refund Amount : " + oPrice);
    Customers cust = dao().getWallet(cId);
    float cWallet = cust.getCWallet();
    dao().walletAdd(cWallet, oId);
    return "Successful";
  }
}

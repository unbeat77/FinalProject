package com.hexaware.FTP108.factory;

import com.hexaware.FTP108.persistence.VendorDAO;
import com.hexaware.FTP108.persistence.DbConnection;
import java.util.List;

import com.hexaware.FTP108.model.Orders;
import com.hexaware.FTP108.model.Vendor;

/**
 * VendorFactory class used to fetch vendor data from database.
 * @author hexware
 */
public class VendorFactory {
  /**
   * Protected constructor.
   */
  protected VendorFactory() {
  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static VendorDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(VendorDAO.class);
  }

  /**
   * Call the data base connection.
   * @return the array of vendor object.
   */
  public static Vendor[] showVendor() {
    List<Vendor> vendors = dao().showallVendorDetails();
    Vendor[] temp = {};
    if (vendors != null) {
      return vendors.toArray(new Vendor[vendors.size()]);
    }
    return temp;
  }

  /**
   * Call the data base connection.
   * @return the array of Customers object.
   * @param vId to get the vid.
  */
  public static Vendor[] showVendorById(final int vId) {
    List<Vendor> vendors = dao().showVendorDetailsById(vId);
    return vendors.toArray(new Vendor[vendors.size()]);
  }

  /**
   * @param vUsername all the vendor username verification.
   * @param vPassword all the vendor password verification.
   * @return the vendor object.
   */
  public static Vendor verifyVendor(final String vUsername, final String vPassword) {
    Vendor v = dao().validateVendor(vUsername, vPassword);
    if (v != null) {
      String un = v.getVUsername();
      String pass = v.getVPass();
      if (un.equals(vUsername) && pass.equals(vPassword)) {
        return v;
      } else {
        return null;
      }
    }
    return null;
  }

  /**
   * @param vId    all verification.
   * @param foodId all verification.
   * @return the no of orders by foodId.
   */
  public static int getVendorByFoodId(final int vId, final int foodId) {
    return dao().getNoOfOrdersByfoodId(vId, foodId).size();
  }
 /**
  * @param vId vendor id.
  * @param dt1 first date.
  * @param dt2 last date.
  * @return double value for gst.
  */
  public static double getGST(final int vId, final String dt1, final String dt2) {
    List<Orders> or = dao().getGST(vId, dt1, dt2);
    double mTotal = 0;
    double gst = 0;
    for (Orders o : or) {
      mTotal = mTotal + o.getOTotPrice();
      System.out.println("tot " + mTotal );
    }
    System.out.println("Total price of " + dt1 + " to " + dt2 + " is " + mTotal);
    gst = mTotal*5/100;
    System.out.println("The GST of " + dt1 + "to " + dt2 + " is " + gst);
    return gst;
  }
}

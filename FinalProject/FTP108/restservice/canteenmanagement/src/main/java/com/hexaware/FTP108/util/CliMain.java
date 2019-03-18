package com.hexaware.FTP108.util;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import com.hexaware.FTP108.model.Customers;
import com.hexaware.FTP108.model.Menu;
import com.hexaware.FTP108.model.Orders;
import com.hexaware.FTP108.model.Vendor;
import com.hexaware.FTP108.factory.CustomersFactory;
import com.hexaware.FTP108.factory.MenuFactory;
import com.hexaware.FTP108.factory.OrdersFactory;
import com.hexaware.FTP108.factory.VendorFactory;

/**
 * CliMain used as Client interface for java coading.
 * 
 * @author hexware
 */
class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  /**
   * mainMenu method used to display the option we had in the application.
   */
  private void mainMenu() {
    System.out.println("Canteen Management System");
    System.out.println("-----------------------");
    System.out.println("1. Show Menu");
    System.out.println("2. Show Vendor");
    System.out.println("3. Show Customer");
    System.out.println("4. Exit");
    System.out.println();
    mainMenuDetails();
  }

  /**
   * mainMenuDetails method process the option selected from main menu.
   */
  private void mainMenuDetails() {
    try {
      System.out.println("Enter your choice:");
      int menuOption = option.nextInt();
      switch (menuOption) {
      case 1:
        showFullMenuDetails();
        break;
      case 2:
        showVendorDash();
        break;
      case 3:
        showCustDash();
        break;
      case 4:
        Runtime.getRuntime().halt(0);
        break;
      default:
        System.out.println("Choose either 1 or 4");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    mainMenu();
  }

  private void showFullMenuDetails() {
    Menu[] menu = MenuFactory.showMenu();
    System.out.println("Fod_Id\tVendor_Id\tFood_Name\tCategory\tFood_Price\tDescription");
    for (Menu m : menu) {
      System.out.println(m.getFoodId() + "\t" + m.getVenId() + "\t\t" + m.getFoodName() + "\t" + m.getFoodCategory()
          + "\t\t" + m.getFoodPrice() + "\t" + m.getFoodDescription());
    }
  }

  private void showCustDash() {
    int cId = verifyCustomer();
    getCustChoice(cId);
  }

  /**
   * @param cId to get choice of customer.
   */
  public void getCustChoice(final int cId) {
    if (cId > 0) {
      System.out.println();
      System.out.println();
      System.out.println("Enter your choice.");
      System.out.println("press 1. for Displaying the Customer Order History");
      System.out.println("press 2. for Placing Order");
      System.out.println("press 3. for Wallet Info");
      System.out.println("press 4. To go back to Main Menu");
      int ch = option.nextInt();
      switch (ch) {
      case 1:
        showFullOrderHistory(cId);
        break;
      case 2:
        placeOrder(cId);
        break;
      case 3:
        showFullWallet(cId);
        break;
      case 4:
        mainMenu();
        break;
      default:
        System.out.println("!!!! Not a valid Input !!!!");
      }
      getCustChoice(cId);
    } else {
      showCustDash();
    }
  }

  /**
   * showFullMenu method display the menu item stored in database.
   */
  private void showVendorDash() {
    int vId = verifyVendor();
    getVendorsChoice(vId);
  }

  /**
   * @param vId to get vendors choice.
   */
  public void getVendorsChoice(final int vId) {
    if (vId > 0) {
      System.out.println("Enter your choice.");
      System.out.println("press 1. for displaying Vendor History");
      System.out.println("press 2. for Accept or Deny your Order");
      System.out.println("press 3. for get order for specific Food Id");
      System.out.println("press 4. GST");
      System.out.println("press 5. To go back to Main Menu");
      System.out.println();
      switch (option.nextInt()) {
      case 1:
        vendorHistory(vId);
        break;
      case 2:
        vendorAcceptDeny(vId);
        break;
      case 3:
        showVendorbyfoodId(vId);
        break;
      case 4:
        getGST(vId);
        break;
      case 5:
        mainMenu();
        break;
      default:
        System.out.println("!!!! Not a valid Input !!!!");
      }
      getVendorsChoice(vId);
    } else {
      showVendorDash();
    }
  }

  /**
   * @param vId for passing.
   */
  public void showVendorbyfoodId(final int vId) {
    System.out.println("Enter your Food Id : ");
    int foodId = option.nextInt();
    int noo = VendorFactory.getVendorByFoodId(vId, foodId);
    System.out.println("No. of orders by Food Id : " + foodId + " are " + noo);
  }

  /**
   * @return vId to verify vendor
   */
  public int verifyVendor() {
    System.out.println("Enter your User Name : ");
    String un = option.next();
    System.out.println("Enter your Password : ");
    String pass = option.next();
    Vendor v = VendorFactory.verifyVendor(un, pass);
    if (v != null) {
      System.out.println("Vendor details");
      System.out.println("V_ID\tV_NAME\t\tV_USERNAME\tV_PASS  \tV_EMAIL\t\tV_PHONE\tV_ADDRESS");
      System.out
          .println("_________________________________________________________________________________________________");
      System.out.println(v.getVId() + "\t" + v.getVName() + "\t" + v.getVUsername() + "\t\t" + v.getVPass() + "\t"
          + v.getVEmail() + "   " + v.getVPhone() + "   " + v.getVAddress());
      return v.getVId();
    }
    System.out.println("Invalid Vendor Username or Password.");
    return 0;
  }

  /**
   * @return vId to verify customer.
   */
  public int verifyCustomer() {
    System.out.println("Enter your User Name : ");
    String un = option.next();
    System.out.println("Enter your Password : ");
    String pass = option.next();
    Customers c = CustomersFactory.verifyCustomer(un, pass);
    if (c != null) {
      System.out.println("Customers Details");
      System.out.println("C_Id\t C_Name\t C_wallet\t C_Email\t C_Phone\tC_Address");
      System.out.println(c.getCId() + "\t " + c.getCName() + "\t" + c.getCWallet() + "\t\t" + c.getCEmail() + "\t\t"
          + c.getCPhone() + "\t" + c.getCAddress());

      return c.getCId();
    } else {
      System.out.println("Invalid Customer Username or Password!!!");
      return 0;
    }
  }

  /**
   * @param cId to place order. deduct wallet balance.
   */
  private void placeOrder(final int cId) {
    showFullMenuDetails();
    System.out.println("Enter food id : ");
    int foodId = option.nextInt();
    Menu m = MenuFactory.showMenuByFoodId(foodId);
    System.out.println("__________________________________________________________________________");
    if (m != null) {
      if (foodId == m.getFoodId()) {
        System.out
            .println(m.getFoodId() + "\t" + m.getFoodName() + "\t" + m.getFoodPrice() + "\t" + m.getFoodCategory());
        System.out.println("Enter quantity : ");
        int foodQty = option.nextInt();
        if (foodQty >= 1) {
          LocalDateTime ldm3 = LocalDateTime.now();
          OrdersFactory.storeQty(cId, foodQty, m, ldm3);
        } else {
          System.out.println("Quantity is not valid!!!");
          placeOrder(cId);
        }
      }
    } else {
      System.out.println("Oops, Food Id is wrong!!!\n Please Re Enter.");
      placeOrder(cId);
    }
  }

  /**
   * @param cId to display wallet details.
   */
  private void showFullWallet(final int cId) {
    Customers[] wal = CustomersFactory.showWallet(cId);
    System.out.println("Wallet Details\n");
    System.out.println("C_ID\t" + "C_NAME\t" + "C_Wallet");
    System.out.println("___________________________________________");
    for (Customers w : wal) {
      System.out.println(w.getCId() + "\t" + w.getCName() + "\t" + w.getCWallet());
    }
    System.out.println("___________________________________________");
    getCustChoice(cId);
  }

  private void showFullOrderHistory(final int cId) {
    List<Orders> order = OrdersFactory.cusHistory(cId);
    System.out.println("Order_Id\t" + "Customer_Id\t" + "Food_Id\t\t" + "Food Qty\t" + "Order_Status\t" + "Reason\t"
        + "Total Price\t" + "Order Time\t" + "Order Date\t\t\t" + "Vendor_Id\t");

    for (Orders o : order) {
      System.out.println(o.getOId() + "\t\t\t" + o.getCId() + "\t" + o.getFoodId() + "\t\t" + o.getFoodQty() + "\t\t"
          + o.getOStatus() + "\t" + o.getOReason() + "\t\t" + o.getOTotPrice() + "\t" + o.getOTime() + "\t"
          + o.getODate() + "\t" + o.getVId());
    }
  }

  /**
   * @param vId to display vendor history.
   * @return vendor history.
   */
  public Orders[] vendorHistory(final int vId) {
    Orders[] or = OrdersFactory.venHistory(vId);
    System.out
        .println("O_ID\tC_ID\tFOOD_ID\tFOOD_QTY\tO_STATUS\tO_REASON\tO_TOT_PRICE\tO_EST_TIME\tO_TIME\tO_DATE\tV_ID");
    System.out.println(
        "_______________________________________________________________________________________________________________");
    for (Orders o : or) {
      System.out.println(o.getOId() + "\t" + o.getCId() + "\t" + o.getFoodId() + "\t\t" + o.getFoodQty() + "\t"
          + o.getOStatus() + "\t" + o.getOReason() + "\t\t" + o.getOTotPrice() + "\t" + o.getOTime() + "\t"
          + o.getODate() + "\t" + o.getVId());
    }
    return or;
  }

  /**
   * @param vId to accept or deny the order.
   */
  public void vendorAcceptDeny(final int vId) {
    Orders[] obj = OrdersFactory.venHistoryByOst(vId);
    System.out
        .println("O_ID\tC_ID\tFOOD_ID\tFOOD_QTY\tO_STATUS\tO_REASON\tO_TOT_PRICE\tO_EST_TIME\tO_TIME\tO_DATE\tV_ID");
    System.out.println(
        "__________________________________________________________________________________________________________________________");

    for (Orders o : obj) {
      System.out.println(o.getOId() + "\t" + o.getCId() + "\t" + o.getFoodId() + "\t\t" + o.getFoodQty() + "\t"
          + o.getOStatus() + "\t" + o.getOReason() + "\t\t" + o.getOTotPrice() + "\t" + o.getOEstTime() + "  "
          + o.getOTime() + "  " + o.getODate() + "  " + o.getVId());
    }
    System.out.println("Enter Order_Id : ");
    int oId = option.nextInt();
    String temp = "";
    for (Orders var : obj) {
      if (var.getOId() == oId) {
        temp = "true";
      }
    }
    if (temp.equalsIgnoreCase("true")) {
      System.out.println("Accept/Deny : ");
      String ch = option.next();
      String ostatus = "";
      String reason = "";
      if (ch.equalsIgnoreCase("Accept")) {
        ostatus = "DELIVERED";
      } else if (ch.equalsIgnoreCase("deny")) {
        ostatus = "CANCELLED";
        System.out.println("Please Enter The Reason : ");
        option.nextLine();
        reason = option.nextLine();
        OrdersFactory.walletAdd(oId);
      } else {
        System.out.println("Not a valid choice Please Re-Enter.");
        vendorAcceptDeny(vId);
      }
      String res = OrdersFactory.updateOStatus(ostatus, reason, oId, vId);
      System.out.println(res);
    } else {
      System.out.println("Enter Valid Order Id!!!");
    }
  }

  /**
   * @param vId Vendor Id
   */
  public void getGST(final int vId) {
    System.out.println("Enter First date in format yyyy-mm-dd");
    option.nextLine();
    String dt1 = option.nextLine();
    System.out.println("Enter Last date in format yyyy-mm-dd");
    String dt2 = option.nextLine();
    VendorFactory.getGST(vId, dt1, dt2);
  }

  /**
   * @param args main method
   */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}

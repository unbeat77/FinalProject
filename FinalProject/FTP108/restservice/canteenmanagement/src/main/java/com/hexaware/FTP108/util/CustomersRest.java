package com.hexaware.FTP108.util;

import java.time.LocalDateTime;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP108.model.Customers;
import com.hexaware.FTP108.model.Orders;
import com.hexaware.FTP108.model.Menu;
import com.hexaware.FTP108.factory.CustomersFactory;
import com.hexaware.FTP108.factory.MenuFactory;
import com.hexaware.FTP108.factory.OrdersFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/customers")
public class CustomersRest {
  /**
   * Returns Menu details.
   * @return the menu details
   */
  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public final Customers[] listmenu() {
    final Customers[] cd = CustomersFactory.show();
    return cd;
  }

  /**
   * Returns Menu details.
   * @param cName for customer name.
   * @param cPassword for customer password.
   * @return the menu details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Customers cusLogin(@QueryParam("cName") final String cName, @QueryParam("cPassword") final String cPassword) {
    Customers cust = CustomersFactory.verifyCustomer(cName, cPassword);
    if (cust == null) {
      throw new NotFoundException("Invalid Customer name or password " + cName + " " + cPassword);
    }
    return cust;
  }
  /**
   * Returns Menu details.
   * @param cId for customer name.
   * @return the menu details
   */
  @GET
  @Path("/cushistory/{cid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final List<Orders> verifyCustomersById(@PathParam("cid") final int cId) {
    List<Orders> or = OrdersFactory.cusHistory(cId);
    return or;
  }
/**
 * @param cId to get the wallet details.
 * @return Customers array
 */
  @GET
  @Path("/wallet/{cId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Customers[] showCustWallet(@PathParam("cId") final int cId) {
    Customers[] cus = CustomersFactory.showWallet(cId);
    if (cus != null) {
      return cus;
    } else {
      throw new NotFoundException("Customer Id Not Found: " + cId);
    }
  }
  /**
 * @param cId to get the wallet details.
 * @return Customers array
 */
  @GET
  @Path("/custdetail/{cId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Customers[] showCustById(@PathParam("cId") final int cId) {
    Customers[] cus = CustomersFactory.showCustDetailsById(cId);
    if (cus != null) {
      return cus;
    } else {
      throw new NotFoundException("Customer Id Not Found: " + cId);
    }
  }
/**
 * @param ord for grting orders data.
 * @return required values.
 */
  @POST
  @Path("/placeorder")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Status placeOrders(final Orders ord) {
    Status st = new Status();
    String retval = "";
    int cId = ord.getCId();
    int foodId = ord.getFoodId();
    int foodQty = ord.getFoodQty();
    Customers[] cust = CustomersFactory.showWallet(cId);
    Menu m = MenuFactory.showMenuByFoodId(foodId);
    if (cust.length > 0) {
      if (m != null && foodId == m.getFoodId()) {
        if (foodQty > 0) {
          LocalDateTime ldm3 = LocalDateTime.now();
          retval = OrdersFactory.storeQty(cId, foodQty, m, ldm3);
          st.setMsg(retval);
        } else {
          st.setMsg("Invalid food Quantity");
        }
      } else {
        st.setMsg("Invalid food Id");
      }
    } else {
      st.setMsg("Invalid Customer Id");
    }
    return st;
  }
}

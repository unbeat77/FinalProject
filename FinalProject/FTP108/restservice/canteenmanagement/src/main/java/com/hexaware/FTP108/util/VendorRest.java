package com.hexaware.FTP108.util;
import javax.ws.rs.GET;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;
import javax.ws.rs.NotFoundException;
import com.hexaware.FTP108.factory.VendorFactory;
import com.hexaware.FTP108.model.Vendor;
import com.hexaware.FTP108.model.Orders;
import com.hexaware.FTP108.factory.OrdersFactory;

/**
 * class status.
 */
class Status {
  private String msg;
  /**
   * default constructor.
   */
  Status() {
  }
  /**
   * @return the vale of msg.
   */
  public final String getMsg() {
    return msg;
  }
  /**
   * @param argMsg to initialize msg.
   */
  public void setMsg(final String argMsg) {
    msg = argMsg;
  }
}

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/vendor")
public class VendorRest {
  /**
   * Returns vendor details.
   * @return the vendor details
   */
  @GET
  @Path("/all")
  @Produces(MediaType.APPLICATION_JSON)
  public final Vendor[] getAllVendorDetails() {
    Vendor[] v = VendorFactory.showVendor();
    return v;
  }
  /**
   * @param vUsername vendor name.
   * @param vPassword vendor password.
   * @return the vendor details after verifying.
   */

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Vendor verifyVendorByVid(@QueryParam("vUsername") final String vUsername, @QueryParam("vPassword") final String vPassword) {
    Vendor v2 = VendorFactory.verifyVendor(vUsername, vPassword);
    if (v2 == null) {
      throw new NotFoundException("not a valid username and password " + vUsername + " " + vPassword);
    }
    return v2;
  }
  /**
   * @param vId vendor name.
   * @return the vendor details after verifying.
   */
  @GET
  @Path("/{vid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Orders[] showVendorOrderHistory(@PathParam("vid") final int vId) {
    Orders[] or = OrdersFactory.venHistory(vId);
    return or;
  }
  /**
   * @param vId vendor name.
   * @return the vendor details after verifying.
   */
  @GET
  @Path("/vendetail/{vid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Vendor[] showVendorById(@PathParam("vid") final int vId) {
    Vendor[] ven = VendorFactory.showVendorById(vId);
    return ven;
  }
  /**
   * to get order details of a vendor where O_STATUS is PLACE_ORDER.
   * @param vId to pass to dao.
   * @return order details where O_STATUS is PLACE_ORDER
   */
  @GET
  @Path("/placedOrders/{vId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Orders[] getPlacedOrders(@PathParam("vId") final int vId) {
    Orders[] ord = OrdersFactory.venHistoryByOst(vId);
    return ord;
  }
  /**
   * to update the O_STATUS to DELIVERED or CANCELED.
   * @param argOrd to pass Orders as a reference variable.
   * @return no of rows returned.
   */
  @PUT
  @Path("/update")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final Status changeStatus(final Orders argOrd) {
    Status st = new Status();
    String ost = argOrd.getOStatus().toString();
    String oR = argOrd.getOReason();
    int oId = argOrd.getOId();
    int vId = argOrd.getVId();
    String ret = OrdersFactory.updateOStatus(ost, oR, oId, vId);
    if (ret.equals("YOUR ORDER IS DELIVERED")) {
      st.setMsg(ret);
    } else if (ret.equals("YOUR ORDER IS CANCELLED")) {
      OrdersFactory.walletAdd(oId);
      st.setMsg(ret);
    } else {
      st.setMsg(ret);
    }
    return  st;
  }
/**
 * 
 * @param vId Vendor Id.
 * @param dt1 First Date.
 * @param dt2 Last Date.
 * @return
 */
  @GET
  @Path("/gst/{vId}/{dt1}/{dt2}")
  @Produces(MediaType.APPLICATION_JSON)
  public final double getGST(@PathParam("vId") final int vId, @PathParam("dt1") String dt1, @PathParam("dt2") String dt2){
    double gst = VendorFactory.getGST(vId, dt1, dt2);
    return gst;
  }
}

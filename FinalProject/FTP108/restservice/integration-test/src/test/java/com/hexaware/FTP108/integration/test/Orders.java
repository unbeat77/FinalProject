package com.hexaware.FTP108.integration.test;
import java.util.Objects;
import java.util.Date;
import java.sql.Time;
/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Orders {
  private int oId;
  private int cId;
  private int foodId;
  private int foodQty;
  private String oReason;
  private float oTotPrice;
  private Time oEstTime;
  private Time oTime;
  private Date oDate;
  private int vId;
  private OStatus oStatus;
  /**
   * Default Constructor.
   */
  public Orders() {

  }
/**
* @param argOId to initialize order id. used to get details through constructor.
* @param argCId to initialize customer id. used to get details through constructor.
* @param argFoodId to initialize food id. used to get details through constructor.
* @param argFoodQty to initialize food quantity used to get details through constructor.
* @param argOReason to initialize reason to cancel used to get details through constructor.
* @param argOStatus to initialize order status used to get details through constructor.
* @param argOTotPrice to initialize total price of order used to get details through constructor.
* @param argOEstTime to initialize estimated time to deliver used to get details through constructor.
* @param argOTime to initialize order time used to get details through constructor.
* @param argODate to initialize order date used to get details through constructor.
* @param argVId to initialize vendor id used to get details through constructor.
*/
  public Orders(final int argOId, final int argCId, final int argFoodId,
        final int argFoodQty, final String argOReason,
        final OStatus argOStatus, final float argOTotPrice,
        final Time argOEstTime, final Time argOTime,
        final Date argODate, final int argVId) {
    this.oId = argOId;
    this.cId = argCId;
    this.foodId = argFoodId;
    this.foodQty = argFoodQty;
    this.oReason = argOReason;
    this.oTotPrice = argOTotPrice;
    this.oEstTime = argOEstTime;
    this.oTime = argOTime;
    this.oDate = new Date(argODate.getTime());
    this.vId = argVId;
    this.oStatus = argOStatus;
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Orders orders = (Orders) obj;
    if (Objects.equals(oId, orders.oId) && Objects.equals(cId, orders.cId)
        && Objects.equals(foodId, orders.foodId) && Objects.equals(foodQty, orders.foodQty)
        && Objects.equals(oReason, orders.oReason) && Objects.equals(oTotPrice, orders.oTotPrice)
        && Objects.equals(oEstTime, orders.oEstTime) && Objects.equals(oTime, orders.oTime)
        && Objects.equals(oDate, orders.oDate) && Objects.equals(vId, orders.vId)) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(oId, cId, foodId, foodQty, oReason, oTotPrice, oEstTime, oTime, oDate, vId);
  }

/**
 * @return String values for Orders.
 */
  public final String toString() {
    return this.getOId() + "  " + this.getCId() + "  " + this.getFoodId() + "  " + this.getFoodQty() + "  " + this.getOStatus() + "  "
        + this.getOReason() + "  " + this.getOTotPrice() + "  " + this.getOEstTime() + "  " + this.getOTime() + "  " + this.getODate() + "  " + this.getVId();
  }

/**
* @param argOId to initialize order id. used to get details through constructor.
*/
  public final void setOId(final int argOId) {
    this.oId = argOId;
  }
  /**
   * @param argCId to initialize customer id. used to get details through constructor.
   */
  public final void setCId(final int argCId) {
    this.cId = argCId;
  }
  /**
   * @param argFoodId to initialize food id. used to get details through constructor.
   */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
  /**
   * @param argFoodQty to initialize food quantity used to get details through constructor
   */
  public final void setFoodQty(final int argFoodQty) {
    this.foodQty = argFoodQty;
  }
  /**
   * @param argOReason to initialize reason to cancel used to get details through constructor
   */
  public final void setOReason(final String argOReason) {
    this.oReason = argOReason;
  }
  /**
   * @param argOTotPrice to initialize total price of order used to get details through constructor.
   */
  public final void setOTotPrice(final float argOTotPrice) {
    this.oTotPrice = argOTotPrice;
  }
  /**
   *@param argOEstTime to initialize estimated time to deliver used to get details through constructor.
   */
  public final void setOEstTime(final Time argOEstTime) {
    this.oEstTime = argOEstTime;
  }
  /**
   * @param argOTime to initialize order time used to get details through constructor.
   */
  public final void setOTime(final Time argOTime) {
    this.oTime = argOTime;
  }
  /**
   * @param argODate to initialize order date used to get details through constructor
   */
  public final void setODate(final Date argODate) {
    this.oDate = new Date(argODate.getTime());
  }
  /**
   * @return oId.
   */
  public final int getOId() {
    return this.oId;
  }
  /**
   * @return cId.
   */
  public final int getCId() {
    return this.cId;
  }
  /**
   * @return foodId.
   */
  public final int getFoodId() {
    return this.foodId;
  }
  /**
   * @return foodQty.
   */
  public final int getFoodQty() {
    return this.foodQty;
  }
  /**
   * @return oReason.
   */
  public final String getOReason() {
    return this.oReason;
  }
  /**
   * @return oTotPrice.
   */
  public final float getOTotPrice() {
    return this.oTotPrice;
  }
  /**
   * @return oEstTime.
   */
  public final Time getOEstTime() {
    return this.oEstTime;
  }
  /**
   * @return oTime.
   */
  public final Time getOTime() {
    return this.oTime;
  }
  /**
   * @return oDate.
   */
  public final Date getODate() {
    Date d1 = new Date(this.oDate.getTime());
    return d1;
  }
  /**
   * @return vId.
   */
  public final int getVId() {
    return this.vId;
  }
  /**
   * @param argVId to initialize vendor id used to get details through constructor.
   */
  public final void setVId(final int argVId) {
    this.vId = argVId;
  }
  /**
   * @return argOStatus.
   */
  public final OStatus getOStatus() {
    return this.oStatus;
  }
  /**
  @param argOStatus to initialize order status used to get details through constructor.
  */
  public final void setOStatus(final OStatus argOStatus) {
    this.oStatus = argOStatus;
  }
}

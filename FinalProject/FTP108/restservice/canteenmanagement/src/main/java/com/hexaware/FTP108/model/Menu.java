package com.hexaware.FTP108.model;
/*Menu Implementation*/
import java.util.Objects;
/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
  private int foodId;
  private int venId;
  private String foodName;
  private String foodCategory;
  private float foodPrice;
  private String foodDescription;
  /**
   * default constructor.
   */
  public Menu() {
  }
  /**
 * @param argFoodId to initialize foodid
 * @param argVId to initialize vendor id.
 * @param argFoodName to initialize  food name.
 * @param argFoodCategory to initialize food category.
 * @param argFoodPrice to initialize food price
 * @param argFoodDescription to initialize fooddescription.
 */
  public Menu(final int argFoodId, final int argVId, final String argFoodName,
      final String argFoodCategory, final float argFoodPrice, final String argFoodDescription) {
    foodId = argFoodId;
    venId = argVId;
    foodName = argFoodName;
    foodCategory = argFoodCategory;
    foodPrice = argFoodPrice;
    foodDescription = argFoodDescription;
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(venId, menu.venId) && Objects.equals(foodId, menu.foodId)
        && Objects.equals(foodCategory, menu.foodCategory) && Objects.equals(foodPrice, menu.foodPrice)
        && Objects.equals(foodDescription, menu.foodDescription)) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(venId, foodId, foodCategory, foodPrice, foodDescription);
  }
  /**
   * @return menu table.
   */
  public final String toString() {
    return this.getFoodId() + " " + this.getVenId() + " " + this.getFoodName() + " " + this.getFoodCategory()
      + " " + this.getFoodPrice() + " " + this.getFoodDescription();
  }
  /**
   * @return the foodId
   */
  public final int getFoodId() {
    return this.foodId;
  }
  /**
   * @param argFoodId the foodId to set.
   */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
  /**
   * @return the vId.
   */
  public final int getVenId() {
    return this.venId;
  }
  /**
   * @param argVId the vId to set
   */
  public final void setVenId(final int argVId) {
    this.venId = argVId;
  }
  /**
   * @return the foodName
   */
  public final String getFoodName() {
    return this.foodName;
  }
  /**
   * @param argFoodName the foodName to set
   */
  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }
  /**
   * @return the foodCategory
   */
  public final String getFoodCategory() {
    return this.foodCategory;
  }
  /**
   * @param argFoodCategory the foodCategory to set
   */
  public final void setFoodCategory(final String argFoodCategory) {
    this.foodCategory = argFoodCategory;
  }
  /**
   * @return the foodPrice
   */
  public final float getFoodPrice() {
    return this.foodPrice;
  }
  /**
   * @param argFoodPrice the foodPrice to set
   */
  public final void setFoodPrice(final float argFoodPrice) {
    this.foodPrice = argFoodPrice;
  }
  /**
   * @return the foodDescription
   */
  public final String getFoodDescription() {
    return this.foodDescription;
  }
  /**
   * @param argFoodDescription the foodDescription to set
   */
  public final void setFoodDescription(final String argFoodDescription) {
    this.foodDescription = argFoodDescription;
  }
}

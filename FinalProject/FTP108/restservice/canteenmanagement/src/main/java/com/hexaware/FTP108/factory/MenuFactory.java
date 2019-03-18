package com.hexaware.FTP108.factory;

import com.hexaware.FTP108.persistence.MenuDAO;
import com.hexaware.FTP108.persistence.DbConnection;
import java.util.List;
import com.hexaware.FTP108.model.Menu;
/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class MenuFactory {
  /**
   *  Protected constructor.
   */
  protected MenuFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Menu[] showMenu() {
    List<Menu> menu = dao().showMenuDetails();
    return menu.toArray(new Menu[menu.size()]);
  }
  /**
   * Call the data base connection.
   * @param foodId to get food ID.
   * @return the array of menu object.
   */
  public static Menu showMenuByFoodId(final int foodId) {
    Menu menu = dao().showMenuId(foodId);
    return menu;
  }
}

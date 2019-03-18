package com.hexaware.FTP108.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.FTP108.model.Menu;
import com.hexaware.FTP108.factory.MenuFactory;
/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/menu")
public class MenuRest {
  /**
   * Returns Menu details.
   * @return the menu details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Menu[] listmenu() {
    Menu[] m = MenuFactory.showMenu();
    return m;
  }
}

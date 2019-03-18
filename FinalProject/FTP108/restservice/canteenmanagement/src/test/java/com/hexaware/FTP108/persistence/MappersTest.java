package com.hexaware.FTP108.persistence;

import static org.junit.Assert.assertNotNull;

import com.hexaware.FTP108.factory.CustomersFactory;
import com.hexaware.FTP108.factory.MenuFactory;
import com.hexaware.FTP108.factory.OrdersFactory;
import com.hexaware.FTP108.factory.VendorFactory;
import com.hexaware.FTP108.model.Customers;
import com.hexaware.FTP108.model.Menu;
import com.hexaware.FTP108.model.Orders;
import com.hexaware.FTP108.model.Vendor;

import org.junit.Test;
/**
 * to test all the mapper class and there dao().
 */
public class MappersTest {
/**
   * to test the mappers and test the dao().
   */
  @Test
  public final void testMappersw() {
    Menu[] mn = MenuFactory.showMenu();
    assertNotNull(mn);
    Orders[] od = OrdersFactory.showOrders();
    assertNotNull(od);
    Vendor[] ven = VendorFactory.showVendor();
    assertNotNull(ven);
    Customers[] cus = CustomersFactory.show();
    assertNotNull(cus);
  }
}

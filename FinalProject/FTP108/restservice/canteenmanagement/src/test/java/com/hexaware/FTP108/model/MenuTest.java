package com.hexaware.FTP108.model;

//import com.hexaware.FTP108.persistence.MenuDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.Before;
//import org.junit.runner.RunWith;
//import mockit.Expectations;
//import mockit.MockUp;
//import mockit.Mocked;
//import mockit.Mock;
//import mockit.integration.junit4.JMockit;
//import java.util.ArrayList;

/**
 * Test class for Menu.
 */
public class MenuTest {
    /**
   * setup method.
   */
  @Before
  public final void initInput() {
    System.out.println("");
  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testAllArgConstructor() {
    Menu m1 = new Menu(1000, 3000, "samosa", "veg", 20.0f, "hot samosa");
    assertEquals(1000, m1.getFoodId());
    assertEquals(3000, m1.getVenId());
    assertEquals("samosa", m1.getFoodName());
    assertEquals("veg", m1.getFoodCategory());
    assertEquals(20.0f, (float) m1.getFoodPrice(), 0.001);
    assertEquals("hot samosa", m1.getFoodDescription());
  }

  /**
   * test setter methods.
   */
  @Test
  public final void testAllSetMethods() {
    Menu m1 = new Menu();
    Menu m2 = new Menu(1000, 3000, "samosa", "veg", 20.0f, "hot samosa");
    Menu m3 = new Menu();
    System.out.println(m2.toString());
    m2.setFoodName("samosa");
    m1.setFoodId(1000);
    m1.setVenId(3000);
    m1.setFoodName("samosa");
    m1.setFoodCategory("veg");
    m1.setFoodPrice(20.0f);
    m1.setFoodDescription("hot samosa");
    assertEquals(1000, m1.getFoodId());
    assertEquals(3000, m1.getVenId());
    assertEquals("samosa", m1.getFoodName());
    assertEquals("veg", m1.getFoodCategory());
    assertEquals(20.0f, (float) m1.getFoodPrice(), 0.001);
    assertEquals("hot samosa", m1.getFoodDescription());
    assertEquals(m1.getFoodDescription(), m2.getFoodDescription());
    assertEquals(true, m2.equals(m1));
    assertNotEquals(true, m2.equals(m3));
    assertNotEquals(true, m2.equals(null));
    assertEquals(m1.hashCode(), m2.hashCode());

    Date o1 = new Date();
    assertNotEquals(true, m1.equals(o1));
  }
}

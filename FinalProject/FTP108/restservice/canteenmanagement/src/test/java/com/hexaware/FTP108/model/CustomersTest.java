package com.hexaware.FTP108.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;


import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

//import mockit.Expectations;
//import mockit.MockUp;
//import mockit.Mocked;
//import mockit.Mock;
import mockit.integration.junit4.JMockit;
//import java.util.ArrayList;

/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class CustomersTest {
    /**
   * setup method.
   */
  @Before
  public final  void initInput() {
    System.out.println("tests");

  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testCustomers() {
    Customers c1 = null;
    assertNull(c1);

    Customers c = new Customers();
    assertNotNull("customer is not null", c);

    Customers c2 = new Customers();
    c2.setCId(2000);
    assertEquals(2000, c2.getCId());
    c2.setCName("geetha");
    assertEquals("geetha", c2.getCName());
    c2.setCWallet(2500);
    assertEquals(2500, c2.getCWallet(), 0.001);
    c2.setCPassword("abcd");
    assertEquals("abcd", c2.getCPassword());
    c2.setCEmail("sss@com");
    assertEquals("sss@com", c2.getCEmail());
    c2.setCPhone(989474491);
    assertEquals(989474491, c2.getCPhone());
    c2.setCAddress("Rathinapuri");
    assertEquals("Rathinapuri", c2.getCAddress());

  }
  /**
   * Tests the constructor of the customer class.
   */
  @Test
  public final void testAllArgConstructor() {
    Customers c = new Customers(2000, "geetha", 2500, "swe@123", "gfg@gg.c", 989415578, "rathinapuri");
    assertNotNull("customer not null", c);
    assertNotNull(c);
    System.out.println(c);
    assertEquals(2000, c.getCId());
    assertEquals("geetha", c.getCName());
    assertEquals(2500, c.getCWallet(), 0.001);
    assertEquals("swe@123", c.getCPassword());
    assertEquals("gfg@gg.c", c.getCEmail());
    assertEquals(989415578, c.getCPhone());
    assertEquals("rathinapuri", c.getCAddress());
  }
  /**
   * Tests the objects of the customer class.
   */
  @Test
  public final void testCustomerObjects() {
    Customers expected = new Customers(2000, "geetha", 2500, "swe@123", "gfg@gg.c", 989415578, "rathinapuri");
    Customers actual = new Customers(2000, "geetha", 2500, "swe@123", "gfg@gg.c", 989415578, "rathinapuri");
    assertEquals(expected, actual);

    Customers act2 = new Customers(3000, "roshini", 2500, "swe@123", "gfg@gg.c", 989415578, "rathinapuri");
    assertNotEquals(expected, act2);
  }
  /**
   * Tests the hashcode/equals of the customer class.
   */
  @Test
  public final void testCustomerHashCode() {
    Customers exp = new Customers(2000, "geetha", 2500, "swe@123", "gfg@gg.c", 989415578, "rathinapuri");
    Customers act = new Customers(2000, "geetha", 2500, "swe@123", "gfg@gg.c", 989415578, "rathinapuri");
    assertEquals(exp.hashCode(), act.hashCode());

    Customers act3 = new Customers(3000, "roshini", 2500, "swe@123", "gfg@gg.c", 989415578, "rathinapuri");
    assertNotEquals(exp.hashCode(), act3.hashCode());

    assertNotEquals(exp, null);
    ArrayList al = new ArrayList();
    assertFalse(exp.equals(al));
    Date d1 = new Date();
    assertEquals(false, exp.equals(d1));
    assertEquals(false, exp.equals(null));
  }
}
  /*/**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
 /* @Test
  public final void testListAllEmpty(@Mocked final MenuDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Menu>();
      }
    };
    new MockUp<Menu>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] me = Menu.showMenu();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  /*@Test
  public final void testListAllSome(@Mocked final MenuDAO dao) {
    final Menu m100 = new Menu(100);
    final Menu m101 = new Menu(101);
    final ArrayList<Menu> mn = new ArrayList<Menu>();
    new Expectations() {
      {
        mn.add(m100);
        mn.add(m101);
        dao.show(); result = mn;
      }
    };
    new MockUp<Menu>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Customers[] mn1 = Customers.showCustomers();
    assertEquals(2, mn1.length);
    assertEquals(new Menu(100).getFoodId(),
        mn1[0].getFoodId());
    assertEquals(new Menu(101).getFoodId(),
        mn1[1].getFoodId());*/



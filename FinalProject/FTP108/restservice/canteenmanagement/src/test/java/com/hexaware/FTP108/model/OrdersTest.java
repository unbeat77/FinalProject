package com.hexaware.FTP108.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import mockit.integration.junit4.JMockit;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class OrdersTest {
    /**
     * setup method.
     */

  @Test
    public final void testallargConstructor() {
    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/DD");
    sd.setLenient(false);
    Date ld = new java.sql.Date(new java.util.Date().getTime());
    Time ot = new Time(ld.getTime());
    Orders o = new Orders();
    Orders o1 = new Orders(5000, 2000, 4000, 3, "", OStatus.PLACE_ORDER, 150.0f, ot, ot, ld, 3000);
    Orders o2 = new Orders(5000, 2000, 4000, 3, "", OStatus.PLACE_ORDER, 150.0f, ot, ot, ld, 3000);
    System.out.println(o1);
    o1.setOId(5000);
    assertEquals(5000, o1.getOId());
    o1.setCId(2000);
    assertEquals(2000, o1.getCId());
    o1.setFoodId(4000);
    assertEquals(4000, o1.getFoodId());
    o1.setFoodQty(3);
    assertEquals(3, o1.getFoodQty());
    o1.setOReason("");
    assertEquals("", o1.getOReason());
    OStatus os = OStatus.PLACE_ORDER;
    o1.setOStatus(os);
    assertEquals(os, o1.getOStatus());
    o1.setOTotPrice(150);
    assertEquals(150, o1.getOTotPrice(), 0.01);
    o1.setOEstTime(ot);
    assertEquals(ot, o1.getOEstTime());
    o1.setOTime(ot);
    assertEquals(ot, o1.getOTime());
    o1.setODate(ld);
    assertEquals(ld, o1.getODate());
    o1.setVId(3000);
    assertEquals(3000, o1.getVId());
    assertEquals(o1, new Orders(5000, 2000, 4000, 3, "", OStatus.PLACE_ORDER, 150.0f, ot, ot, ld, 3000));
    assertNotNull(o);
    assertEquals(o1.hashCode(), o2.hashCode());
  }
    /**
     * Tests the equals/hashcode methods of the employee class.
     */
  @Test
    public final void testEqualsMethod() {
    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/DD");
    sd.setLenient(false);
    Date ld = new java.sql.Date(new java.util.Date().getTime());
    Time ot = new Time(ld.getTime());
    Orders o2 = new Orders(5000, 2000, 4000, 3, "", OStatus.PLACE_ORDER, 150.0f, ot, ot, ld, 3000);
    Orders o3 = new Orders(5000, 2000, 4000, 3, "", OStatus.PLACE_ORDER, 150.0f, ot, ot, ld, 3000);
    assertEquals(o2, o3);
    //assertEquals(o2.hashCode(), o3.hashCode());
    Orders o4 = new Orders(5001, 2000, 4000, 3, "", OStatus.PLACE_ORDER, 150.0f, ot, ot, ld, 3000);
    Orders o5 = new Orders(5000, 2000, 4000, 3, "", OStatus.PLACE_ORDER, 150.0f, ot, ot, ld, 3001);
    assertNotEquals(o4, o5);
    //assertNotEquals(o4.hashCode(), o5.hashCode());
    assertNotEquals(o3, null);
    //assertFalse(o4.equals(o5) && o5.equals(o4));
    ArrayList<Orders> a = new ArrayList<Orders>();
    assertFalse(o2.equals(a));
  }
}

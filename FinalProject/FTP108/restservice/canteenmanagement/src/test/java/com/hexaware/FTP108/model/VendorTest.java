package com.hexaware.FTP108.model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;

/**
 * Test class for Vendor.
 */

public class VendorTest {
  /**
   * setup method.
   */
  @Before
  public final void initInput() {
    System.out.println(" testing is done");
  }
  /**
  * Tests the equals/hashcode methods of the employee class.
  */
  @Test
  public final void testVendorHashcodeAndEquals() {
    System.out.println("checking the vendor hashcode and equals method");
    Vendor v3 = new Vendor(3500, "preethi", "diksha", "xyz", "sush@123", "987654321", "home@1234");
    Vendor v4 = new Vendor(3500, "preethi", "diksha", "xyz", "sush@123", "987654321", "home@1234");
    assertEquals(v3, v4);
    assertEquals(v3.hashCode(), v4.hashCode());
    Vendor v5 = new Vendor(3500, "preethi", "diksha", "xyz", "sush@123", "987654321", "home@1234");
    Vendor v6 = new Vendor(3500, "preethi", "darshana", "abc", "sush@123", "987654321", "home@1234");
    assertNotEquals(v5, v6);
    assertNotEquals(v5.hashCode(), v6.hashCode());
    System.out.println(v3);
    assertNotEquals(v3, null);
    ArrayList al = new ArrayList();
    assertFalse(v3.equals(al));
  }
  /**
   *Test the vendor object.
   */
  @Test
  public final void testVendorObject() {
    System.out.println(" checking the  vendor object ");
    Vendor expected = new Vendor(3500, "preethi", "diksha", "xyz", "sush@123", "987654321", "home@1234");
    Vendor actual = new Vendor(3500, "preethi", "diksha", "xyz", "sush@123", "987654321", "home@1234");
    assertEquals(expected, actual);
    Vendor exp = new Vendor(3500, "preethi", "diksha", "xyz", "sush@123", "987654321", "home@1234");
    Vendor act = new Vendor(3000, "preethi", "diksha", "xyz", "sush@123", "987654321", "house@1234");
    assertNotEquals(exp, act);
  }
  /**
   *Test the vendor setter and getter methods.
   */
  @Test
  public final void testVendorSetMethods() {
    Vendor v = new Vendor();
    assertNotNull("student is not null", v);
    assertNotNull(v);
    System.out.println("checking the setters and getters methods");

    Vendor v2 = new Vendor();
    v2.setVId(3100);
    assertEquals(3100, v2.getVId());
    v2.setVName("sweta");
    assertEquals("sweta", v2.getVName());
    v2.setVUsername("shallu");
    assertEquals("shallu", v2.getVUsername());
    v2.setVPass("1234");
    assertEquals("1234", v2.getVPass());
    v2.setvEmail("sush@123");
    assertEquals("sush@123", v2.getVEmail());
    v2.setVPhone("987654321");
    assertEquals("987654321", v2.getVPhone());
    v2.setVAddress("home@123");
    assertEquals("home@123", v2.getVAddress());
  }
  /**
   *Test the vendor constructor.
   */
  @Test
  public final void testAllargVendorConsctructor() {
    Vendor v1 = new Vendor(3000, "preethi", "diksha", "xyz", "sush@123", "987654321", "home@1234");
    assertNotNull("student is not null", v1);
    assertNotNull(v1);
    System.out.println("checking the constructor of the vendor class");
    assertEquals(3000, v1.getVId());
    assertEquals("preethi", v1.getVName());
    assertEquals("diksha", v1.getVUsername());
    assertEquals("xyz", v1.getVPass());
    assertEquals("sush@123", v1.getVEmail());
    assertEquals("987654321", v1.getVPhone());
    assertEquals("home@1234", v1.getVAddress());
  }
}

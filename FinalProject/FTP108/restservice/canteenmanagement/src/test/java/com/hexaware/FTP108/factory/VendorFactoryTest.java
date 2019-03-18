package com.hexaware.FTP108.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import com.hexaware.FTP108.persistence.VendorDAO;
import com.hexaware.FTP108.model.OStatus;
import com.hexaware.FTP108.model.Orders;
import com.hexaware.FTP108.model.Vendor;
import org.junit.Test;
import org.junit.Before;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Test class for vendorfactory.
 */
public class VendorFactoryTest {
  /**
   * setup method for vendor.
   */
  @Before
  public final void initInput() {
    System.out.println(" verification test is started ");
  }

  /**
   * Test class for Vendor login.
   * 
   * @param vdao help for testing.
   */
  @Test
  public final void testVendorLogin(@Mocked final VendorDAO vdao) {
    final Vendor v1 = new Vendor(3500, "preethi", "sush", "7795", "sush@123", "987654321", "home@1234");
    new Expectations() {
      {
        System.out.println(" comparing expected with actual ");
        vdao.validateVendor("sush", "7795");
        result = v1;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("verification of vendor");
        return vdao;
      }
    };
    Vendor ve = VendorFactory.verifyVendor("sush", "7795");
    assertEquals(v1, ve);
  }

  /**
   * method for show vendor list.
   * 
   * @param vdao help for testing.
   */
  @Test
  public final void testVendorById(@Mocked final VendorDAO vdao) {
    List<Vendor> arr = new ArrayList<Vendor>();
    final Vendor v1 = new Vendor(3500, "preethi", "sush", "7795", "sush@123", "987654321", "home@1234");
    arr.add(v1);
    new Expectations() {
      {
        System.out.println(" comparing expected with actual ");
        vdao.showVendorDetailsById(3500);
        result = v1;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("to show the full details of vendor");
        return vdao;
      }
    };
    Vendor[] ve = VendorFactory.showVendorById(3500);
    List<Vendor> act = new ArrayList<Vendor>();
    for (Vendor vn : ve) {
      act.add(vn);
    }
    assertEquals(arr, act);
  }

  /**
   * method for show vendor list.
   * 
   * @param vdao help for testing.
   */
  @Test
  public final void testShowVendor(@Mocked final VendorDAO vdao) {
    List<Vendor> arr = new ArrayList<Vendor>();
    final Vendor v1 = new Vendor(3500, "preethi", "sush", "7795", "sush@123", "987654321", "home@1234");
    arr.add(v1);
    new Expectations() {
      {
        System.out.println(" comparing expected with actual ");
        vdao.showallVendorDetails();
        result = v1;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("to show the full details of vendor");
        return vdao;
      }
    };
    Vendor[] ve = VendorFactory.showVendor();
    List<Vendor> act = new ArrayList<Vendor>();
    for (Vendor vn : ve) {
      act.add(vn);
    }
    assertEquals(arr, act);
  }

  /**
   * method for show vendor list.
   */
  @Test
  public final void testVendorConstructor() {
    VendorFactory venf = new VendorFactory();
    assertNotNull(venf);
  }

  /**
   * method for show vendor list.
   * 
   * @param vdao help for testing.
   */
  @Test
  public final void testLogin2(@Mocked final VendorDAO vdao) {
    List<Vendor> arr = new ArrayList<Vendor>();
    final Vendor v1 = new Vendor(3500, "preethi", "sush", "7795", "sush@123", "987654321", "home@1234");
    arr.add(v1);
    new Expectations() {
      {
        System.out.println(" comparing expected with actual ");
        vdao.validateVendor(null, null);
        result = v1;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("verification of vendor");
        return vdao;
      }
    };
    Vendor ve = VendorFactory.verifyVendor(null, null);
    assertNull(ve);
  }

  /**
   * method for show vendor list.
   * 
   * @param vdao help for testing.
   */
  @Test
  public final void testLoginNotNull(@Mocked final VendorDAO vdao) {
    List<Vendor> arr = new ArrayList<Vendor>();
    final Vendor v1 = null;
    arr.add(v1);
    new Expectations() {
      {
        System.out.println(" comparing expected with actual ");
        vdao.validateVendor(null, null);
        result = v1;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("verification of vendor");
        return vdao;
      }
    };
    Vendor ve = VendorFactory.verifyVendor(null, null);
    assertNull(ve);
  }

  /**
   * method for show vendor list.
   * 
   * @param vdao help for testing.
   */
  @Test
  public final void testLoginNull(@Mocked final VendorDAO vdao) {
    final Vendor[] arr = {};

    new Expectations() {
      {
        System.out.println(" comparing expected with actual ");
        vdao.showallVendorDetails();
        result = any;
      }
    };
    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("verification of vendor");
        return vdao;
      }
    };
    Vendor[] ve = VendorFactory.showVendor();
    assertEquals(ve, arr);
  }
/**
 * @param vdao to mock dao method.
 * @throws ParseException
 */
  @Test
  public final void testgetGST(@Mocked final VendorDAO vdao) throws ParseException {
    final List<Orders>
    ordSArr = new ArrayList<Orders>();
    double actual = 5;
    final int vId = 3001;
    final String dt1 = "2019-01-01";
    final String dt2 = "2019-03-01";
    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
    sd.setLenient(false);
    final Date dt = sd.parse("2019/02/19");
    final long df1 = new Date().getTime();
    final Time df = new Time(df1);
    final Orders or = new Orders(5001, 2001, 4001, 1, " ", OStatus.DELIVERED, 100, df, df, dt, 3001);
    ordSArr.add(or);

    new Expectations() {
      {
        System.out.println("mocked getGst");
        vdao.getGST(vId, dt1, dt2);
        result = ordSArr;
      }
    };

    new MockUp<VendorFactory>() {
      @Mock
      VendorDAO dao() {
        System.out.println("verification of vendor");
        return vdao;
      }
    };
    double expected = VendorFactory.getGST(vId, dt1, dt2);
    assertEquals(expected, actual, 5.0);
  }
}

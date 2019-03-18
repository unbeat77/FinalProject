package com.hexaware.FTP108.factory;

import static org.junit.Assert.assertEquals;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hexaware.FTP108.model.Customers;
import com.hexaware.FTP108.model.Menu;
import com.hexaware.FTP108.model.OStatus;
import com.hexaware.FTP108.model.Orders;
import com.hexaware.FTP108.persistence.OrdersDAO;

import org.junit.Test;

import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

/**
 * Testing OrderFactory.java file.
 */
public class OrdersFactoryTest {
/**
 * @param odao mocked from orderDAO.
 * @throws ParseException for DATE.
 */
  @Test
  public final void testCusHistory(@Mocked final OrdersDAO odao) throws ParseException {
    int expectedSize = 1;
    final List<Orders> custHisArr = new ArrayList<Orders>();
    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
    sd.setLenient(false);
    Date dt = sd.parse("2019/02/19");
    long df1 = new Date().getTime();
    Time df = new Time(df1);
    final Orders or = new Orders(5001, 2001, 4001, 1, " ", OStatus.PLACE_ORDER, 50, df, df, dt, 3001);
    custHisArr.add(or);
    new Expectations() { {
        System.out.println("mocked getAllCustomerHistory");
        odao.showOrdersFromCId(2001);
        result = custHisArr;
        } };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("mocked OrdersDao");
        return odao;
      }
    };
    List<Orders> actual = OrdersFactory.cusHistory(2001);
    assertEquals(expectedSize, actual.size());
  }
/**
 * @param odao mocked from orderDAO.
 * @throws ParseException for DATE.
 */
  @Test
  public final void testVenHistory(@Mocked final OrdersDAO odao) throws ParseException {
    int expectedSize = 1;
    final List<Orders> venHisArr = new ArrayList<Orders>();
    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
    sd.setLenient(false);
    Date dt = sd.parse("2019/02/19");
    long df1 = new Date().getTime();
    Time df = new Time(df1);
    final Orders or = new Orders(5001, 2001, 4001, 1, " ", OStatus.PLACE_ORDER, 50, df, df, dt, 3001);
    venHisArr.add(or);
    new Expectations() { {
        System.out.println("mocked getAllVendorHistory");
        odao.showOrdersFromVid(3001);
        result = venHisArr;
      } };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("mocked OrdersDao");
        return odao;
      }
    };
    Orders[] actual = OrdersFactory.venHistory(3001);
    assertEquals(expectedSize, actual.length);
  }
/**
 * @param odao mocked from orderDAO.
 * @throws ParseException for DATE.
 */
  @Test
  public final void testShowOrders(@Mocked final OrdersDAO odao) throws ParseException {
    int expectedSize = 1;
    final List<Orders> ordSArr = new ArrayList<Orders>();
    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
    sd.setLenient(false);
    Date dt = sd.parse("2019/02/19");
    long df1 = new Date().getTime();
    Time df = new Time(df1);
    final Orders or = new Orders(5001, 2001, 4001, 1, " ", OStatus.PLACE_ORDER, 50, df, df, dt, 3001);
    ordSArr.add(or);
    new Expectations() { {
        System.out.println("mocked getAllVendorsHistory");
        odao.showFullOrdersList();
        result = ordSArr;
      } };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("mocked OrdersDao");
        return odao;
      }
    };
    Orders[] actual = OrdersFactory.showOrders();
    assertEquals(expectedSize, actual.length);
  }
/**
 * @param odao mocked from orderDAO.
 * @throws ParseException for DATE.
 */
  @Test
  public final void testVenHistoryByOst(@Mocked final OrdersDAO odao) throws ParseException {
    int expectedSize = 1;
    final List<Orders> venHisArr = new ArrayList<Orders>();
    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
    sd.setLenient(false);
    final Date dt = sd.parse("2019/02/19");
    final long df1 = new Date().getTime();
    final Time df = new Time(df1);
    final Orders or = new Orders(5001, 2001, 4001, 1, " ", OStatus.PLACE_ORDER, 50, df, df, dt, 3001);
    venHisArr.add(or);
    new Expectations() { {
        System.out.println("mocked vendor history by order status");
        odao.showOrdersFromOst(3001);
        result = venHisArr;
      } };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("mocked OrdersDao");
        return odao;
      }
    };
    Orders[] actual = OrdersFactory.venHistoryByOst(3001);
    assertEquals(expectedSize, actual.length);
  }
/**
 * @param odao mocked from orderDAO.
 * @throws ParseException for DATE.
 * Order Placed.
 */
  @Test
  public final void testStoreQty(@Mocked final OrdersDAO odao) {
    String expected = "Order Placed";
    final Menu mnu = new Menu(4001, 3001, "ABC", "VEG", 20, "ABCDFE");
    final  LocalDateTime ldm3 = LocalDateTime.now();
    final Customers cus = new Customers(2001, "ABCDF", 2000, "pass", "xy@mail.com", 66566, "sdsfdfgsd");

    new Expectations() { {
        System.out.println("mocked vendor history by order status");

        odao.getWallet(2001);
        result = cus;
        DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String ot3 = ldm3.format(dtf3);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
        String ot1 = ldm3.format(dtf1);
        odao.insertNewOrder(2001, mnu.getFoodId(), 1, OStatus.PLACE_ORDER.toString(), null, 20, ot1, ot1, ot3, mnu.getVenId());
        result = 1;
      } };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("mocked OrdersDao");
        return odao;
      }
    };
    String actual = OrdersFactory.storeQty(2001, 1, mnu, ldm3);
    assertEquals(expected, actual);
  }

  /**
 * @param odao mocked from orderDAO.
 * @throws ParseException for DATE.
 * Order Placed.
 */
  @Test
  public final void testStoreQtyTech(@Mocked final OrdersDAO odao) throws ParseException {
    String expected = "Order Is Not Placed Due To Some Technical Issue";
    final Menu mnu = new Menu(4001, 3001, "ABC", "VEG", 20, "ABCDFE");
    final  LocalDateTime ldm3 = LocalDateTime.now();
    final Customers cus = new Customers(2001, "ABCDF", 2000, "pass", "xy@mail.com", 66566, "sdsfdfgsd");
    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
    sd.setLenient(false);
    new Expectations() { {
        System.out.println("mocked vendor history by order status");
        odao.getWallet(2001);
        result = cus;
      } };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("mocked OrdersDao");
        return odao;
      }
    };
    String actual = OrdersFactory.storeQty(2001, 1, mnu, ldm3);
    assertEquals(expected, actual);
  }

  /**
   * @param odao mocked from orderDAO.
   * @throws ParseException for DATE.
   */
  @Test
  public final void testStoreQtyWal(@Mocked final OrdersDAO odao) {
    String expected = "Insufficient Wallet Amount";
    final Menu mnu = new Menu(4001, 3001, "ABC", "VEG", 20, "ABCDFE");
    final  LocalDateTime ldm3 = LocalDateTime.now();
    final Customers cus = new Customers(2001, "Hell", 10, "pass", "xy@mail.com", 66566, "address");
    new Expectations() { {
        System.out.println("mocked vendor history by order status");
        odao.getWallet(2001);
        result = cus;
        } };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("mocked OrdersDao");
        return odao;
      }
    };
    String actual = OrdersFactory.storeQty(2001, 1, mnu, ldm3);
    assertEquals(expected, actual);
  }
/**
   * @param odao mocked from orderDAO.
   * @throws ParseException for DATE.
 */
  @Test
  public final void testUpdateOStatus(@Mocked final OrdersDAO odao) throws ParseException {
    final String ost = OStatus.DELIVERED.toString();
    final String expected = "YOUR ORDER IS " + ost;
    final String oR = " ";
    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
    sd.setLenient(false);
    final Date dt = sd.parse("2019/02/19");
    final long df1 = new Date().getTime();
    final Time df = new Time(df1);
    final Orders or = new Orders(5001, 2001, 4001, 1, " ", OStatus.PLACE_ORDER, 50, df, df, dt, 3001);
    new Expectations() { {
        odao.updateOStatus(ost, oR, or.getOId(), or.getVId());
        result = 1;
      } };
    new MockUp<OrdersFactory>() {
        @Mock
        OrdersDAO dao() {
          System.out.println("mocked OrdersDao");
          return odao;
      }
    };
    String actual = OrdersFactory.updateOStatus(ost, oR, or.getOId(), or.getVId());
    assertEquals(expected, actual);
  }
  /**
   * @param odao mocked from orderDAO.
   * @throws ParseException for DATE.
   */
  @Test
  public final void testWalletAdd(@Mocked final OrdersDAO odao) throws ParseException {
    String expected = "Successful";
    SimpleDateFormat sd = new SimpleDateFormat("yyyy/MM/dd");
    sd.setLenient(false);
    final Date dt = sd.parse("2019/02/19");
    new OrdersFactory();
    final long df1 = new Date().getTime();
    final Time df = new Time(df1);
    final Orders or = new Orders(5001, 2001, 4001, 1, " ", OStatus.PLACE_ORDER, 50, df, df, dt, 3001);
    final Customers cus = new Customers(2001, "Hell", 500, "pass", "xy@mail.com", 66566, "address");
    new Expectations() { {
        Orders o = odao.getOrderByOId(or.getOId());
        int cid = o.getCId();
        float oPrice = o.getOTotPrice();
        Customers c = odao.getWallet(cid);
        float cWallet = c.getCWallet();
        odao.walletAdd(cWallet, or.getOId());
        } };
    new MockUp<OrdersFactory>() {
      @Mock
      OrdersDAO dao() {
        System.out.println("mocked OrdersDao");
        return odao;
      }
    };

    String actual = OrdersFactory.walletAdd(or.getOId());
    assertEquals(expected, actual);
  }
}

package com.hexaware.FTP108.factory;

import com.hexaware.FTP108.model.Customers;
import com.hexaware.FTP108.model.Menu;
import com.hexaware.FTP108.persistence.CustomersDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;
/**
 * Test class for Customers.
 */
@RunWith(JMockit.class)
public class CustomersFactoryTest {
    /**
   * setup method.
   */
  @Before
  public final void initInput() {
    System.out.println("Tests");
  }
    /**
   * setup method.
   * @param cdao cdao.
   */
  @Test
  public final void testCustomerLogin(@Mocked  final CustomersDAO cdao) {
    final Customers ce = new Customers(2000, "lisi", 2500, "7520", "gfg@gg.c", 989415578, "rathinapuri");
    new Expectations() { {
        cdao.verifyCustomers("lisi", "7520");
        result = ce;
          }
        };
    new MockUp<CustomersFactory>() {
      @Mock
     CustomersDAO dao() {
        System.out.println("Customer login");
        return cdao;
      }
    };
    Customers cA = CustomersFactory.verifyCustomer("lisi", "7520");
    assertEquals(ce, cA);
  }
      /**
   * setup method.
   * @param cdao cdao.
   */
  @Test
  public final void testCustomerLogin1(@Mocked  final CustomersDAO cdao) {
    final Customers ce = new Customers(2000, "lisi", 2500, "7520", "gfg@gg.c", 989415578, "rathinapuri");
    new Expectations() { {
        cdao.verifyCustomers("li", "750");
        result = ce;
          }
        };
    new MockUp<CustomersFactory>() {
      @Mock
     CustomersDAO dao() {
        System.out.println("Customer login");
        return cdao;
      }
    };
    Customers cA = CustomersFactory.verifyCustomer("li", "750");
    assertNotEquals(ce, cA);
  }
      /**
   * setup method.
   * @param cdao cdao.
   */
  @Test
  public final void testCustomerLogin2(@Mocked  final CustomersDAO cdao) {
    final Customers ce = null;
    new Expectations() { {
        cdao.verifyCustomers(null, null);
        result = ce;
          }
        };
    new MockUp<CustomersFactory>() {
      @Mock
     CustomersDAO dao() {
        System.out.println("Customer login");
        return cdao;
      }
    };
    Customers cA = CustomersFactory.verifyCustomer(null, null);
    assertNull(cA);
  }
    /**
   * setup method.
   * @param cdao cdao.
   */
  @Test
  public final void testCustomerWalletDetails(@Mocked  final CustomersDAO cdao) {
    final List<Customers> ar  = new ArrayList<Customers>();
    final Customers ce = new Customers(2000, "lisi", 2500, "7520", "gfg@gg.c", 989415578, "rathinapuri");
    ar.add(ce);
    new  Expectations() { {
        System.out.println("Mocked getCustomers wallet details ");
        cdao.showWalletDetails(2000);
        result = ce;
      } };
    new MockUp<CustomersFactory>() {
        @Mock
        CustomersDAO dao() {
            System.out.println("Mocked dao");
            return cdao;
        }
    };
    Customers[] ca = CustomersFactory.showWallet(2000);
    List<Customers> cact = new ArrayList<Customers>();
    for (Customers c : ca) {
      cact.add(c);
    }
    assertEquals(ar, cact);
  }

    /**
   * setup method.
   * @param cdao cdao.
   */
  @Test
  public final void testCustomerWalletdeductDetails(@Mocked  final CustomersDAO cdao) {
    final int ar = 1;

    new  Expectations() { {
        System.out.println("Mocked getCustomers wallet details ");
        cdao.deductTotalAmt(2500, 2000);
        result = any;
      } };

    new MockUp<CustomersFactory>() {
      @Mock
    CustomersDAO dao() {
        System.out.println("Mocked dao");
        return cdao;
      } };
    int ca = CustomersFactory.deductAmt(2500, 2000);
    assertEquals(ar, ca);
  }
    /**
   * setup method.
   * @param cdao cdao.
   */
  @Test
  public final void testshowCustomers(@Mocked  final CustomersDAO cdao) {
    final List<Customers> ar  = new ArrayList<Customers>();
    final Customers ce = new Customers(2000, "lisi", 2500, "7520", "gfg@gg.c", 989415578, "rathinapuri");
    ar.add(ce);
    new  Expectations() { {
        System.out.println("Mocked getCustomers details ");
        cdao.showAllCustomersDetails();
        result = ce;
      } };
    new MockUp<CustomersFactory>() {
        @Mock
        CustomersDAO dao() {
            System.out.println("Mocked dao");
            return cdao;
        }
    };
    Customers[] ca = CustomersFactory.show();
    List<Customers> cact = new ArrayList<Customers>();
    for (Customers c : ca) {
      cact.add(c);
    }
    assertEquals(ar, cact);
  }
      /**
   * setup method.
   * @param cdao cdao.
   */
  @Test
  public final void testCustomersById(@Mocked  final CustomersDAO cdao) {
    final List<Customers> ar  = new ArrayList<Customers>();
    final Customers ce = new Customers(2000, "lisi", 2500, "7520", "gfg@gg.c", 989415578, "rathinapuri");
    ar.add(ce);
    new  Expectations() { {
        System.out.println("Mocked getCustomers details ");
        cdao.showCustById(2000);
        result = ce;
      } };
    new MockUp<CustomersFactory>() {
        @Mock
        CustomersDAO dao() {
            System.out.println("Mocked dao");
            return cdao;
        }
    };
    Customers[] ca = CustomersFactory.showCustDetailsById(2000);
    List<Customers> cact = new ArrayList<Customers>();
    for (Customers c : ca) {
      cact.add(c);
    }
    assertEquals(ar, cact);
  }
    /**
   * setup method.
   * @param cdao cdao.
   */
  @Test
 public final void cusPlaceOrder(@Mocked  final CustomersDAO cdao) {
    int expectedSize = 1;
    final List<Menu> ste = new ArrayList<Menu>();
    final Menu m = new Menu(1000, 2000, "dosa", "nonveg", 2500, "good");
    ste.add(m);
    new Expectations() { {
        System.out.println("mocked placeorder details");
        cdao.getFoodId(1000);
        result = ste;
      } };
    new MockUp<CustomersFactory>() {
        @Mock
        CustomersDAO dao() {
            System.out.println("mocked dao");
            return cdao;
        }
    };
    Menu[] sta = CustomersFactory.placeOrder(1000);
    assertEquals(expectedSize, sta.length);
  }
    /**
   * setup method.
   * @param cdao cdao.
   */
  @Test
 public final void cusPlaceOrderForNull(@Mocked  final CustomersDAO cdao) {
    final Menu[] m = {};
    new Expectations() { {
        System.out.println("mocked placeorder details");
        cdao.getFoodId(1000);
        result = m;
      } };
    new MockUp<CustomersFactory>() {
        @Mock
        CustomersDAO dao() {
            System.out.println("mocked dao");
            return cdao;
        }
    };
    Menu[] sta = CustomersFactory.placeOrder(1000);
    assertEquals(sta, m);
  }
    /**
   * setup method.
   */
  @Test
  public final void testCustomerConstructor() {
    CustomersFactory cusf = new CustomersFactory();
    assertNotNull(cusf);
  }
}

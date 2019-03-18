package com.hexaware.FTP108.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.util.ArrayList;
import java.util.List;
import com.hexaware.FTP108.model.Menu;
import com.hexaware.FTP108.persistence.MenuDAO;
import org.junit.Before;
import org.junit.Test;
import mockit.Expectations;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

/**
 * Test class for menu.
 */
public class MenuFactoryTest {
    /**
     * setup method.
     */
  @Before
  public void initInput() {

  }
/**
 * for testing of showMenuById.
 * @param mdao to get menu details.
 */
  @Test
  public final void testShowMenuById(@Mocked final MenuDAO mdao) {
    final Menu exp = new Menu(1000, 3000, "samosa", "veg", 20.0f, "hot samosa");
    new Expectations() {
      {
        System.out.println("Mocked menu");
        mdao.showMenuId(1000);
        result = exp;
      }
    };

    new MockUp<MenuFactory>() {
        @Mock
        MenuDAO dao() {
            System.out.println("Mocked dao for menu");
            return mdao;
        }
    };

    Menu menu = MenuFactory.showMenuByFoodId(1000);
    assertEquals(exp, menu);
  }
/**
 * test for constructor.
 */
  @Test
    public final void testConstructor() {
    final MenuFactory exp = new MenuFactory();
    assertNotEquals(exp, null);
  }
  /**
 * test for menu.
 * @param mdao mdao.
 */
  @Test
    public final void testShowMenu(@Mocked final MenuDAO mdao) {
    final List<Menu> exp = new ArrayList<Menu>();
    exp.add(new Menu(1000, 3000, "samosa", "veg", 20.0f, "hot samosa"));
    new Expectations() {
        {
          System.out.println("Mocked full menu");
          mdao.showMenuDetails();
          result = exp;
        }
    };

    new MockUp<MenuFactory>() {
          @Mock
            MenuDAO dao() {
            System.out.println("Mocked dao for full menu");
            return mdao;
        }
        };

    Menu[] lst = MenuFactory.showMenu();
    List<Menu> act = new ArrayList<Menu>();
    for (Menu m : lst) {
      act.add(m);
    }
    assertEquals(exp, act);
  }
}

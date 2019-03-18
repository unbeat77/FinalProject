package com.hexaware.FTP108.persistence;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP108.model.Menu;
/**
 * MenuDAO class used to fetch data from data base.
 * @author hexware
 */
public interface MenuDAO {
    /**
     * @return the all the Menu record.
     */
  @SqlQuery("SELECT * FROM MENU")
    @Mapper(MenuMapper.class)
    List<Menu> showMenuDetails();
    /**
     * @return all the menu record where FOODID=FID.
     * @param fId setting a food id to get a menu details
     */
  @SqlQuery("SELECT * FROM MENU WHERE FOOD_ID=:foodId")
    @Mapper(MenuMapper.class)
    Menu showMenuId(@Bind("foodId") int fId);
}

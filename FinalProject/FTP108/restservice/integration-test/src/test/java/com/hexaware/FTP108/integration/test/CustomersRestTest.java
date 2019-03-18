package com.hexaware.FTP108.integration.test;

import java.net.URISyntaxException;
import java.sql.Time;
import java.util.Date;
import static org.junit.Assert.*;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;

public class CustomersRestTest {

    public void testlistmenu() throws AssertionError, URISyntaxException {
        Customers[] res = given()
                .when()
                .accept(ContentType.JSON)
                .get(CommonUtil.getURI("/api/customers/all"))
                .getBody().as(Customers[].class);
        assertNotNull(res);
        assertEquals(1, res[0].getCId());
        assertEquals("JOHN", res[0].getCName());
        assertEquals("JOHN@GMAIL.COM", res[0].getCEmail());
        assertEquals("JOHN@123", res[0].getCPassword());
        assertEquals(432232, res[0].getCPhone());
        assertEquals("ASDSASDFS", res[0].getCAddress());
    }
@Test
    public void testverifyCustomersById() throws AssertionError, URISyntaxException {
        Time ot = new Time(11, 00, 00);
        Time et = new Time(15, 00, 00);
        Orders[] res = given()
                .when()
                .accept(ContentType.JSON)
                .get(CommonUtil.getURI("/api/customers/cushistory/1"))
                .getBody().as(Orders[].class);
        assertNotNull(res);
        assertEquals(1, res[0].getCId());
        assertEquals(1001, res[0].getFoodId());
        assertEquals(OStatus.DELIVERED, res[0].getOStatus());
        assertEquals(80, res[0].getOTotPrice(),80f);
        assertEquals(501, res[0].getVId());
        assertEquals(1, res[0].getFoodQty());
        assertEquals(ot, res[0].getOTime());
        assertEquals(et, res[0].getOEstTime());
    }

    @Test
    public void testshowCustWallet() throws AssertionError, URISyntaxException {
        Customers[] res = given()
                .when()
                .accept(ContentType.JSON)
                .get(CommonUtil.getURI("/api/customers/wallet/1"))
                .getBody().as(Customers[].class);
        assertNotNull(res);
        assertEquals(1, res[0].getCId());
        assertEquals("JOHN", res[0].getCName());
        assertEquals("JOHN@GMAIL.COM", res[0].getCEmail());
        assertEquals("JOHN@123", res[0].getCPassword());
        assertEquals(432232, res[0].getCPhone());
        assertEquals("ASDSASDFS", res[0].getCAddress());
    }

    @Test
    public void testcusLogin() throws AssertionError, URISyntaxException {
        Customers res = given()
                .when()
                .accept(ContentType.JSON)
                .get(CommonUtil.getURI("/api/customers?cName=JOHN&cPassword=JOHN@123"))
                .getBody().as(Customers.class);
        assertNotNull(res);
        assertEquals(1, res.getCId());
        assertEquals("JOHN", res.getCName());
        assertEquals("JOHN@GMAIL.COM", res.getCEmail());
        assertEquals("JOHN@123", res.getCPassword());
        assertEquals(432232, res.getCPhone());
        assertEquals("ASDSASDFS", res.getCAddress());
    }

    public void testPlaceOrder() throws AssertionError, URISyntaxException {
       Date dt = new Date("2019/02/22 12:32:00");
 
      Time et = new Time(15,00,00);
      Time ot = new Time(12,32,00);
      Orders ord = new Orders(6, 2, 1004, 2, "", OStatus.PLACE_ORDER, 450, et, ot, dt,504);
      String str = given()
                    .contentType("application/json")
                    .body(ord).when()
                    .post(CommonUtil.getURI("/api/customers/placeorder"))
                    .getBody().asString();
        System.out.println(str);
        String estr = "{\"msg\":\"Order Placed\"}";
        assertEquals(estr, str);
  }
}




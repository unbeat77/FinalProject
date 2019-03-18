package com.hexaware.FTP108.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class VendorRestTest {

  @Test
  public void testShowVendor() throws AssertionError, URISyntaxException {
    Vendor[] res = given()
                .when()
                .accept(ContentType.JSON)
                .get(CommonUtil.getURI("/api/vendor/all"))
                .getBody().as(Vendor[].class);
    assertNotNull(res);
    assertEquals(501, res[0].getVId());
    assertEquals("KFC", res[0].getVName());
    assertEquals( "Deepak", res[0].getVUsername());
    assertEquals("password", res[0].getVPass());
    assertEquals("deepak@kfc.com", res[0].getVEmail());
    assertEquals("123123123", res[0].getVPhone());
    assertEquals("#123, 4th street,5th phase BTM, Bangalore, Karnataka", res[0].getVAddress());
  }
  @Test
  public void testVendorListById() throws AssertionError, URISyntaxException {
    Vendor[] res = given()
                    .when()
                    .accept(ContentType.JSON)
                    .get(CommonUtil.getURI("/api/vendor/vendetail/501"))
                    .getBody().as(Vendor[].class);
    assertNotNull(res);
    assertEquals(501, res[0].getVId());
    assertEquals("KFC", res[0].getVName());
    assertEquals("Deepak", res[0].getVUsername());
    assertEquals("password", res[0].getVPass());
    assertEquals("deepak@kfc.com", res[0].getVEmail());
    assertEquals("123123123", res[0].getVPhone());
    assertEquals("#123, 4th street,5th phase BTM, Bangalore, Karnataka", res[0].getVAddress());
  }
  @Test
  public void testVendorLogin() throws AssertionError, URISyntaxException {
    Vendor res = given()
                    .when()
                    .accept(ContentType.JSON)
                    .get(CommonUtil.getURI("/api/vendor?vUsername=Deepak&vPassword=password"))
                    .getBody().as(Vendor.class);
    assertNotNull(res);
    assertEquals(501, res.getVId());
    assertEquals("KFC", res.getVName());
    assertEquals("Deepak", res.getVUsername());
    assertEquals("password", res.getVPass());
    assertEquals("deepak@kfc.com", res.getVEmail());
    assertEquals("123123123", res.getVPhone());
    assertEquals("#123, 4th street,5th phase BTM, Bangalore, Karnataka", res.getVAddress());
  }

  public void testVendorOrderHistory() throws AssertionError, URISyntaxException {
   Time ot = new Time(12,26,00);
   Time et = new Time(15,00,00);

  Orders[] res = given()
                    .when()
                    .accept(ContentType.JSON)
                    .get(CommonUtil.getURI("/api/vendor/502"))
                    .getBody().as(Orders[].class);
    assertNotNull(res);
    assertEquals(7, res[0].getOId());
    assertEquals(10, res[0].getCId());
    assertEquals(1002, res[0].getFoodId());
    assertEquals(10, res[0].getFoodQty());
    assertEquals("", res[0].getOReason());
    assertEquals(400, res[0].getOTotPrice(),400f);
    assertEquals(et, res[0].getOEstTime());
    assertEquals(ot, res[0].getOTime());
    assertEquals(502, res[0].getVId());
    assertEquals(OStatus.DELIVERED, res[0].getOStatus());
  }

  @Test
public void testVendorById404() throws AssertionError, URISyntaxException {
    given().accept(ContentType.JSON).when()
    .get(CommonUtil.getURI("/api/vendor/all/1010"))
    .then()
    .assertThat().statusCode(404);
  }

@Test
    public void testAcceptDeny() throws AssertionError, URISyntaxException {
       Date dt = new Date("2019/02/23 00:00:00");
 
      Time et = new Time(15,00,00);
      Time ot = new Time(12,26,00);
      Orders ord = new Orders(5, 4, 1004, 1, "", OStatus.DELIVERED, 150, et, ot, dt,504);
      String str = given()
                    .contentType("application/json")
                    .body(ord).when()
                    .put(CommonUtil.getURI("/api/vendor/update"))
                    .getBody().asString();
        System.out.println(str);
        String estr = "{\"msg\":\"Nothing Updated\"}";
        assertEquals(estr, str);
  }

  @Test
  public void testgetGst() throws AssertionError, URISyntaxException {
   String res = given()
                    .when()
                    .accept(ContentType.JSON)
                    .get(CommonUtil.getURI("/api/vendor/gst/501/2019-01-21/2019-10-01"))
                    .getBody().asString();
    assertNotNull(res);
  }
}

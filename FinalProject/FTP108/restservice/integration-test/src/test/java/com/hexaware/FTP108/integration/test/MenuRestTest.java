package com.hexaware.FTP108.integration.test;

import java.util.Arrays;
import java.util.Date;
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

public class MenuRestTest {

    @Test

    public void testMenuList() throws AssertionError, URISyntaxException {
        Menu[] res = given()
                .when()
                .accept(ContentType.JSON)
                .get(CommonUtil.getURI("/api/menu"))
                .getBody().as(Menu[].class);
        assertNotNull(res);
        assertEquals(1001, res[0].getFoodId());
        assertEquals(501, res[0].getVenId());
    }

}

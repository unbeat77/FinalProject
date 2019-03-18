package com.hexa;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import java.text.ParseException;

import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class StudentRestTest {
    @Test
    public void testStudentList() throws AssertionError, URISyntaxException {
        Student[] res = given().accept(ContentType.JSON).when().get(CommonUtil.getURI("/rest/student")).getBody()
                .as(Student[].class);

        Student expStd1 = new Student(51, "geetha");
        for (Student s : res) {
            System.out.println(s);
            if (s.getRegno() == expStd1.getRegno()) {
                assertEquals(s.getName(), expStd1.getName());
                assertEquals(s, expStd1);
            }
        }

    }

    @Test
    public void insertStudentTest() throws AssertionError, URISyntaxException {
        Student ns = new Student(520, "new Student");
        String str = given().contentType(ContentType.JSON).body(ns).when().post(CommonUtil.getURI("/rest/student/add"))
                .getBody().asString();
                System.out.println(str);
    }

}
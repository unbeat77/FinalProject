package com.hexa;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.Date;
import javax.management.RuntimeErrorException;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "StudentRestFul");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }

    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}

class Student{
    private int regno;
    private String name;
    Student() {
    }
    Student( int regno, String name) {
        this.name = name;
        this.regno = regno;
    }
    public String toString(){
        return regno +" "+name;
    }
    @Override
        public final int hashCode() {
            return Objects.hash(regno,name);
        }
    @Override
        public final boolean equals(final Object obj){
            if(obj==null){
                return false;
            }
            if (getClass()!= obj.getClass()){
                return false;
            }
        Student std = (Student) obj;
        if (Objects.equals(this.regno, std.regno) && Objects.equals(this.name, std.name)){
            return true;
        }
        return false;
    }//closed getName

    /**
     * @return the regno
     */
    public int getRegno() {
        return regno;
    }

    /**
     * @param regno the regno to set
     */
    public void setRegno(int regno) {
        this.regno = regno;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
} //class closed

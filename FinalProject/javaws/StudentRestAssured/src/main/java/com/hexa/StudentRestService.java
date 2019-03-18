package com.hexa;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

class Status{
    private String msg;
    Status(){

    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(final String st) {
        this.msg = st;
    }
}

@Path("/student")
public class StudentRestService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents() {
        StudentFactory sd  = new StudentFactory();
        List<Student> lsStd = sd.getStudentDetails();
        return lsStd;
    }
    @GET
    @Path("/{regNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudentgivenRegNo(@PathParam("regNo") int regNo) {
        StudentFactory sd = new StudentFactory();
        Student std = sd.getStudents(regNo);
        return std;
    }
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Status insertOneStudent(Student std) {
        Status st = new Status();

        System.out.println("insert reg : ");
        System.out.println(std);
        StudentFactory sd = new StudentFactory();
        String ret = sd.insertData(std.getRegno(), std.getName());

        st.setMsg(ret);

        System.out.println("values are: "+ st.getMsg());
        return st;
    }

    @PUT
    @Path("/modify/{regNo}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Status updateOneStudent(@PathParam("regNo") int regNo, Student std) {
        Status st = new Status();

        System.out.println("insert reg to update : ");
        System.out.println(std);
        StudentFactory sd = new StudentFactory();
        String ret = sd.upDateData(std.getRegno(), std.getName());

        st.setMsg(ret);

        System.out.println("values are: "+ st.getMsg());
        return st;
    }
}

/**
curl -vvv -i -H "Accept: application/json" -H "Content-Type: application/json" -X POST http://localhost:8080/StudentRestFul/rest/student/add -d '{"regNo":12, "name":"anand"}'
 */
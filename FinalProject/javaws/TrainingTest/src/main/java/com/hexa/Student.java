//Student.java


package com.hexa;
import java.util.Date;
import java.util.Objects;
public class Student{
   private int regNo;
   private String name;
   private Date dob;
   private int marks;
    void setRegNo(int argRegNo)
    {
        regNo=argRegNo;
    }
    int getRegno(){
        return regNo;
    }
    void setName(String argName){
        name=argName;
    }
    String getName(){
        return name;
    }
    public Student()
    {

    }
    public Student(int regNo,String name)
    {
        this.name=name;
        this.regNo=regNo;
    }

    @Override
    public final int hashCode(){
        return Objects.hash(regNo,name);
    }
    @Override
    public final boolean equals(final Object obj)
    {
        if(obj == null)
        {
            return false;
        }
        if(getClass() != obj.getClass())
            return false;
    
    Student std = (Student) obj ;

    if(Objects.equals(this.regNo,std.regNo) && Objects.equals(this.name,std.name))
    {
        return true;
    }
    return false;

}
public String toString(){
    String s = " regNo "+ regNo +" name "+ name  + "dob" + dob + "Marks" + marks;
    return s;
 }

    /**
     * @return the regNo
     */
    public int getRegNo() {
        return regNo;
    }

    public Date getDob() {
        return dob;
    }


    public void setDob(Date dob) {
        this.dob = dob;
    }


    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}

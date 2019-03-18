//Student.java


package com.hexa;
import java.util.Objects;
public class Student{
   private int regNo;
   private String name;
    public void setRegNo(int argRegNo)
    {
        this.regNo=argRegNo;
    }
    public int getRegno(){
        return this.regNo;
    }
    public void setName(String argName){
        this.name=argName;
    }
    public String getName(){
        return this.name;
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
    String s = " regNo "+ regNo +" name "+ name ;
    return s;
 }
}

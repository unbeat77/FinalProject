package com.hexa;

import java.util.Objects;
public class Student{
    private int regNo;
    private String name;
    Student() {
    }
    Student( int regNo, String name) {
        this.name = name;
        this.regNo = regNo;
    }
    public String toString(){
        return regNo +" "+name;
    }
    void setRegNo(int argRegNo) {
        regNo = argRegNo;
    } //closed setRegNo
    int getRegNo() {
        return regNo;
    } //closed getRegNo
    void setName(String argName) {
        name = argName;
    }//closed setName
    String getName() {
        return name;
    }
    @Override
        public final int hashCode() {
            return Objects.hash(regNo,name);
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
        if (Objects.equals(this.regNo, std.regNo) && Objects.equals(this.name, std.name)){
            return true;
        }
        return false;
    }//closed getName
} //class closed

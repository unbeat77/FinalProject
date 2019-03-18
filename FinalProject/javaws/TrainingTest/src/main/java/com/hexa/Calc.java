package com.hexa;

public class Calc{

    String name;
    public int add(int a, int b){
        System.out.println("Add");
        return (a+b);

    }

    public int mul(int a, int b){
        System.out.println("Mul");
        return (a*b);

    }
    public void setName(String nm){
        System.out.println("name is added");
        name = nm;
    }

    public boolean isNameAvailable(){

        if (name != null && name.length() > 0)
            return true;

        return false;
    }
}
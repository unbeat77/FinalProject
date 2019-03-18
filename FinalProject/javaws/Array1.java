import java.util.*;

public class Array1 {
  public static void main(String[] args) { 
    ArrayList<Integer> brands = new ArrayList<Integer>();
    brands.add(1);
    brands.add(2);
    brands.add(3);
    brands.add(4);
    System.out.println(brands.toString());
    for(int s:brands){
        System.out.println(s);
    }
  }
}
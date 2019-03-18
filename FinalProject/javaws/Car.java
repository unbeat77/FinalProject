

//eg. construtor

public class Car{
    private String brandName;
    private int mileage;
    private int price;

    Car(){
        this.brandName = "Wagon";
    

    }
    Car(String brandName) {
        this.brandName = brandName;
    }

    Car(String brandName, int price){
        this.brandName = brandName;
        this.price = price;
    }

    Car(String brandName, int price, int mileage){
        this.brandName = brandName;
        this.price = price;
        this.mileage = mileage;
    }
    
    

    void displayCarDetails(){
        System.out.print("Car brand\t"+brandName);
        System.out.print("\nMileage\t\t"+mileage);
        System.out.print("\nPrice\t\t"+price);
        System.out.println("\n------------------------------------------------");
        System.out.println("\n");

    }
    public static void main(String[] agrs){
       /* Car c= new Car();
        c.displayCarDetails();

        Car c1 = new Car("Honda", 10);
        c1.displayCarDetails();

        Car c2 = new Car("Hummer", 25, 3);
        c2.displayCarDetails();*/

        //Array
        int [] arrint = new int [5];
        for (int k=0;k<5;k++)
            arrint[k] = 1+k*100;

        for (int k=0;k<5;k++)
            System.out.print(arrint[k]);

        Car[] carArray = new Car[5];
        carArray[0] = new Car();
        carArray[1] = new Car("Innova");
        carArray[2] = new Car("Scorpio", 40000);
        carArray[3] = new Car("Qualis", 3000, 30);
        carArray[4] = new Car("Lamborgini",9999,4);
        System.out.print("cars\n");
        for (Car c : carArray)  //enhance loop;
            c.displayCarDetails();

    }//closed main

} //close class
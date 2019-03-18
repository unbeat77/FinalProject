public class Animal{
    private String name;

    public String getName(){ return name;}
    public void setName(String name){ this.name = name;}
    Animal(String name){
        this.name = name;
        }
    Animal(){
        this.setName("Alien");
        System.out.println("Animal - No args is called: " + this.getName());
    }

    public void sleep(){
        System.out.println("Animals sleep");
    }
    public void run(){
        System.out.println("Animals run in medium speed");
    }  
    public void eat(String foodName) {
        System.out.println(name + "eats "+ foodName );
    }
}
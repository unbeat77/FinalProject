public class Girafee extends Animal{
    String animalType;

    Girafee(String animalType){
        super();
        this.animalType=animalType;
        System.out.println("Girafee-assigning only animal type");
    }
    Girafee(){
        super("Alien");
        System.out.print("Girafee- no agrs");
    }

@Override
    public void run(){
        System.out.print("Girafee runs faster");
    }

    public void GirafeeSpFn(){
        System.out.print("Girafee spl fn");
    }
@Override
public void sleep(){
    System.out.print("Sleep");
}
    
}
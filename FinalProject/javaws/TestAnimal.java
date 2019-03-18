public class TestAnimal{

    public static void main(String[] args) {
        Girafee g1 = new Girafee("wildAnimal");
        g1.setName("browine");
        System.out.println(g1.getName());

        Animal an = new Animal("aaa");
        an.setName("cat");
        System.out.print(an.getName());

        Animal agf = new Girafee("Kill");
        agf.setName("Hell");
        agf.sleep();

        Girafee g2 = (Girafee) agf;
        System.out.print(g2.animalType);
    }
}
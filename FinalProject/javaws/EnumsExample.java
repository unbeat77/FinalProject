enum Directions{
    NORTH, SOUTH, EAST, WEST
}

public class EnumsExample{
    public static void main (String[] agrs){
        Directions d1 = Directions.EAST;
        System.out.print(d1 + "\t");
        Directions d2 = Directions.NORTH;
        System.out.print(d2+"\t");
        Directions d3 = Directions.WEST;
        System.out.print(d3+"\t");
        Directions d4 = Directions.SOUTH;
        System.out.print(d4+"\n");

        Directions d5 = Directions.EAST;
        System.out.print("name \t" + d5.name()+"\n");
        System.out.print("orignal\t" + d5.ordinal()+"\n");
        System.out.print("value \t" + Directions.valueOf("SOUTH")+"\n");
        
    }
}
public class TestStudent{

    public static void main(String[] agrs) {
        /*
        Student st, st1, stSame;
        st = new Student();
        st.setName("Abhinav");
        st.setRegNo(150);
        
        System.out.print("Student:\t"+st.getName()+"\t"+st.getRegNo()+"\n");
        
        st1= new Student();
        st1.setName("Abhi");
        st1.setRegNo(151);
        System.out.print("Student:\t"+st1.getName()+"\t"+st1.getRegNo()+"\n");

        stSame = new Student("A", 10);
        
        System.out.print("Student:\t"+stSame.getName()+"\t"+stSame.getRegNo());*/

        Student s1, s2;
        s1=new Student();
        s2=new Student();

        s1.setName("Abhi");
        s1.setRegNo(151);

        s2.setName("Abhi");
        s2.setRegNo(151);

        if (s1==s2){
            System.out.println("equal");
        }
        else System.out.println("not equal");

        boolean k=s1.equals(s2);

        System.out.print("k is "+k +"\n");
        if(k){
            System.out.print("same using equals\n");
        }
        else System.out.print("not equals");

    }//closed main
}//closed class
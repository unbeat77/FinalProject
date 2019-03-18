class Sample{
    public static void main(String[] args) {
        
    }

abstract class Test{
    abstract String He(){

    }
        public String toString(){
        return "hello";
        }
    }

class Test2 extends Test{
        public String toString(){
        return "hel";
        }
        String He(){
            System.out.println("hello1");
        }
}
}


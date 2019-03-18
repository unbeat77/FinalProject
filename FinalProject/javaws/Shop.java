import java.util.*;

class Shop{
    public static void main(String [] agrs) {
        System.out.print("S.no\t"+ "Product\t"+"Price\n");
        System.out.print("1\t"+ "A\t"+"22.50\n");
        System.out.print("2\t"+ "B\t"+"44.50\n");
        System.out.print("3\t"+ "C\t"+"9.98\n");

        Scanner sc = new Scanner(System.in);
        int choice=0;
        float tot_price = 0, c_wal;
        int qty=0, check=1;
        boolean ch = true;
        String c_name = " ";
        System.out.print("Hello Enter Customer Name\n");
        
        c_name = sc.nextLine();
        System.out.print("Please enter the money in hand: Mr. "+ c_name+"\n");
        c_wal = sc.nextInt();
        System.out.print("Hello"+ c_name+"\n Your wallet has: "+ c_wal+"\n");

        while(ch){
        System.out.println("\nEnter Product No.: ");
        choice = sc.nextInt();
        switch(choice){
                case 1:
                System.out.print("Opted for Product A ");
                System.out.print("Quantity: ");
                qty = sc.nextInt();
                tot_price += 22.50*qty;
                System.out.print("Opted price: "+ 22.50*qty+ "\n");
                System.out.print("Total Price: "+tot_price);
                break;

                case 2:
                System.out.print("Opted for Product B ");
                System.out.print("Quantity: ");
                qty = sc.nextInt();
                tot_price += 44.50*qty;
                System.out.print("Opted price: "+ 44.50*qty+"\n");
                System.out.print("Total Price: "+tot_price);
                break;

                case 3:
                System.out.print("Opted for Product A ");
                System.out.print("Quantity: ");
                qty = sc.nextInt();
                System.out.print("Opted price: "+ 9.98*qty+"\n");
                tot_price += 9.98*qty;
                System.out.print("Total Price "+tot_price);
                break;

                
            }
            System.out.print("\nTo continue shopping press 1 else press 0\n");
            check = sc.nextInt();
            

        if(check == 1)
            ch=true;
        else{
            ch=false;
            if(c_wal>= tot_price){
                float c_bal = c_wal-tot_price;
                System.out.print("Happy Shopping\n" + "Balance left in your wallet is: "+ c_bal);
            }
            else
            System.out.print("\nInsufficent Balance");
        }
            

        }
        System.out.print("\nBilling Amount: "+tot_price);
        sc.close();
    }
}
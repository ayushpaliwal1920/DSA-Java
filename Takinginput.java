import java.util.Scanner;

public class Takinginput {
    @SuppressWarnings("resource")
    public static void main(String[] args) {

   Scanner Sc = new Scanner(System.in);
   System.out.println("enter number");

   int num1 = Sc.nextInt();
   System.out.println("your number"+ num1);



    System.out.println("enter name");
    String name = Sc.next();
    System.out.println("name is "+ name);


    System.out.println("enter a sentence");
    String st = Sc.nextLine();
    System.out.println("sentence"+ st);
    }
}

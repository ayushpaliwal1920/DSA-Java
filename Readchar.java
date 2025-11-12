import java.util.Scanner;

public class Readchar {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in)  ; 
      System.out.println("enter a word");
      char ch0 = Sc.next().charAt(0);
      System.out.println("character at 0th index ="+ch0);
    
    }
}

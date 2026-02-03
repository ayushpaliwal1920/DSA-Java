package Strings;
import java.util.Scanner;

public class StringIntchar_02 {

    // String + int /char/String => concating using + operator 
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = "Abc";

        str  = str + "def";

        str = str + 'r';

        str = str + 10;

        System.out.println(str);

        System.out.println("Abc" +"xyz" +"r" + 10 + 20); // Abcxyzr1020
        System.out.println("Abc" +"xyz" +"r" + (10 + 20)); // Abcxyzr30        
    }
}

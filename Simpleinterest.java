
import java.util.Scanner;
public class Simpleinterest {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
    Scanner Sc = new Scanner(System.in);

    System.out.println("enter principle");
    float p = Sc.nextFloat();

    System.out.println("enter rate");
    float r = Sc.nextFloat();

    System.out.println("enter time ");
    float t = Sc.nextFloat();

    float si = (p*r*t)/100;

    System.out.println("simple interest ="+si);

    

    }
}

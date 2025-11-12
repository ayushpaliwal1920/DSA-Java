import java.util.Scanner;

class Algebra {
    float sumOfTwo(float a, float b){
        float sum = a + b ;
        return sum ;
    }
}
public class SumUsingmethod {
  @SuppressWarnings("resource")
public static void main(String[] args) {
    Algebra obj = new Algebra();
    Scanner Sc = new Scanner(System.in);
    float x = Sc.nextFloat();
    float y = Sc.nextFloat();

    System.out.println("sum of input numbers is ");
    float ans = obj.sumOfTwo(x, y);
    System.out.println(ans);
  }
}
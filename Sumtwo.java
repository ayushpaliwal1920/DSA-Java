import java.util.Scanner;

public class Sumtwo {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

System.out.println("Enter first number");
int num1 = Sc.nextInt();
System.out.println("Entered first number ="+ num1);

System.out.println("Enter second number");
int num2 = Sc.nextInt();
System.out.println("Entered sec number ="+ num2);

int sum = num1+num2;

System.out.println("sum ="+ sum);
    }
}

import java.util.Scanner;
public class Problemsonloop {
    @SuppressWarnings({ "resource" })
    public static void main(String[] args) {
        
        Scanner Sc = new Scanner(System.in);

        // count the number of digits for given number

       System.out.println("enter number");
       int num1 = Sc.nextInt();
       int numOfDigits = 0;

       while(num1 > 0){
        num1 = num1/10;
        numOfDigits++;
       }
       System.out.println("numberOFDigits in " + num1 + " is " + numOfDigits);

      // fijnd the sum of digits in a given number n
    System.out.println("enter num and get sum of digits of num");
     int n = Sc.nextInt();
     int sum = 0;
     int r;
     while(n > 0){

        r = n%10;
        n = n/10 ;
        
        sum = sum + r;
        }
     System.out.println("sum =" + sum);
     
    //  reverse of a number
    
    System.out.println("Enter number you want to reverse?");
    int rev = 0;
    int v = Sc.nextInt();
    while(v > 0){
      rev = rev*10 + v%10 ;
      v = v/10 ;
    }
    System.out.println("reverse "+ rev);

// print sesrie 1-2+3-4...

   System.out.println("enter number at which we want the sum of series .");
   int num2 = Sc.nextInt();
   int ans = 0;

   for(int i = 1 ;i <= num2 ; i++){
   if( i % 2 != 0 ){
    System.out.print("+"+i);
    ans+= i ;
   }else{
    System.out.print("-" + i);
    ans-= i;
   }
   }

   System.out.println("=" + ans);

// print factorial 

double fact = 1;
System.out.println("enter number whom we want to find factorial");
int num3 = Sc.nextInt();
for( int i=1 ; i<= num3 ; i++){
 fact = fact*i;
 System.out.println("factorial of " + i + ":" + fact);
}
  

// find a raise to the power b 

System.out.println("Enter a ");
int a = Sc.nextInt();
System.out.println("Enter b");
int b = Sc.nextInt();
int raise = 1;
for( int i = 1 ; i<= b ; i++){
  raise = raise * a ;

}
System.out.println("a raise to power b is = " + raise);
}
    }

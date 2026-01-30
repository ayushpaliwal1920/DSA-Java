import java.util.Scanner;
public class Loop {
    @SuppressWarnings({ "resource" })
    public static void main(String[] args) {
        
        Scanner Sc = new Scanner(System.in);

        //   while loop 

        System.out.println("print num ");
        int num = Sc.nextInt();
        int sum = 0;
        int i=1;
        while( i <= num){

            sum = sum + i;
            System.out.print("+"+i);
            i++;
}

System.out.print("="+sum);
System.out.println("\n");


// for loop

System.out.println("print x = ");
int x = Sc.nextInt();
int sum1 = 0;
for(int j=0 ; j<=x ; j++ ){
    sum1 = sum1 + j;
    System.out.print("+"+j);
    
}
System.out.println("="+sum1);


// do while loop = 

System.out.println("print y =");
int y = Sc.nextInt();

System.out.println("now this is the series from y to x");
do{
    System.out.println(y);
    y++;
}while(y<=x);


// example = print sum of the stream of integers in the input

System.out.println("the new thing is");

int num2 = Sc.nextInt();
int sum2 = 0;
while ( num2 != -1) {
    
    sum2 = sum2+num2;
    num2 = Sc.nextInt();
}
System.out.println("sum is ="+sum2);

    }
}

import java.util.Scanner;
public class Conditionals {
    @SuppressWarnings({ "resource" })
    public static void main(String[] args){

    Scanner Sc = new Scanner(System.in);

    System.out.println("enter number");
    int num = Sc.nextInt();

    if( num % 2 == 0 ){
        System.out.println("number is even");
    }
    else{
        System.out.println("number is odd");
    }

    // if else if 
   
    System.out.println("enter age");
    int age = Sc.nextInt();
 
    if(age <= 12){
        System.out.println("child");
        }
    else if(age>12 && age <= 18){
        System.out.println("teen");
    }
    else{
        
        System.out.println("adult");
    }

    // switch cases
    
    System.out.println("enter day number");
    int day= Sc.nextInt();

    switch (day) {
        case 1:
            System.out.println("monday");
            break;
        case 2:
            System.out.println("tuesday");
            break;
        case 3:
            System.out.println("wednusday");
            break;
        case 4:
            System.out.println("thursday");
            break;
        case 5:
            System.out.println("friday");
            break;
        case 6:
            System.out.println("saturday");
            break;
    
        default:
        System.out.println("invalid day number");
            break;
    }

    }
}

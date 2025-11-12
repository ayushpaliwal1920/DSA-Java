import java.util.Scanner;

public class Operator {
    @SuppressWarnings({ "resource", "unused" })
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in)  ; 
     
        /*  
         operators = 
         1. arithmetic = *,-,/,*,%,++,--
         2.relational = ==,!=,<,>,<=,>=
         3.logical = &&,||,!
          
         example of logical not =>

        !( 2 == 3 ) ==> true
        !( 2 == 2 ) ==> false

        4.assignment => = , += , -= , *= , /= , %=
        ex = 
             p+=q => p = p+q
        
        5. unary operators => +,-,++,--,!(logical complement operator)
        ex = 
            x = 5
            y = ++x (pre increment) phle increament fir assign
            z = x++ (post increment) phle assign fir increament
        
    
         */

    // 6.Bitwise operator =>
                    int p=9 ,q=10 ;

                    System.out.println(p|q);
                    System.out.println(p&q);
                    System.out.println(p^q);

                    System.out.println(p<<1);
                    System.out.println(p<<2);
                    System.out.println(q>>1);
                    System.out.println(q>>2);

    }
    }
    
    
    
    


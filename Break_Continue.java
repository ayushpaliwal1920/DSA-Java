import java.util.Scanner;
public class Break_Continue {
    @SuppressWarnings({ "unused", "resource" })
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);

    // break
        
        int num = 1;

        while (true) {
            if(num%5==0 && num%7== 0){
                System.out.println("fount ans = "+ num);
                break;
            }num++;
        }


         // continue

        System.out.println("print all values btw 1 to 50 except multiple of 3");

        for(int i=1 ; i<=50 ; i++){

            if (i % 3 == 0) {
                continue;
            }
            System.out.println(i);
        }


        System.out.println("print all values btw 1 to 50 except multiple of 5");

      myloop: for(int i=1 ; i<=50 ; i++){

            if (i % 5 == 0) {
                continue myloop; 
            }
            System.out.println(i);
        }

    }
}
//   same program by while loop

// System.out.println("print all values btw 1 to 50 except multiple of 3 by while loop");

// int j = 1;

// while ( j <= 50) {
//     if (j % 3 == 0) {
//         num++;
//         continue;
//     }
//     System.out.print(j);
//     num++; 
// }

//      }
// }


    
      

    
   
      
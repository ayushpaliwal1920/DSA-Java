package Array;


// Running time of the program depends on the various factor. factors are => logic or algo , Language dependent , machine dependent etc.

// Asymptotic Analysis => no of operations performed in a program as a finctions of input. we uses this analysis for calculating time complexity.

// In a graph of no of operattions or execution time vs input ,if at small input drastically change in execution time happens then it not a optimized algorithm.

// TYPES OF TIME COMPLEXITY ANALYSIS AND THEIR NOTATIONS =>

//              Worst Case   => BigO => O(n) {O(1) means Constant operations.}
//              Best Case    => BigOmega => Omega(1)
//              Average Case => BigThita => thita(n)

// 1sec means => 10^8 ~ 10^9 operations performed.


public class TimeAndSpaceComp {

    // time complexity => n+m operations => O(n+m)

    static void f2(int[] arr1, int arr2[]){
        int n= arr1.length; 
        int m= arr2.length; 

        for(int i=0 ; i<n ; i++){
            System.out.println(arr1[i]);
        }
        for(int i=0 ; i<m ; i++){
            System.out.println(arr2[i]);
        }
    }

    // time complexity of nested loops => 1 iteration = n operations
    //                                    n iteration = n operations , so time complexity => O(n*n) or O(n^2)


    static void f3(int n){
        for(int i=0; i<n;i++){
            for(int j=0 ; j<n ; j++){
                System.out.println("hello");
            }
        }
    }
    

//  when i=0 and j=i then time complexity => O(n^2)

static void f4(int n){
    for(int i=0 ; i<n ; i++){
        for(int j=0 ; j< i; j++){
            System.out.println("hello");
        }
    }
}

// when i=0 and j= Math.sqrt(n) then time complexity => O(n*sqrt(n))


static void f5(int n){
    for(int i=0 ; i<n ; i++){
        for(int j=0 ; j< Math.sqrt(n) ;j++){
            System.out.println("hello");
        }
    }
}

//  time complexity when i is incrementing as i*2 ==  O(log(n))

static void f6(int N){
int count = 0;
for(int i=0 ; i<N ; i*=2){
    count++;
     }
}

// Time complexity of below given program = O(logN base k)

static void f7(int N,int k){
    int val = 0;
    
    for(int i=0 ; i<=N ; i*=k){
       val++ ; 
    }
}

//  Space Complexity => extra memory / space used by an algorithm proportional to size of the input.

// input space and output is not counted or considered in the space complexity .

 






}

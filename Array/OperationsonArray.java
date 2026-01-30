package Array;


import java.util.Scanner;

@SuppressWarnings("unused")
class Arrayexample{
   
    // Length operation

     void operation(){
         
         int[] arr1 = {2,5,6,4,5,6,586,5,6,5,663,5};
         System.out.println(arr1.length);

         float[][] arr3 = { {1,2} ,{56,65} , {25,981,89}};
     } 

  // Trversing or iterating in array using loops
     
     void demoArray(){
        int[] ages = new int[9];
        float weight[] = new float[9];
        String[] names  = new String[30];
        String[] clg = {"fot" , "tulas" ,"gehu"};

        float[][] arr3 = { {1,(float) 0.55} ,{56,65} , {9030,8}};
 
        ages[0]= 5;
        ages[1]= 15;
        ages[2]= 34;
        ages[4]= 50;
 
        weight[0] = 34.4f;
        weight[3] = 334.4f;
        
        names[0] = "ikku";
        names[1] = "niba";
        names[2] = "shimba";
        names[3] = "chikku";

        System.out.println("one dimensional array");

        // Traversing using for loop

       for (int i=0; i<3 ; i++ ){
            System.out.println(ages[i]);
        } 
         
       for(int j=0 ; j<5 ; j++){
          System.out.println(names[j]);
       }
     
       // Tranversing using for-each loop  
  
       for(int Age : ages){
        System.out.println(Age);
       }

       // Traversing using while loop

        int i = 0;

       while (i<4){
       System.out.println(weight[i]);
       i++;
       }

       // Traversing multidimensional Array 
 
       System.out.println("multidimensional array");

       for(int j = 0 ; j<3 ; j++){
           for (int k = 0 ; k<2 ; k++){
               System.out.println(arr3[j][k]);
           }
       }

       System.out.println("using length operation");
      
//     using length operation
       
    //    for(int j = 0 ; j< arr3.length ; j++){

    //     for (int k = 0 ; k < arr3[j].length ; k++){

    //         System.out.println(arr3[j][k]);
    //     }

    }


    void sumOfArray(){
        int[] arr = {1,5,64,5,6,8,5,65,};
        int sum = 0 ;

        for( int i = 0 ; i< arr.length ; i++){
              sum = sum + arr[i];
        }
        System.out.println("sum of array : " +sum);
    }

    int max(){

        int[] arr4 = {4,56,54,62,9999,35,6,55,688,5,33,};
        int max = -1;

        for ( int i =0 ; i< arr4.length ; i++){
            if ( arr4[i] > max){
                max = arr4[i];
           } 
        }
       return max;
    }

    int searching(){
        int[] arr5 = {56,54,62,9999,35,6,55,688,5,33,56,4,6,88,97,5,5,65,4,663,2,5666,55};
        Scanner Sc;
        int target = 4;

        for (int i = 0; i<arr5.length ; i++){
            if( arr5[i] == target){
                return i;
            }
        }
        return -1;

        
}
}


public class OperationsonArray {
    @SuppressWarnings({ "resource", "unused" })
    public static void main(String[] args) {
        
        Scanner Sc = new Scanner(System.in);
        Arrayexample obj1 = new Arrayexample();
        obj1.operation();
        obj1.demoArray();
        obj1.sumOfArray();

        int max = obj1.max();
        System.out.println(" max = " +max);

        int index = obj1.searching();

        if(index == -1){
            System.out.println("not found");
        }
        else{
            System.out.println("fount at " + index);
        }

    }

}



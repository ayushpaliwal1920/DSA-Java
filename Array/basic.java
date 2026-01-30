package Array;

class Arrayexample{
  
    // hum methods ko static isliye banate h qki ek static method mai kvl dusra static method hi call kiya jaa skta hai chunki main method static h  isliye humne static methods banaye h
    public void multiArrays(){

           int[][] arr1 = new int[5][3];
           String[][] arr2 = new String[5][2];
           float[][] arr3 = { {1,2} ,{56,65} , {25,981,89}};

           arr1[0][0] = 1;
           arr1[0][1] = 2;
           arr1[0][2] = 3;

           arr2[1][2] = "htt";
           arr2[0][1] = "dumb";

           System.out.println(arr1[0][2]);
           System.out.println(arr2[0][1]);
           System.out.println(arr3[0][1]);
           System.out.println(arr3[1][0]);
           System.out.println(arr3[2][0]);

    }

   public void demoArray(){
       int[] ages = new int[9];
       float weight[] = new float[9];
       String[] names  = new String[30];
       String[] clg = {"fot" , "tulas" ,"gehu"};

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

       System.out.println(ages[0]);
       System.out.println(ages[4]);
       System.out.println(names[2]);
       System.out.println(names[1]);

       System.out.println(weight[0]);
       System.out.println(clg[0]);
       System.out.println(clg[2]);

    }
}




public class basic {
    public static void main(String[] args) {
        Arrayexample obj = new Arrayexample();
        obj.demoArray();
         obj.multiArrays();
    } 
}

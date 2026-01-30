 class Algebrs {
    int a = 10;
    int b = 5;
// we can acess a and b anywhere in thee class
    int  add (){

        // we can acess p and q only inside the method
         int p = 4;
         int q = 19;
         return p+q ;
    }

    int sub(int x , int y){
        return a-b ;
    }

    @SuppressWarnings("unused")
    void demo(){
        int b = 10;

      {
        int d = 100;
        int c = 20;
        System.out.println(d);
        // we can acess d ,c only inside the block
      }

      {
        int v =456; 
        System.out.println(v);
      }
    }
    
    
}

public class differentmethodscopes {
    public static void main(String[] args) {

        Algebrs obj1 = new Algebrs();
        obj1.demo();
        obj1.add();
        obj1.sub(2,5);
        
    }
}

public class passbyvalue {

    static void changevalue( int a){
           
        a *= 100;
        System.out.println("insode change valur : " +a);
    }
    public static void main(String[] args) {
              
        int a= 10;

        System.out.println("before changing value " +a);

        changevalue(a);
         
        System.out.println("after changing value :"+a);
    }
}
// java only uses pass by value concept not pass by refernce 
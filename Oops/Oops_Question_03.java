package Oops;

public class Oops_Question_03 {

        public static int gcd(int num, int den) {

            int min = Math.min(num,den);
            for(int i =min ; i>=i ; i--){
                if(num%i == 0 && den%i ==0){
                    return i;
                }
            }
            return min;
        }


        public static Fraction add(Fraction f1 , Fraction f2){

            int numerator = f1.num*f2.den + f1.den*f2.num ;
            int denominator = f1.den*f2.den ;

            Fraction f3 = new Fraction(numerator , denominator);

            return f3;
        }

        public static Fraction mul(Fraction f1 , Fraction f2){

            int numerator = f1.num*f2.num ;
            int denominator = f1.den*f2.den ;

            Fraction f3 = new Fraction(numerator , denominator);

            return f3;
        }

    // fraction class :

    public static class Fraction{
         int num;
         int den;

        public Fraction(){}
        public Fraction(int num , int den){
            this.num = num;
            this.den = den;
            simplyfy();
        }

        public void simplyfy(){

          int hcf = gcd(num,den);

          num /= hcf;
          den /= hcf;
        
        }
    

    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(3,7);
        System.out.println(f1.num + "/" + f1.den);

        Fraction f2 = new Fraction(6,12);
        System.out.println(f2.num + "/" + f2.den);

        Fraction f3 = add(f1,f2);
        System.out.println(f3.num + "/" + f3.den); 
        
    }
}
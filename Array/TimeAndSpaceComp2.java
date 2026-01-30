package Array;

public class TimeAndSpaceComp2 {
    // time complexity of given program is = O(logN)

    static void f1(int N) {
        int val = 0;
        for (int i = 0; i <= N; i *= 2) {
            val++;
        }
    }

    // time complexity of given program is = O(logN)

    @SuppressWarnings("unused")

    static void f2(int N) {
        int val = 0;
        for (int i = 1; i <= N; i += i) {
            val++;
        }
    }

    // time complexity of given program is = O(N)

    static void f3(int N) {
        int val = 0;
        for (int i = 1; i <= N; i *= 2) {
            for (int j = 0; j <= i; j++) {
                val++;
            }
        }
    }

    // time complexity of given program is = O(Nlog(N))

    static void f4(int N){
        int val=0;
        for(int i=1 ; i<=N ; i*=2){
            for(int j=N; j>i ; j--){
                val++;
            }
        }
    }

    // time complexity of given program is = O(N) good ques.>>

       static void f5(int N){
        int val=0;
        for(int i=N ; i>0 ; i/=2){
            for(int j=0; j<i ; j++){
                val++;
            }
        }
    }

    // time complexity of given program is = O(log(log(N))) good ques.

    static void f6(int N){
        int val=0;
        for(int i=2 ; i<=N ; i*=i){
            val++;
        }
    }


}

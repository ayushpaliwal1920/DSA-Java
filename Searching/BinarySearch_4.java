package Searching;

public class BinarySearch_4 {

    // Pattern : Binary Search on answer value .(imp and tough) lec-48

    /*;
    Q1 : You have 'n'(n<10^5) boxes of chocolate.Each box contains a[i] (a[i]<=10000) chocolates yoiu need to 
    distribute these boxes among 'm' students such that the maximum number of chocolates allocated to a student is 
    minimum .
    a.One box will be allocated to exactly one student.
    b.All the boxes should be allocated.
    c.Each student has to be allocated at least one Box.
    d.Allotment should be in contiguous order,for instance , a student cannot be allocated box1 and box3 , skipping box2.

    calculate and return that minimum possible number.
    Assume that it is always possible to distribute the chocolates. 
    */

    // time complexity => O(nlogn)

    static boolean isDivisionPossible(int[] a , int m , int mxChocAllowed){
        int numberOfStudents = 1;
        int choc = 0; // number of chocolates cuurent student has

        for(int i=0 ; i< a.length ; i++){
            if( a[i] > mxChocAllowed){ return false;}

            if( choc + a[i] <= mxChocAllowed){
                choc += a[i];
            }else{
                numberOfStudents++;
                choc = a[i];
            }
        }

        return numberOfStudents <= m;
    }

    static int distributeChocolates(int[] a,int m){
            if(a.length < m){ return -1;}

            int ans = 0, st=1 , end = (int)1e9;

            while(st <= end){

                int mid = st+(end-st)/2;

                if(isDivisionPossible(a, m, mid)){
                    ans = mid;
                    end = mid-1;
                }else{
                    st = mid+1;
                }
            }
            return ans;
    }


    /*
    Q2 : A new racing track for kids is being build in New York with 'n' starting points. The spots are located along a straight line at position x1,x1,,,xn(xi <= 10^9). For each  'i' , xi+1>xi.

    At a time only 'm' childeren are allowed to centre the race.Since the race track is for kids , they may run into each other while running.To prevent this,we want to choose the starting spots such that the minimum distance btw any two of them is as large as possible.What is the largest minimum distance?
    */

    // Time Complexity = O(nlogn)
    static boolean isPossible(int[]a ,int k , int dist){
        int kidsPlaced = 1;
        int lastkid = a[0];

        for(int i = 1; i< a.length; i++){
            if(a[i]- lastkid >= dist){
                kidsPlaced++;
                lastkid = a[i];
            }
        }
        return kidsPlaced >= k ;
    }

    static int raceTrack(int[] arr, int k){
        if( k > arr.length){ return -1;}

        int ans = -1 , st = 1 , end = (int)1e9;

        while(st <= end) {
            int mid = st + (end-st)/2;

            if(isPossible(arr, k , mid)){ // can k kids be placed such that no 2 kids have distance lesser than mid

                ans = mid;
                st = mid+1;
            }else{
                end = mid-1;
            }
  
        }
        return ans;
    }
    public static void main(String[] args){
        int a[] = {1,2,4,8,9};
        int n =2 ;
        System.out.println(distributeChocolates(a, n));
        System.out.println(raceTrack(a, n));

    }
}

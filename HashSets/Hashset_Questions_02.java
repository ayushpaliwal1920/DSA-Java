package HashSets;

import java.util.HashSet;

public class Hashset_Questions_02 {

    /*
    Q1 : Given an unsorted array of integers nums,returns the length of the longest consecutive elements sequence.
    */
    public static int longestConsecutive(int[] arr){
        HashSet<Integer> st = new HashSet<>();
        int maxlen = 0;

        // Insert element in HashSet : 
        for( int i : arr){
            st.add(i);
        }

        //  traverse on set :
      
        for( int num : st){
            if( !st.contains(num -1)){ // num is not starting point of a sequence
                int currNum = num; // 1
                int currlen = 1;   // length of current consecutive sequence 
                while( st.contains(currNum +1)){
                    currlen++;
                    currNum++;
                }
                maxlen = Math.max(currlen, maxlen);
            }
        }
        return maxlen;
    }

    /*
    Q2 : You are given n distinct pairs. Each pair is numbered from 1 to n . All these pairs  are initially put in a bag.You need to
         pair up each number.You take numbers one by one from the bag and for each number
         you look whether the pair of this number has already been taken out of the bag. or not .If not (pair of this number is still in
         the bag) you put the current number on the table infront of him.Otherwise , you put both numbers from the pair aside .Print the maximum k
         number from the pair aside. Print the maximum number of numbers of numbers that were on the table at the same time .
    */

         public static int maxNumberOnTable(int[] bag ){
            HashSet<Integer> table = new HashSet<>();
            int max = 0;
            for( int i = 0 ; i<bag.length ; i++){
                int curr = bag[i];
                if( table.contains(curr)){
                    table.remove(curr);
                }else{
                    table.add(curr);
                    max = Math.max(max,table.size());
                }
            }
            return max;
     }
    public static void main(String[] args) {
        int[] nums = {2,1,1,3,3,2};
    }
}

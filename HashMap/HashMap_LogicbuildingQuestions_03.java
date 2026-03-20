package HashMap;

import java.util.HashMap;

public class HashMap_LogicbuildingQuestions_03 {

    /*
    Q1 : Check whether two strings are anagram to each other .return true if they are else return false
    An anagram of a string is another string that contains the same character only the order of characters can be different.
     */

    // brute force : 
    public static boolean validAnagram1(String s1, String s2){
        HashMap<Character,Integer> hp1 = new HashMap<>();
        HashMap<Character,Integer> hp2 = new HashMap<>();

        //  check length : should be same for anagram
        if( s1.length() != s2.length()){
            return false;
        }

        // frequency map for s1 :
        for( char c : s1.toCharArray()){
            if( !hp1.containsKey(c)){
                hp1.put(c, 1);
            }else{
                hp1.put(c, hp1.get(c)+1);
            }
        }

        // frequency map for s2 :

        for( char c : s2.toCharArray()){
            if( !hp2.containsKey(c)){
                hp2.put(c, 1);
            }else{
                hp2.put(c, hp2.get(c)+1);
            }
        }


        // comparing bith hashmap :
        for( char c : hp1.keySet()){

            if( !hp2.containsKey(c)){
                return false;
            }

            if( !hp1.get(c).equals(hp2.get(c))){
                return false;
            }
        }
        return true;
    }

    // optimized : 

    public static boolean validAnagram2(String s , String t){

        HashMap<Character,Integer> mp = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }

        for( char ch : s.toCharArray()){
            if( !mp.containsKey(ch)){
                mp.put(ch,1);
            }else{
                mp.put(ch,mp.get(ch)+1);
            }
        }

        // now traverse string t and remove the character from the map which exist in string t:

        for( char ch : t.toCharArray()){
            if( !mp.containsKey(ch)){
                return false;
            }else{
                mp.put(ch, mp.get(ch) - 1);
            }

            if( mp.get(ch) == 0){
                mp.remove(ch);
            }
        }
        
        if( mp.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    /*
    Q2: Isomorphic strings : Given two strings , determine they are isomorphic or not 
     Two strings are isomorphic if the characters in s can be replaced to get t.
     */

     public static boolean isomorphicString(String s, String t){
        HashMap<Character,Character> mp = new HashMap<>();
        
        for(int i = 0; i<s.length(); i++){ // length is same of both string
            char sCh = s.charAt(i);
            char tCh = t.charAt(i);

            if(mp.containsKey(sCh)){
                if( mp.get(sCh) != tCh){
                    return false;
                }
            }else if( mp.containsValue(tCh)){
                return false;
            }else{
                mp.put(sCh, tCh);
            }
        }

        return true;
     }


/*
Q3 : Two sum : Given an array of length  n and a target , return a pair(indices) whose sum is equal to the target.
         if there is no pair present return -1;
*/

public static int[] twoSum(int[] arr ,int target){
    HashMap<Integer,Integer> mp = new HashMap<>(); // value , index
    int[] ans = {-1};

    for( int i = 0 ; i<arr.length ; i++){
        int partner = target - arr[i];

        if( !mp.containsKey(partner)){
            mp.put(arr[i], i);
        }else{
           ans = new int[]{i,mp.get(partner)};
        }
    }

    return ans;
}

/*
Q4 : Largest subarray with 0 sum :
     Given an array arr[] of length N , find the length of the largest subarray with sum equal to 0.

     very unique concept. prefix sum will use 
 */

    public static int zeroSumlargestSubarray(int[] arr){
        int maxlen = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        int prefixsum = 0;
        mp.put(0, -1);

        for(int i=0 ; i< arr.length ; i++){
            prefixsum = prefixsum + arr[i];
    
            if(mp.containsKey(prefixsum)){
                maxlen = Math.max(i - mp.get(prefixsum), maxlen); 
            }else{
               mp.put(prefixsum, i);
            }
        }
        return maxlen;
    }
     
    public static void main(String[] args) {
        String s1 = "egg";
        String s2 = "add";
        int[] arr = {15,-2,2,-8,1,7,10,25};
        // System.out.println(validAnagram2(s1, s2));
        System.out.println(isomorphicString(s1, s2));
        System.out.println(zeroSumlargestSubarray(arr));
    }
}

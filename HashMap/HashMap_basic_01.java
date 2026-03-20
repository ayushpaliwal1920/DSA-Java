package HashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMap_basic_01 {

    /* HashMap : it is a data structure which stores data in for of key value pair.

    It uses a technique called hashing to provide highly efficient (average time) insertion, retrieval, and removal operations. HashMaps allow null values and one null key, but do not maintain any specific order of entries

    It is a class under Map Interface .

    Hashmap : unordered 
    LinkedHashMap : insertion order 
    TressMap : Sorted order 

    */ 

    /*
    Features of HashMap Class : 

    To access a value one must one must know its key.
    HashMap doesn;t allow duplicate keys but allows duplicate values.
    Hashmap allows null key also but once and multiple null values.
    java Hashmap maintains no order.

    */

    /*
    Hash Key  : Actual data to be store

    Hash Function  : it produces same output for a input if same input is given multiple times.
                     A perfect hash function always produces unique for unique input.but in a non perfect hashfunction collision(diff input same output) can occur.

    Genrally used hashFunctions : 1. Division method = h(k) = k mod m ,
                                  2. Mid square method = h(k) = h(k*k),
                                  3. Digit Folding Method = k = k1,k2,k3 .. kn , s = k1+k2+..+kn , h(k) = s
                                  4. Multiplication method = h(k) = floor(kA mod 1)

    Hash Table : hashtable is a Array of Nodes where Node is <key , value>

    Collisions :  sometimes hashfunction can result in same hash value for different keys.
 
    Collision Resolution Techniques : Chaining(Open hashing) , Open Addressing(Closed Hashing) 

    Load factor = 0.75 by default
    
    Note : When the number of entries in the map crosses the threshold(threshold = load factor * initial capacity) value , 
    A new bucket array of double the size of previous bucket array  is created 
    and all the entries are copied from old array to the new bucket array . => this is done for maintain time complexity .

    ############## key --> hash function --> hashvalue(uses as indices of hash table) --> hashtable (actual data sorted) ########
    */

    // Q1 : Find out the most frequent element in array . if there exist multiple elements that appear a maximum numbers of times , print any one of them : TC = O(n)

    static void mostFrequentElement(int[] arr){
        // key : element of array , value : frequency

        Map<Integer ,Integer> mp = new HashMap<>();


        for(int el : arr){
            if(!mp.containsKey(el)){
                mp.put(el, 1);
            }else{
                mp.put(el, mp.get(el)+1);
            }
        }

        // now max frequency :

        int maxfreq =-1  , ans = -1;

        for(var e : mp.entrySet()){
            if( e.getValue() > maxfreq){
                maxfreq = e.getValue();
                ans = e.getKey();
            }
        }

        // or 

        // for( var e : mp.keySet()){
        //     if( mp.get(e) > maxfreq){
        //         maxfreq = mp.get(e);
        //         ans = e;
        //     }
        // }


        System.out.println(ans);
    }

    public static void main(String[] args) {
        
        // Syntax : 

        Map<String,Integer> mp = new HashMap<>();

        //  Adding Element :

        mp.put("Akash", 21);
        mp.put("Ayush", 20);
        mp.put("Yash", 16);
        mp.put("Radha", 18);
        mp.put("Denver", 30);
        mp.put("Tokyo", 28);

        // Getting value of a key in the hashmap :

        System.out.println(mp.get("Yash"));
        System.out.println(mp.get("Denver"));
        System.out.println(mp.get("Rahul"));  // null

        // updating the value in a hashMap :

        mp.put("Akash", 23);
        mp.put("Tokyo", 38);

        System.out.println(mp.get("Akash"));

        // Remove a pair from the Hashmap : return null if key is not present

        int rm = mp.remove("Radha");
        System.out.println(rm); 

        // Checking if a key is in the hashMap  :

        System.out.println(mp.containsKey("Akash"));
        System.out.println(mp.containsKey("Rahul"));

        // Adding a new entry only if the key doesn't exist already :

        mp.putIfAbsent("Rahul", 25);
        mp.putIfAbsent("Denver", 25);

        // Get all the keys in the hashmap :

        System.out.println(mp.keySet());

        // Get all the values in the HashMap :

        System.out.println(mp.values());

        // Get all entry in the hashmap :

        System.out.println(mp.entrySet());

        // Traverse all entries of Hashmap - multiple methods

        for (var key : mp.keySet()) {
            System.out.printf("Age of %s is %d : \n ", key , mp.get(key) );
        }

        System.out.println();

        for( Map.Entry<String,Integer> e : mp.entrySet()){
            System.out.printf("Age of %s is %d \n" , e.getKey() , e.getValue());
        }

        System.out.println();

        for( var e : mp.entrySet()){
            System.out.printf("Age of %s is %d \n" , e.getKey() , e.getValue());
        }

        System.out.println();

        System.out.println(mp.toString());

        int[] arr = {1,4,2,5,1,4,4,6,4,4,4};

        System.out.println("Most Frequwnt element in arr : ");
        mostFrequentElement(arr);

    }
}
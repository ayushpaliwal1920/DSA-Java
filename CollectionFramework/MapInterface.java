package CollectionFramework;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapInterface {

    // Map : In Java, the Map Interface is part of the java.util package and
    // represents a collection of key-value pairs, where Keys should be unique, but
    // values can be duplicated.

    // HashMap : unordered

    static void hashMap() {

        HashMap<Integer, String> mp = new HashMap<>();

        mp.put(1, "Ayush");
        mp.put(2, "Aman");
        mp.put(4, "Cat");
        mp.put(5, "Daidon");
        mp.put(6, "cat");
        mp.put(3, "Baison");
        mp.put(7, "Ayush");
        mp.put(7, "Aman"); // override

        System.out.println(mp.get(7));

        // or
        for (int i = 0; i < 4; i++) {
            System.out.println(mp.get(i));
        }

        System.out.println(mp.size());

        System.out.println(mp.containsKey(2));
        System.out.println(mp.containsValue("Baison"));
        System.out.println(mp.entrySet());
        System.out.println(mp.keySet());
        System.out.println(mp.values());

        // iterate over keys in a map

        for (var i : mp.keySet()) {
            System.out.print(i + " ");
        }
        System.out.println();

        // iterate over values in a map

        for (var i : mp.values()) {
            System.out.print(i + " ");
        }
        System.out.println();

        // iteratate over key value mapping

        for (var e : mp.entrySet()) {
            System.out.print(e + " ");
        }

    }

    // Linked HashMap : order of insertion

    static void linkedhashMap() {

        LinkedHashMap<Integer, String> mp = new LinkedHashMap<>();

        mp.put(1, "Ayush");
        mp.put(2, "Aman");
        mp.put(4, "Cat");
        mp.put(5, "Daidon");
        mp.put(6, "cat");
        mp.put(3, "Baison");
        mp.put(7, "Ayush");
        mp.put(7, "Aman"); // override

        System.out.println(mp.get(7));

        // or
        for (int i = 0; i < 4; i++) {
            System.out.println(mp.get(i));
        }

        System.out.println(mp.size());

        System.out.println(mp.containsKey(2));
        System.out.println(mp.containsValue("Baison"));
        System.out.println(mp.entrySet());
        System.out.println(mp.keySet());
        System.out.println(mp.values());

        // iterate over keys in a map

        for (var i : mp.keySet()) {
            System.out.print(i + " ");
        }
        System.out.println();

        // iterate over values in a map

        for (var i : mp.values()) {
            System.out.print(i + " ");
        }
        System.out.println();

        // iteratate over key value mapping

        for (var e : mp.entrySet()) {
            System.out.print(e + " ");
        }

    }

    // Tree map : sorted order according to the keys

    static void sortedhashMap() {

        TreeMap<Integer, String> mp = new TreeMap<>();

        mp.put(1, "Ayush");
        mp.put(2, "Aman");
        mp.put(4, "Cat");
        mp.put(5, "Daidon");
        mp.put(6, "cat");
        mp.put(3, "Baison");
        mp.put(7, "Ayush");
        mp.put(7, "Aman"); // override

        System.out.println(mp.get(7));

        // or
        for (int i = 0; i < 4; i++) {
            System.out.println(mp.get(i));
        }

        System.out.println(mp.size());

        System.out.println(mp.containsKey(2));
        System.out.println(mp.containsValue("Baison"));
        System.out.println(mp.entrySet());
        System.out.println(mp.keySet());
        System.out.println(mp.values());

        // iterate over keys in a map

        for (var i : mp.keySet()) {
            System.out.print(i + " ");
        }
        System.out.println();

        // iterate over values in a map

        for (var i : mp.values()) {
            System.out.print(i + " ");
        }
        System.out.println();

        // iteratate over key value mapping

        for (var e : mp.entrySet()) {
            System.out.print(e + " ");
        }

    }

    public static void main(String[] args) {
        System.out.println("HashMap : ");
        hashMap();

        System.out.println("\n\n");

        System.out.println("Linked HashMap :");
        linkedhashMap();

        System.out.println("\n\n");
        System.out.println("Sorted Hash map ");
        sortedhashMap();
    }
}

package CollectionFramework;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetInterface {

    // Set : no duplicate uses for uniqueness

    /*
     * Hashset : unordered , uniqueH collection of values ,hashing internally , most efficient(Time complexity ) : O(1)
     */

    static void hashSetExample() {

        HashSet<Integer> st = new HashSet<>();

        st.add(58);
        st.add(1);
        st.add(2);
        st.add(6);
        st.add(4);

        st.add(3);
        st.add(1);
        st.add(13);
        st.add(1);
        st.add(3);

        System.out.println(st);

        System.out.println(st.remove(2));
        System.out.println(st.contains(6));

        System.out.println(st.size());

    }

    /*
     * Linked Hashset : unique + order will be same as entered , LinkedList +
     * Hashset , normal efficient (Time complexity)
     */

    static void linkedHashset() {
        LinkedHashSet<Integer> st = new LinkedHashSet<>();

        st.add(58);
        st.add(1);
        st.add(2);
        st.add(6);
        st.add(4);

        st.add(3);
        st.add(1);
        st.add(13);
        st.add(1);
        st.add(3);

        System.out.println(st);

        System.out.println(st.remove(2));
        System.out.println(st.contains(6));

        System.out.println(st.size());
    }

    /*
     * Sorted Hashset : tree set , it will order sorted , uses self binary search treee , less efficient (Time complexity) : O(logn)
     */

    static void sortedHashset() {
        TreeSet<Integer> st = new TreeSet<>();

        st.add(58);
        st.add(1);
        st.add(2);
        st.add(6);
        st.add(4);

        st.add(3);
        st.add(1);
        st.add(13);
        st.add(1);
        st.add(3);

        System.out.println(st);

        System.out.println(st.remove(2));
        System.out.println(st.contains(6));

        System.out.println(st.size());
    }

    public static void main(String[] args) {
        System.out.println("Hashset : Order is not guarenteed");
        hashSetExample();

        System.out.println("Linked Hashset : Order is same as Entered");
        linkedHashset();

        System.out.println("Sorted Hashset : order of element will be sorted :");
        sortedHashset();
    }
}

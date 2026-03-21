package HashSets;

import java.util.HashSet;

public class Hashset_basic01 {

    // Hashset : No duplicate elements .

    // Types of HashSet : HashSet , Linked HashSet , Sorted hashSet

    public static void main(String[] args) {
        HashSet<Integer> st = new HashSet<>();

        // add :
        
        st.add(2);
        st.add(5);
        st.add(6);
        st.add(4);
        st.add(4);
        st.add(0);
        st.add(210);
        st.add(2);

        System.out.println(st);

        // contains :

        System.out.println(st.contains(5));

        // size :

        System.out.println(st.size());

        // remove :

        System.out.println(st.remove(4));

        // traverse :

        for( int i : st){
            System.out.print(i);
        }

    }
}

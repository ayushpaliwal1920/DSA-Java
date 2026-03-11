package CollectionFramework;

import java.util.*;

public class ListInterface {

    static void arrayListExample() {
        ArrayList<Integer> l = new ArrayList<>();

        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);

        System.out.println(l); // 1,2,3,4

        l.get(1); // 1 based indexingc answer is = > 2

        l.set(1, 10); // modify at index 1

        System.out.println(l);

        System.out.println(l.contains(10)); // true

    }

    static void linkedListExample() {
        LinkedList<Integer> l = new LinkedList<>();

        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);

        System.out.println(l); // 1,2,3,4

        l.get(1); // 1 based indexingc answer is = > 2

        l.set(1, 10); // modify at index 1

        System.out.println(l);

        System.out.println(l.contains(10)); // true

    }

    static void stackExample() {
        Stack<String> st = new Stack<String>();

        st.push("Ayush");
        st.push("nil");
        st.push("pil");
        st.push("sara");
        st.push("tendulkar");
        st.push("Ayush");

        System.out.println(st);

        st.peek();

        st.pop();

        System.out.println(st);

        System.out.println(st.pop());

        System.out.println(st.isEmpty());

        System.out.println(st.size());
    }

    public static void main(String[] args) {
        arrayListExample();

        linkedListExample();

        stackExample();
    }

}
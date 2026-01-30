package Array;
import java.util.ArrayList;
import java.util.Collections;

public class ArraylistEx2 {

    // Q1. reverse arraylist

    static void reverseList(ArrayList<Integer> list){
        int i=0 ; int j = list.size()-1;

        while (i<j) {
            Integer temp = Integer.valueOf(list.get(i));
            list.set(i,list.get(j));
            list.set(j, temp);
            i++;
            j--;
        }

    }

    // Q2.  sort arraylist of string in decending order

            public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(10);
        list.add(3);
        list.add(56);
        list.add(22);
        list.add(10);
        list.add(22);
        list.add(110);
        list.add(20);
        list.add(10);
        list.add(50);
        System.out.println("original List " + list);
        System.out.println("Reversed List " + list);

        reverseList(list);
        // or use collections class there is in built method
        // Collections.reverse(list);

        Collections.sort(list);
        System.out.println("Ascending Order " +list);

        Collections.sort(list,Collections.reverseOrder());
        System.out.println("Decending Order " +list);
 


        ArrayList<String> l1 = new ArrayList<>();
        l1.add("Hey!");
        l1.add("How");
        l1.add("you");
        l1.add("Doing");
        l1.add("whats");
        l1.add("Up");

        Collections.sort(l1);
        System.out.println("Sorted String ArrayList :" +l1);

        Collections.sort(l1,Collections.reverseOrder());
        System.out.println("Sorted Reversering ArrayList :" +l1);


    }
}

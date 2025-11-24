package Array;
import java.util.ArrayList;

// Wrapper Class => a class whose objects contains or wrap PDT(primitive data type).
// Object of a wrapper class contains a field which stores PDT.

// PDT   -      Wrapper Class
// int          Integer
// float        Float
// char         Character
// boolean      Boolean
// long         Long

// ARRAYLIST => Syntax to create a ArrayList =>List<AnyClass> list = new       ArrayList<AnyClass>();

// ArrayList has functionality => size is not fixed, and can use different methods.

public class ArrayListEx {    

@SuppressWarnings("unchecked")
public static void main(String[] args) {
    
    // Wrapper class

    // Integer i = new Integer();   this is old method new method is -

    Integer ini = Integer.valueOf(6);
    System.out.println(ini);

    Float f = Float.valueOf(4.5f);
    System.out.println(f);

    // why we use wrapper clases? check google mainly where we need object as parameter we will use wrapper class

    ArrayList<Integer> l1 = new ArrayList<>();

    // add new element in the Arraylist

    l1.add(5);  // it is used for adding at last.
    l1.add(6);
    l1.add(7);
    l1.add(8);
    l1.add(9);

    // get an element at index i

    System.out.println(l1.get(4));

    // print with for loop

    for(int i=0; i<l1.size(); i++ ){  // length ek property thi array ki but size() method h jo arraylist use krti hai.
        System.out.println(l1.get(i));
    }  

    // printing the arrraylist directly

    System.out.println(l1);

    // adding array at some index i
 
    l1.add(2,500);  // without replacing
    System.err.println(l1);

    // modifying element at index i

    l1.set(1,100 );
    System.out.println(l1);

    // removing element at index i

    l1.remove(0);
    System.out.println(l1);

    // removing an element e 

    l1.remove(Integer.valueOf(8));
    System.out.println(l1.remove(Integer.valueOf(17)));
    System.out.println(l1.remove(Integer.valueOf(7)));
    l1.remove(Integer.valueOf(17));
    System.out.println(l1);

    // checking if an element exist

    boolean ans = l1.contains(Integer.valueOf(9));
    System.out.println(ans);
    // or
    System.out.println(l1.contains(Integer.valueOf(8)));

    // if you don't specify class,you can put anything inside l

    @SuppressWarnings("rawtypes")
    ArrayList l = new ArrayList<>();

    l.add("Ayush");
    l.add("Dave");
    l.add(5);
    l.add(5.5);
    
    System.out.println(l);


 
}
     
}

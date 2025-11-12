package Recursion;

import java.util.Scanner;

public class Recursion8 {

    // Q1: Remove all 'a' using index
    static String removeA(String s, int idx) {
        if (idx == s.length())
            return "";

        String smallAns = removeA(s, idx + 1);
        char currChar = s.charAt(idx);

        if (currChar != 'a')
            return currChar + smallAns;
        return smallAns;
    }

    // Q1: Using substring (without index)
    static String removeA2(String s) {
        if (s.length() == 0)
            return "";

        String smallAns = removeA2(s.substring(1));
        char currChar = s.charAt(0);

        if (currChar != 'a')
            return currChar + smallAns;
        return smallAns;
    }

    // Q2: Reverse a string using recursion
    static String reverse(String s, int idx) {
        if (idx == s.length())
            return "";
        String smallAns = reverse(s, idx + 1);
        return smallAns + s.charAt(idx);
    }

    // Q3: Check palindrome using reverse
    static void palindrom(String s) {
        String rev = reverse(s, 0);
        if (rev.equals(s))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }

    // Q3: Palindrome using recursion (2-pointer)
    static boolean palindrom2(String s, int l, int r) {
        if (l >= r)
            return true;
        return s.charAt(l) == s.charAt(r) && palindrom2(s, l + 1, r - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Insert a string :");
        String s = sc.nextLine();
        System.out.println("You entered: " + s);

        // charAt()
        char c = s.charAt(0);
        System.out.println("First character: " + c);

        // length
        System.out.println("Length: " + s.length());

        // print characters
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
        }

        // substring(begin, end) → end is EXCLUSIVE
        if (s.length() >= 4) {
            String sub = s.substring(2, 4);
            System.out.println("Substring (2,4): " + sub);

            palindrom(sub);
            System.out.println("Palindrome2: " +
                    palindrom2(sub, 0, sub.length() - 1));
        }

        // Remove A results
        System.out.println("removeA: " + removeA(s, 0));
        System.out.println("removeA2: " + removeA2(s));
    }
}

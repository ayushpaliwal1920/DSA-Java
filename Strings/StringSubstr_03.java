package Strings;
import java.util.Scanner;

public class StringSubstr_03 {

    // substring(i,j) and substring(i) => substring() is a String method used to extract a part of a string.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "abcdef";
        System.out.println(str.substring(0,3)); // abc ,end index excluded and start index included
        System.out.println(str.substring(0,0)); // nothing

        System.out.println(str.substring(2)); // cdef
    }
}

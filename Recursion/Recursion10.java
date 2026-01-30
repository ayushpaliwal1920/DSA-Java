package Recursion;

import java.util.Scanner;

public class Recursion10 {
    /*
     * Q1 : There are N stones, numbered 0,1,2...N-1.For each i(o<=i<N) , the height
     * of stones i is hi . There is a frog who is initiially on Stone 0.He will
     * repeat the following action some number of times to reach Stone N-1.
     * If the frog is currently on Stone i,jump to Stone i+1 or Stone i+2.
     * Here , a cost of |hi-hj| is incurred,where j is the stone to land on.
     * 
     * Find the minimum possible total cost incurred before the frog reaches Stone
     * N.
     */

    // TOC = O()
    static int bestJump(int[] h, int n, int idx) {
        if (idx == n - 1) {
            return 0;
        }
        int opt1 = Math.abs(h[idx] - h[idx + 1]) + bestJump(h, n, idx + 1);
        if (idx == n - 2) {
            return opt1;
        }
        int opt2 = Math.abs(h[idx] - h[idx + 2]) + bestJump(h, n, idx + 2);
        return Math.min(opt1, opt2);
    }

    // Read about ASCCI Values first.
    // Note : Given Char ch = '3' ,if we want to make ch in integer then
    // int ch_val = ch - '0'
    // it can be understand by ASCII values.

    // Q2. Given a string containing digits from 2-9 inclusive,return all possible
    // letter combinations that the number could represent.Return the answer in any
    // order.
    // TOC= O(n4^n)
    static void combination(String dig, String[] kp, String res) {
        if (dig.length() == 0) {
            System.out.println(res + " ");
            return;
        }

        int currNum = dig.charAt(0) - '0'; // character(integer) converteed into int. // 2

        String currChoices = kp[currNum]; // "abc"

        for (int i = 0; i < currChoices.length(); i++) {
            combination(dig.substring(1), kp, res + currChoices.charAt(i));
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] h = { 10, 30, 40, 20, 30, 60, 50 };
        String dig = "253";
        String[] kp = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };// keypad mapping
        System.out.println(bestJump(h, h.length, 0));

        combination(dig, kp, "");
    }
}

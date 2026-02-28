package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class Stack_InterViewQuestions_05 {

    /*
     * Q1 : Balanced brackets : check whether a given bracket sequence is balanced
     * or not
     * 
     * rules for solving : 1. if opening bracket then push , 2. closing bracket -
     * case (a) opening bracket at top then pop(), case (b) - if stack is empty then
     * return false.
     * 
     * at the end of loop if stack is empty then return true.
     */

    public static boolean isbalancedBracket(String str) {

        Stack<Character> st = new Stack<>();

        int n = str.length();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            if (ch == '(') {

                st.push(ch);

            } else {
                if (st.size() == 0) {
                    return false;
                }
                if (st.peek() == '(') {
                    st.pop();
                }
            }

        }
        if (st.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Find the minimum number of brackets that we need to remove to make the given
     * bracket sequence balanced. .. Follow up question
     */

    public static int removeBracket(String str) {
        Stack<Character> st = new Stack<>();
        int n = str.length();

        int extraBracket = 0;

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                st.push(ch);
            } else { // case of closing bracket

                if (st.size() == 0) {
                    extraBracket++;
                }
                if (st.peek() == '(') {
                    st.pop();
                }
            }
        }
        return st.size() + extraBracket;
    }

    /*
     * Q3 : Check whether a given bracket sequence is valid or not : lletcode 20
     */

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (ch == ')' && st.peek() == '(' ||
                        ch == '}' && st.peek() == '{' ||
                        ch == ']' && st.peek() == '[') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        if (st.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Q4 : Given a subsequence of numbers .remove all the consicutive subsequence
     * of length greater than or equal 2 that contains the same element.
     * leet code 1209
     */

    public static int[] removeConsecutiveSubsequence(int[] arr) {

        Stack<Integer> st = new Stack<>();

        int n = arr.length;
        int i = 0;

        while (i < n) {
            if (st.size() == 0 || st.peek() != arr[i]) {
                st.push(arr[i]);
                i++;
            } else {

                int val = arr[i];
                // Skip all consecutive occurrences
                while (i < n && arr[i] == val) {
                    i++;
                }
                st.pop(); // Remove the element from stack
            }
        }
        int[] res = new int[st.size()];
        int m = res.length;

        for (int k = m - 1; k >= 0; k--) {
            res[k] = st.pop();
        }
        return res;
    }

    /*
     * Q5 : ** Next greater element : leetcode 496
     */

    // method 1 : brute force wihtout extra space time complexity O(n^2)

    public static int[] nextGreaterElement1(int[] arr) {
        int[] res = new int[arr.length];
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            res[i] = -1; // default value if greater not found

            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    res[i] = arr[j];
                    break; // only inner loop will break
                }
            }
        }
        return res;
    }

    // method 2 : imp

    public static int[] nextGreaterElement2(int[] arr) {
        int[] res = new int[arr.length];
        int n = arr.length;

        Stack<Integer> st = new Stack<>();

        res[n - 1] = -1;
        st.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {

            if (st.peek() > arr[i]) {
                res[i] = st.peek();
                st.push(arr[i]);
            } else {
                while (st.size() > 0 && st.peek() <= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
                    res[i] = -1;
                } else {
                    res[i] = st.peek();
                }
                st.push(arr[i]);
            }

        }
        return res;
    }

    /*
     * Q6: Stock span problem : Given a series of N daily price quotes for a stack
     * we need to calculate the span of the stock's price for all N days . the span
     * of the stock's price in one data is the maximum number of consecutive
     * days(starting from that day going backwords ) for which the stock price was
     * less than or equal to the price of that day.
     * 
     * span means : apna day or apne se phle vala day
     * 
     */

    public static int[] stockSpan(int[] arr) {
        int[] span = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            // STEP 1: Remove smaller or equal elements
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            // STEP 2: Calculate span
            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - st.peek();
            }

            // STEP 3: Push current index
            st.push(i);
        }
        return span;
    }

    /*
     * Q7 : Next smaller element :
     */

    public static int[] nextSmaller(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];

        for (int i = n - 1; i >= 0; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nse[i] = -1;
            } else {
                nse[i] = st.peek();
            }

            st.push(i);
        }
        return nse;
    }

    /*
     * Q8: Previous smaller element :
     * 
     */

    public static int[] previousSmaller(int[] arr) {

        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = st.peek(); // index of previous smaller
            }

            st.push(i);
        }
        return pse;
    }

    /*
     * Q7 : Largest rectangle in Histogram : leetcode hard :
     * Given an array of integer heights representing the histogram's bar height
     * where the width of each bar is 1 return the area of the largest rectangle in
     * histogram.
     * 
     * we need next smaller and previous smaller to solve this question .
     */

    // modified for question :

    public static int[] nextSmallerQ(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] nse = new int[n];

        for (int i = n - 1; i >= 0; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nse[i] = n; // modified
            } else {
                nse[i] = st.peek();
            }

            st.push(i);
        }
        return nse;
    }

    // modified for question :

    public static int[] previousSmallerQ(int[] arr) {

        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                pse[i] = -1;
            } else {
                pse[i] = st.peek(); // index of previous smaller
            }

            st.push(i);
        }
        return pse;
    }

    public static int largestRectangleArea(int[] heights) {
        int[] nse = nextSmallerQ(heights);
        int[] pse = previousSmallerQ(heights);

        int max = -1;

        for (int i = 0; i < heights.length; i++) {
            int area = heights[i] * (nse[i] - pse[i] - 1); // imp formula

            max = Math.max(max, area);
        }

        return max;
    }

    /*
     * Q8 : Min stack :
     */

    public static class MinStack {

        Stack<Integer> st = new Stack<>();
        Stack<Integer> min = new Stack<>();

        public MinStack() {
            // constructor
        }

        public void push(int val) {
            if (st.size() == 0) {
                st.push(val);
                min.push(val);
            } else {
                st.push(val);
                if (min.peek() <= val) {
                    min.push(min.peek());
                } else {
                    min.push(val);
                }
            }
        }

        public void pop() {
            st.pop();
            min.pop();
        }

        public int top() {
            return st.peek();
        }

        public int getmin() {
            return min.peek();
        }

    }

    // Approach 2 min stack : imp

    public static class Stack2 {
        Stack<Long> st = new Stack<>();
        long min = -1;

        public Stack2() {

        }

        void push(int val) {
            long x = val;

            if (st.size() == 0) {
                st.push(x);
                min = x;
            } else if (min <= x) {
                st.push(x);
            } else { // min > x
                st.push(2 * x - min); // important , we are inserting fake xue so we can restore our old minimun after
                                      // pop() operation
                min = x;
            }
        }

        public void pop() {
            if (st.size() == 0) {
                return;
            } else if (st.peek() > min) {
                st.pop();
            } else if (st.peek() < min) {
                // restore old minimum
                long oldmin = 2 * min - st.peek(); // peak pr fake value h
                min = oldmin;
                st.pop();
            }

        }

        public long top() {
            if (st.size() == 0) {
                return -1;
            }
            if (st.peek() >= min) {
                return st.peek();
            }
            if (st.peek() < min) {
                return min;
            }

            return 0;
        }

        public long getmin() {
            return min;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        System.out.println(isbalancedBracket(str));

        int[] arr = { 1, 2, 2, 3, 10, 10, 10, 4, 4, 4, 5, 7, 7 };
        int res[] = removeConsecutiveSubsequence(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();

        int[] arr2 = { 1, 5, 3, 2, 1, 6, 3, 4 };
        int[] res2 = nextGreaterElement2(arr2);
        for (int i = 0; i < res2.length; i++) {
            System.out.print(res2[i] + " ");
        }
    }
}
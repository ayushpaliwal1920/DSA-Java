package Stacks;

import java.util.Stack;

public class Stack_InterViewQuestions_6 {

    /*
     * Infix Expression : An infix expression is the standard way of writing
     * mathematical formulas where operators are placed between their operands.
     */

    /*
     * Rules for solving infix operation using stacks :
     * 
     * 
     * The process involves scanning the expression and applying operators based on
     * precedence:
     * Operands: Push onto the operand stack.
     * (: Push onto the operator stack.
     * ): Pop and apply operators from the operator stack until ( is found.
     * Operators: While the operator stack top has higher or equal precedence, pop
     * and apply operators, then push the current operator.
     * 
     */

    public static int infixEvaluation(String str) {

        // create two stacks :

        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            int ascii = (int) ch;

            // 0 = 48 and 9 = 57

            if (ascii >= 48 && ascii <= 57)
                val.push(ascii - 48);
            else if (op.size() == 0 || ch == '(' || op.peek() == '(') {
                op.push(ch);
            } else if (ch == ')') {
                while (op.peek() != '(') {
                    // work
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if (op.peek() == '+')
                        val.push(v1 + v2);
                    if (op.peek() == '-')
                        val.push(v1 - v2);
                    if (op.peek() == '/')
                        val.push(v1 / v2);
                    if (op.peek() == '*')
                        val.push(v1 * v2);

                    op.pop();
                }
                op.pop(); // '(' hata diya
            } else {
                if (ch == '+' || ch == '-') {
                    // work
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if (op.peek() == '+')
                        val.push(v1 + v2);
                    if (op.peek() == '-')
                        val.push(v1 - v2);
                    if (op.peek() == '/')
                        val.push(v1 / v2);
                    if (op.peek() == '*')
                        val.push(v1 * v2);

                    op.pop();

                    // push
                    op.push(ch);
                }
                if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') { // same priority
                        // work
                        int v2 = val.pop();
                        int v1 = val.pop();
                        if (op.peek() == '/')
                            val.push(v1 / v2);
                        if (op.peek() == '*')
                            val.push(v1 * v2);
                        op.pop();

                        // push

                        op.push(ch);

                    } else { // * and / has greater priority than +,-
                        op.push(ch);
                    }

                }
            }

        }

        // val stack -->

        while (val.size() > 1) {
            int v2 = val.pop();
            int v1 = val.pop();
            if (op.peek() == '+')
                val.push(v1 + v2);
            if (op.peek() == '-')
                val.push(v1 - v2);
            if (op.peek() == '/')
                val.push(v1 / v2);
            if (op.peek() == '*')
                val.push(v1 * v2);
            op.pop();
        }
        return (val.peek());

    }

    /*
     * Prefix Expressions : Prefix expression, or Polish notation, is a mathematical
     * notation where the operator precedes its operands . t eliminates the need for
     * parentheses to define operator precedence, making it highly efficient for
     * computer parsing and evaluation using stacks.
     */

    public static String infixToPrefix(String infix) {

        Stack<Character> op = new Stack<>();
        Stack<String> val = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 48 && ascii <= 57) {
                String s = "" + ch; // ch converted into string
                val.push(s);
            } else if (op.size() == 0 || ch == '(' || op.peek() == '(') {
                op.push(ch);
            } else if (ch == ')') {

                while (op.peek() != '(') {
                    // work
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();

                    String newString = o + v1 + v2; // concatination

                    val.push(newString);

                }
                op.pop(); // '(' hata diya
            } else {

                if (ch == '+' || ch == '-') {
                    // work
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();

                    String newString = o + v1 + v2;
                    val.push(newString);

                    // push
                    op.push(ch);
                }

                if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        // work
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();

                        String newString = o + v1 + v2;
                        val.push(newString);

                        // push
                        op.push(ch);

                    } else {
                        op.push(ch);
                    }
                }
            }

        }

        while (val.size() > 1) {
            String v2 = val.pop();
            String v1 = val.pop();
            char o = op.pop();

            String newString = o + v1 + v2;

            val.push(newString);
        }

        String prefix = val.peek();

        return prefix;

    }

    /*
     * Postfix Expression : only rule changed is v1 + v2 + o;
     */

    public static String infixToPostfix(String infix) {
        Stack<Character> op = new Stack<>();
        Stack<String> val = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {

            char ch = infix.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 48 && ascii <= 57) {
                String s = "" + ch;
                val.push(s);
            } else if (op.size() == 0 || ch == '(' || op.peek() == '(') {
                op.push(ch);
            } else if (ch == ')') {

                while (op.peek() != '(') {
                    // work
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();

                    String newString = v1 + v2 + o; // concatination

                    val.push(newString);

                }
                op.pop(); // '(' hata diya
            } else {

                if (ch == '+' || ch == '-') {
                    // work
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();

                    String newString = o + v1 + v2;
                    val.push(newString);

                    // push
                    op.push(ch);
                }

                if (ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        // work
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();

                        String newString = v1 + v2 + o;
                        val.push(newString);

                        // push
                        op.push(ch);

                    } else {
                        op.push(ch);
                    }
                }
            }
        }

        while (val.size() > 1) {
            String v2 = val.pop();
            String v1 = val.pop();
            char o = op.pop();

            String newString = v1 + v2 + o;

            val.push(newString);
        }
        String postfix = val.peek();

        return postfix;

    }

    /*
     * Postfix expression given calculate value :
     */

    public static int postfixEvaluation(String postfix) {
        Stack<Integer> val = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 48 && ascii <= 57) {
                val.push(ascii - 48); // 57 - 48 = 9(if our character is 9)
            } else {
                // ch == '*' || ch == '/' || ch == '+' || ch == '-'

                int v2 = val.pop();
                int v1 = val.pop();

                if (ch == '*')
                    val.push(v1 * v2);
                if (ch == '/')
                    val.push(v1 / v2);
                if (ch == '+')
                    val.push(v1 + v2);
                if (ch == '-')
                    val.push(v1 - v2);
            }
        }

        return val.pop();
    }

    /*
     * Prefix expression given calculate value : same as postfix but from reverse :
     * v1 and v2 will also be in reverse
     */

    public static int prefixEvaluation(String prefix) {
        Stack<Integer> val = new Stack<>();
        int n = prefix.length();
        for (int i = n - 1; i >= 0; i--) { // prefix always evaluates from back
            char ch = prefix.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 48 && ascii <= 57) {
                val.push(ascii - 48);
            } else {
                // in case of operators
                int v1 = val.pop();
                int v2 = val.pop();

                if (ch == '*')
                    val.push(v1 * v2);
                if (ch == '/')
                    val.push(v1 / v2);
                if (ch == '+')
                    val.push(v1 + v2);
                if (ch == '-')
                    val.push(v1 - v2);
            }
        }
        return val.pop();
    }

    /*
     * Conversion of Prefix to A Postfix expression :
     */

    public static String prefixToPostfix(String prefix) {
        Stack<String> val = new Stack<>();

        int n = prefix.length();

        for (int i = n - 1; i >= 0; i--) { // prefix always evaluates from back
            char ch = prefix.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 48 && ascii <= 57) {
                String newString = "" + ch;
                val.push(newString); // String stack because we are making postfix exprn
            } else {
                String v1 = val.pop();
                String v2 = val.pop();

                // if( ch == '*') val.push( v1 + v2 + "*");
                // if( ch == '/') val.push( v1 + v2 + "/");
                // if( ch == '+') val.push( v1 + v2 + "+");
                // if( ch == '-') val.push( v1 + v2 + "-");

                // or

                String t = v1 + v2 + ch;
                val.push(t);
            }
        }
        return val.pop();
    }

    /*
     * Conversion of Postfix to prefix : same from start and ch + v2 + v1
     * where v1 is fist poped and v2 is second poped
     */

    public static String postfixToPrefix(String prefix) {
        Stack<String> val = new Stack<>();

        int n = prefix.length();

        for (int i = 0; i < n; i++) { // prefix always evaluates from back
            char ch = prefix.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 48 && ascii <= 57) {
                String newString = "" + ch;
                val.push(newString); // String stack because we are making postfix exprn
            } else {
                String v1 = val.pop();
                String v2 = val.pop();

                // if( ch == '*') val.push( v1 + v2 + "*");
                // if( ch == '/') val.push( v1 + v2 + "/");
                // if( ch == '+') val.push( v1 + v2 + "+");
                // if( ch == '-') val.push( v1 + v2 + "-");

                // or

                String t = ch + v2 + v1;
                val.push(t);
            }
        }
        return val.pop();
    }

    /*
     * Prefix into Infix : One extra thing is add always brackets :
     */

    public static String prefixToInfix(String prefix) {
        Stack<String> val = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char ch = prefix.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 48 && ascii <= 57) {
                String newString = "" + ch;
                val.push(newString);
            } else {
                // incase of operators
                String v1 = val.pop();
                String v2 = val.pop();
                String t = "(" + v1 + ch + v2 + ")"; // always use brackets
                val.push(t);
            }
        }
        return val.pop();
    }

    /*
     * Post to Infix :
     * 
     */

    public static String postfixToInfix(String postfix) {
        Stack<String> val = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 48 && ascii <= 57) {
                String newString = "" + ch;
                val.push(newString);
            } else {
                // incase of operators
                String v2 = val.pop();
                String v1 = val.pop();
                String t = "(" + v1 + ch + v2 + ")"; // always use brackets
                val.push(t);
            }
        }
        return val.pop();
    }

    // IMPORTANT QUESTIONS : CELEBRITY PROBLEM GFG

    public static int celebrityInPool(int[][] M, int n) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        while (st.size() > 1) {
            int v1 = st.pop();
            int v2 = st.pop();

            if (M[v1][v2] == 0) {
                // shayad v1 celeb ho , pr v2 to celeb nhi h
                st.push(v1);
            } else if (M[v2][v1] == 0) {
                // shayad v2 celeb ho pr v1 to nhi h
                st.push(v2);
            }
        }

        if (st.size() == 0) {
            return -1;
        } // no celebs

        int potential = st.pop(); // isko rows and column wise check krenge ki ye celeb h ya nahi

        for (int j = 0; j < n; j++) {
            if (M[potential][j] == 1)
                return -1;
        }

        for (int i = 0; i < n; i++) {
            if (i == potential)
                continue;
            if (M[i][potential] == 0)
                return -1;
        }

        return potential;

    }

    // Question : SLIDING WINDOw MAXIMUM Leetcode : 239 hard

    // Brute force :

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1]; // n-(k-1)
        int z = 0;
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            ans[z++] = max;
        }

        return ans;
    }

    // Optimal solution : hint next greater element

 public static int[] maxSlidingWindow2(int[] nums, int k) {

    int n = nums.length;
    int[] ans = new int[n - k + 1];

    int[] nge = new int[n];

    Stack<Integer> st = new Stack<>();

    st.push(n - 1);
    nge[n - 1] = -1;

    for (int i = n - 2; i >= 0; i--) {
        while (st.size() > 0 && nums[st.peek()] < nums[i]) {
            st.pop();
        }
        if (st.size() == 0) {
            nge[i] = -1;
        } else {
            nge[i] = st.peek();
        }
        st.push(i);
    }

    // now  sliding window algo : 

    int z = 0;
    int j =0;
    for (int i = 0; i <= n - k; i++) {
        
        if( j >= i+k) j=i ;

        while (nge[j] != -1 && nge[j] < i + k) {
            j = nge[j];
        }
        ans[z++] = nums[j];
    }

    return ans;
}

    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";
        System.out.println(infixEvaluation(str));
        System.out.println(infixToPrefix(str));
        System.out.println(infixToPostfix(str));

        String str2 = "953+4*6/-";
        String str3 = "-9/*+5346";

        System.out.println(postfixEvaluation(str2));
        System.out.println(prefixEvaluation(str3));
        System.out.println(prefixToPostfix(str3));
        System.out.println(postfixToPrefix(str2));
        System.out.println(prefixToInfix(str3));
        System.out.println(postfixToInfix(str2));

        int[][] m = { { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
        System.out.println(celebrityInPool(m, 3));

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ans = maxSlidingWindow2(nums, 3);

        for (int i : ans) {
            System.out.print(i + " ");
        }

        
    }
}

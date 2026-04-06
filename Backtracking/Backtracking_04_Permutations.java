import java.util.ArrayList;
import java.util.List;

public class Backtracking_04_Permutations {

    /*
     * Q1 : Given an array nums of distinct integers, return all the possible
     * permutations. You can return the answer in any order.
     */
    // Recursion method 1 : O(n!) , Space : very much

    public static void printPermutation(String str, String t, List<String> l) {
        if (str.equals("")) {
            // System.out.println(t);
            l.add(t);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String left = str.substring(0, i);
            String right = str.substring(i + 1);

            String rem = left + right;

            printPermutation(rem, t + ch, l);
        }
    }

    // Backtraking method 2 :

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] isValid = new boolean[nums.length];
        helper(nums, ds, isValid, ans);
        return ans;
    }

    public static void helper(int[] nums, List<Integer> ds, boolean[] isValid, List<List<Integer>> ans) {
        if (ds.size() == nums.length) {
            List<Integer> list = new ArrayList<>(ds);
            ans.add(ds);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isValid[i] == false) {// call lgega
                ds.add(nums[i]);
                isValid[i] = true;
                helper(nums, ds, isValid, ans);

                // backtrack
                isValid[i] = false;
                ds.remove(ds.size() - 1);
            }
        }
    }

    // Backtraking method 2 : space Optimized same time complexity.

    public static void swap(int i  , int j , int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper2(nums, 0, ans);
        return ans;
    }

    public static void helper2(int[] nums, int idx, List<List<Integer>> ans) {
        int n = nums.length;
        if (idx == n - 1) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                l.add(nums[i]);
            }
            ans.add(l);
            return;
        }

        for (int i = idx; i < n; i++) {
            swap(i, idx, nums);
            helper2(nums, idx + 1, ans);

            // backtrack

            swap(i, idx, nums);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        List<String> l = new ArrayList<>();
        // printPermutation(str,"",l);

        // for(int i = 0 ; i<l.size() ; i++ ){
        // System.out.println(l.get(i));
        // }

        // Method 2

    }
}

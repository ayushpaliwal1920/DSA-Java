package HeapDS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Heap_Questions_02 {

    // Q1 : kth smallers element : TC : O(n.logk)

    // we are removing n-k largest elements

    public static int kthSmallest(int[] arr, int k) {
        // Create MAXHEAP :
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            if (pq.size() < k) {
                pq.add(arr[i]);
            } else if (arr[i] < pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        return pq.peek();
    }

    // Q2 : kth largest element : TC : O(n.logk)

    // we are removing n-k smalles elements

    public static int kthlargestElement(int[] arr, int k) {
        // Min heap :

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            if (pq.size() < k) {
                pq.add(arr[i]);
            } else if (arr[i] > pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        return pq.peek();
    }

    // Q3 : Nearly sorted array : GFG : TC = nlogK

    public static void nearlySortedArray(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0;
        for (int el : arr) {
            pq.add(el);
            if (pq.size() > k) {
                int top = pq.remove();
                arr[idx++] = top;
            }
        }

        while (pq.size() > 0) {
            arr[idx++] = pq.poll();
        }
    }

    // Q4 : sort array :

    public static void SortedArray(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0;
        for (int el : arr) {
            pq.add(el);
        }

        while (pq.size() > 0) {
            arr[idx++] = pq.poll();
        }
    }

    // Q5 : Last Stones leetcode : 1046

    public static int stone(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int el : arr) {
            pq.add(el);
        }

        while (pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();

            if (s1 != s2) {
                pq.add(s1 - s2);
            }
        }

        return pq.size() == 0 ? 0 : pq.poll();
    }

    // Q6 : Minimum cost of ropes : GFG

    public static int minimumCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // min heap

        for (int el : arr) {
            pq.add(el);
        }

        int sum = 0;

        // sort at every point for minimum sum :

        while (pq.size() > 1) {
            int s1 = pq.poll();
            int s2 = pq.poll();

            int cost = s1 + s2;
            sum += cost;

            pq.add(cost);
        }

        return sum;
    }

    // Q7 : K closest point to origin : Very IMPORTANT QUESTION : USE OF COMPARATOR

    public static int[][] kClosest(int[][] nums, int k) {

        // Compare based on distance so we uses comparator for it : read documentattion
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> ((b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])));

        for (int[] num : nums) {
            pq.add(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int ans[][] = new int[k][2];
        int idx = 0;
        while (pq.size() > 0) {
            ans[idx++] = pq.poll();
        }
        return ans;
    }

    // Q8 : K closest element : leetcode : Imp use of comparator
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    int d1 = Math.abs(a - x);
                    int d2 = Math.abs(b - x);

                    if (d1 == d2)
                        return b - a;
                    else
                        return d2 - d1;
                });

        for (int el : arr) {
            pq.add(el);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (pq.size() > 0) {
            ans.add(pq.poll());
        }

        Collections.sort(ans);
        return ans;
    }

    // Q9 : k frequent element : Imp 

    public static void main(String[] args) {

    }
}

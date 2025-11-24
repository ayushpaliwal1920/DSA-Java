package Sorting;

public class QuickSort06 {

     static void displayArr(int[] arr){
        for(int val : arr){
            System.out.print(val + " ");
        }
    }

    static void swap(int[] arr,int x,int y){
        int temp = arr[x];
        arr[x]= arr[y];
        arr[y] = temp;
    }


    // Quick Sort : also a Divide and Conquer Algo

    static void quicksort(int[] arr,int st,int end){
        if(st>= end) return;

        int pi = partition(arr,st,end);
        quicksort(arr, st, pi-1);
        quicksort(arr, pi+1, end);
    }

    static int partition(int[] arr , int st , int end){
            int pivot = arr[st]; 
            int elementLessTPvt = 0;

            for(int i= st+1; i<end ;i++){
                if(arr[i] <= pivot){
                    elementLessTPvt++;
                }
            }

            int pvtIdx = st + elementLessTPvt;

            swap(arr, st, pvtIdx);

            int i= st , j=end;

        // element lesser will be on left and elements greater will be on right of pivot
            while (i < pvtIdx && j > pvtIdx) {

                while (arr[i] <= pivot) i++;
                while (arr[j] <= pivot) j--;
                    
                if (i < pvtIdx && j> pvtIdx) {
                    swap(arr, i, j);
                    i++;
                    j--;
                }
            }


            return pvtIdx;


    }
   
    public static void main(String[] args) {
        int[] arr = {1,25,36,0,14,25,55};

        System.out.println("Arrray before sorting :");
        displayArr(arr);
        System.out.println();

        quicksort(arr, 0, arr.length-1);

        System.out.println("Array after sorting :");
        displayArr(arr);

    }
}

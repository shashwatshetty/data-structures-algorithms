/*
Sorts a given integer array using the Merge Sort Algo.
Pseudocode followed for the Algo is:
    INSERTION-SORT(A)
        for j = 2 to A.length
            key = A[j]
            i = j - 1
            while i > 0 and A[i] > key
                A[i + 1] = A[i]
                i = i - 1
            A[i + 1] = key
 */
public class InsertionSort {
    /*
    Given: Unsorted array
    Effect: Sorts the array in ascending order.
     */
    public static void inertionSort(int[] input){
        // outer loop considers one element and checks for the correct position
        // it should be placed in the inner loop
        for(int j = 1; j < input.length; j++){
            int key = input[j];
            int i = j - 1;
            while(i >= 0 && input[i] > key){
                input[i + 1] = input[i];
                i--;
            }
            input[i + 1] = key;
        }
    }

    public static void main(String args[]){
        int[] arr1 = {3,5,7,2,1,4,6,9,0,8};
        InsertionSort.inertionSort(arr1);
        System.out.println("The Sorted Array is: ");
        for(int e:arr1){
            System.out.print(e);
        }
    }
}

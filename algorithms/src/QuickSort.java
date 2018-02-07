/*
Sorts a given integer array using the Merge Sort Algo.
Pseudocode followed for the Algo is:
    QUICKSORT(A, p, r)
		if p < r
			q = PARTITION(A, p, r)
			QUICKSORT(A, p, q-1)
			QUICKSORT(A, q+1, r)

	PARTITION(A, p, r)
		x = A[r]
		i = p - 1
		for j = p to r - 1
			if A[j] <= x
				i = i + 1
				exchange A[i] with A[j]
		exchange A[i + 1] with A[r]
		return i + 1
*/
public class QuickSort {
    /*
    Given: An integer array, the start index and end index of the sub-array to be sorted
    Effect: Sorts the array from the start index to the end index in a non-decreasing order.
     */
    public static void quickSort(int[] arr, int p, int r){
        // recursion stops if start index is greater than end index
        if(p < r){
            // the pivot for dividing the array
            int q = partition(arr, p, r);
            // first part sort recursive call
            quickSort(arr, p, q - 1);
            // second part sort recursive call
            quickSort(arr, q + 1, r);
        }
    }

    /*
    Given: An integer array, the start and end indexes of the sub-array to be partitioned
    Returns: the index of the pivot that divides the array
    Effect: Array gets re-arranged such that every element below pivot is less than or equal to pivot
            snd every element above pivot is greater than pivot.
     */
    public static int partition(int[] arr, int p, int r){
        // last element is chosen as pivot
        int x = arr[r];
        // index of the pivot
        int i = p - 1;
        // loop runs till one index less than the pivot
        for(int j = p; j <= r - 1; j++){
            // if element is less than pivot
            if(arr[j] <= x){
                // move pivot index by one
                i = i + 1;
                // swap elements at i and j
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        // swap pivot with the element at pivot index
        int temp = arr[r];
        arr[r] = arr[i + 1];
        arr[i + 1] = temp;
        return i + 1;
    }

    public static void main(String args[]){
        int[] arr = {4,2,3,5,1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("The Sorted Array is: ");
        for(int e : arr){
            System.out.print(e+" ");
        }
    }
}

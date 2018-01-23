/*
Sorts a given integer array using the Merge Sort Algo.
Pseudocode followed for the Algo is:
    MERGE(A,p,q,r):
		n1 = q - p + 1
		n2 = r - q
		let L[1..n1 + 1] and R[1..n2 +1] be new arrays
		for i = 1 to n1
			L[i] = A[p + i - 1]
		for j = 1 to n2
			R[i] = A[q + j]
		L[n1 + 1] = "infinity"
		R[n2 + 1] = "infinity"
		i = 1
		j = 1
		for k = p to r
			if L[k] > R[k]
				A[k] = L[k]
				i = i + 1
			else A[k] = R[k]
				j = j + 1

	MERGE-SORT(A,p,r):
		if p < r
			q = (p + r)/2
			MERGE-SORT(A,p,q)
			MERGE-SORT(A,q + 1,r)
			MERGE(A,p,q,r)
 */
public class MergeSort {
    /*
    Given: Original array, starting index p, breakpoint index q, end index r of a sub-problem.
    Effect: merges the elements into a sorted array from index p to r
    Invariant: p <= q <= r where arr[p:q] and arr[q+1:r] is sorted.
     */
    public static void merge(int[] arr, int p, int q, int r){
        int n1 = q - p + 2;             // size of left sorted array
        int n2 = r - q + 1;             // size of right sorted array
        int[] left = new int[n1];
        int[] right = new int[n2];
        int inf = Integer.MAX_VALUE;    // sentinel card value
        // initialising left array
        for(int i = 1; i < n1; i++){
            left[i - 1] = arr[p + i - 1];
        }
        // initialising right array
        for(int j = 1; j < n2; j++){
            right[j - 1] = arr[q + j];
        }
        // initialising last value as sentinel
        left[n1 - 1] = inf;
        right[n2 - 1] = inf;
        int i = 0;
        int j = 0;
        for(int k = p; k <= r; k++){
            // compare top cards of the two arrays, lowest value goes to the
            // the original array from index p to r
            if(left[i] < right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
        }
    }

    /*
    Given: Original array arr, starting index p, end index r of a sub-problem.
    Effect: Sorts the array from index p to r in the original array arr.
     */
    public static void mergeSort(int[] arr, int p, int r){
        // divide & conquer strategy used, problem divided into two parts
        // and each part is solved recursively
        if(p < r){
            int q = (p + r)/2;
            mergeSort(arr, p, q);
            mergeSort(arr,q + 1, r);
            merge(arr, p, q, r);
        }
    }

    public static void main(String args[]){
        int[] arr = {5,2,4,7,1,3,2,6};
        MergeSort.mergeSort(arr, 0, arr.length - 1);
        System.out.println("The Sorted Array is: ");
        for(int e : arr){
            System.out.print(e);
        }
    }
}

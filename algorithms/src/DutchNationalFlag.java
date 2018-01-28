/*
Sorts a given integer array in three ways, i.e. breaking the array in 3 parts or ranges
Pseudocode followed for the algo is:
    THREE-WAY-PARTITION(A, mid)
        i = 0
        j = 0
        n = size of A - 1
        while j <= n:
            if A[j] < mid
                swap A[i] and A[j]
                i = i + 1
                j = j + 1
            else if A[j] > mid
                swap A[j] and A[n]
                n = n - 1
            else:
                j = j + 1
 */
public class DutchNationalFlag {
    /*
    Given: Original array and the value that should be in the middle layer.
    Effect: Sorts the array into 3 parts, one lower than the middle value, the middle value and
    one above the middle value.
     */
    public static void threeWayPartition(int[] arr, int mid){
        // i indicates the top of the lowest layer.
        int i = 0;
        // j indicates the top of the middle layer.
        int j = 0;
        // n indicates the start of the top most layer.
        int n = arr.length - 1;
        // loop runs till the indexes j and n dont cross each other.
        while(j <= n){
            // case if the element at index j is less than middle value
            // then that value should be put at the ith index
            // i and j should be increased.
            if(arr[j] < mid){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
                i++;
            }
            // case if the element at index j is more than the middle value
            // then that value should be put at the nth index
            // n should be decreased.
            else if(arr[j] > mid){
                int temp = arr[j];
                arr[j] = arr[n];
                arr[n] = temp;
                n--;
            }
            // case when the value at index j is equal to middle value
            // then j should be increased.
            else{
                j++;
            }
        }
    }

    public static void main(String args[]){
        int[] arr = {0,1,2,0,2,1,1,2,0,1,2,1,0,0};
        threeWayPartition(arr, 1);
        System.out.println("The sorted array is: ");
        for(int e : arr){
            System.out.print(e+" ");
        }
    }
}

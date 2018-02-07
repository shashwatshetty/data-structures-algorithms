public class QuickSort {
    public static void quickSort(int[] arr, int p, int r){
        if(p < r){
            int q = partition(arr, p, r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    public static int partition(int[] arr, int p, int r){
        int x = arr[r];
        int i = p - 1;
        for(int j = p; j <= r - 1; j++){
            if(arr[j] <= x){
                i = i + 1;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
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

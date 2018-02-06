public class QuickSort {
    public static void quickSort(int[] arr, int p, int r){
        if(p < r){
            int q = partition(arr, p, r);
            System.out.println(q);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }

    public static int partition(int[] arr, int p, int r){
        int x = arr[r];
        int i = p - 1;
        for(int j = p; j <= r - 1; j++){
            if(arr[j] <= x){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        arr[i + 1] = arr[r];
        return i + 1;
    }

    public static void main(String args[]){
        int[] arr = {19, 9, 5, 12, 8, 7, 4, 21, 2, 6, 11};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("The Sorted Array is: ");
        for(int e : arr){
            System.out.print(e+" ");
        }
    }
}

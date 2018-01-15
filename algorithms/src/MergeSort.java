public class MergeSort {
    public static void merge(int[] arr, int p, int q, int r){
        int n1 = p - q + 1;
        int n2 = r - q;
        int[] left = new int[n1];
        int[] right = new int[n2];
        int inf = (int)Double.POSITIVE_INFINITY;
        for(int i = p; p < q + 1; i++){
            left[i] = arr[i];
        }
        for(int j = q + 1; j < r; j++){
            right[j] = arr[j];
        }
        left[n1 - 1] = inf;
        right[n2 - 1] = inf;
        int i = 0;
        int j = 0;
        for(int k = p; k < r; k++){
            if(left[i] < right[j]){
                arr[k] = left[i];
                i++;
            }else{
                arr[k] = right[j];
                j++;
            }
        }
    }

    public static void mergeSort(int[] arr, int p, int r){
        int q;
        if(p < r){
            q = (p + r)/2;
        }
        mergeSort(arr, p, q);
        mergeSort(arr,q + 1, r);
        merge(arr, p, q, r);
    }

    public static void main(String args[]){
        int[] arr = {6,5,3,1,8,7,2,4};
    }
}

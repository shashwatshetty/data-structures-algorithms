public class HeapSort {
    public static int left(int i){
        return (2 * i + 1);
    }

    public static int right(int i){
        return (2 * i + 2);
    }

    public static void maxHeapify(Heap a, int i){
        int l = left(i);
        int r = right(i);
        int largest;
        if(l < a.heapSize && a.arr[l] > a.arr[i]){
            largest = l;
        }else{
            largest = i;
        }
        if(r < a.heapSize && a.arr[r] > a.arr[largest]){
            largest = r;
        }
        if(largest != i){
            int temp = a.arr[i];
            a.arr[i] = a.arr[largest];
            a.arr[largest] = temp;
            maxHeapify(a, largest);
        }
    }

    public static Heap buildMaxHeap(int[] arr){
        Heap a = new Heap(arr);
        for(int i = arr.length/2; i >=0; i--){
            maxHeapify(a, i);
        }
        return a;
    }

    public static void main(String args[]){
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        Heap res = buildMaxHeap(arr);
        for(int e : res.arr){
            System.out.print(e+" ");
        }
    }
}

class Heap{
    int[] arr;
    int length;
    int heapSize;

    Heap(int[] arr){
        this.arr = arr;
        this.length = arr.length;
        this.heapSize = arr.length;
    }
}

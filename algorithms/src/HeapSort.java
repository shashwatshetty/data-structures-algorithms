/*
Sorts a given integer array using the Heap Sort Algo.
Pseudocode followed for the Algo is:
    MAX-HEAPIFY(A, i)
		l = LEFT(i)
		r = RIGHT(i)
		if l <= A.heap-size and A[l] > A[i]
			largest = l
		else largest = i
		if r <= A.heap-size and A[r] > A[largest]
			largest = r
		if largest != i
			exchange A[i] with A[largest]
			MAX-HEAPIFY(A, largest)

    BUILD-MAX-HEAP(A)
		A.heap-size = A.length
		for i = floor(A.length/2) downto 1
			MAX-HEAPIFY(A, i)

    HEAPSORT(A)
		BUILD-MAX-HEAP(A)
		for i = a.LENGTH DOWNTO 2
			exchange A[1] with A[i]
			A.heap-size = A.heap-size - 1
			MAX-HEAPIFY(A, 1)
 */
public class HeapSort {
    /*
    Given: An index of a node
    Returns: the index of its Left child.
     */
    public static int left(int i){
        return (2 * i + 1);
    }

    /*
    Given: An index of a node
    Returns: the index of its Right child.
     */
    public static int right(int i){
        return (2 * i + 2);
    }

    /*
    Given: A Heap and the starting index
    Pre-Condition: The left and right child nodes of the node at index i must
                    satisfy the max heap property.
    Effect: Ensures that the node at index i satisfies the max heap property.
     */
    public static void maxHeapify(Heap a, int i){
        // get the left child index
        int l = left(i);
        // get the right child index
        int r = right(i);
        int largest;
        // if value at the left child is greater, largest will be left child index
        if(l < a.heapSize && a.arr[l] > a.arr[i]){
            largest = l;
        }
        // else it will be i
        else{
            largest = i;
        }
        // if value at the right child is greater, largest will be right child index
        if(r < a.heapSize && a.arr[r] > a.arr[largest]){
            largest = r;
        }
        // case when the largest element amont, node i, left of i and right of i is in the children
        if(largest != i){
            // exchange largest child with i
            int temp = a.arr[i];
            a.arr[i] = a.arr[largest];
            a.arr[largest] = temp;
            // check if changed child node satisfies max heap property
            maxHeapify(a, largest);
        }
    }

    /*
    Given: an integer array
    Returns: a Heap object with every node satisfying the max heap property
     */
    public static Heap buildMaxHeap(int[] arr){
        // create the Heap object
        Heap a = new Heap(arr);
        // since the leaf nodes that satisy the precondition for maxHeapify start at the
        // middle of the array loop runs from half of array length to 0.
        for(int i = arr.length/2; i >= 0; i--){
            // recursively call maxHeapify to restore the max heap property at every node.
            maxHeapify(a, i);
        }
        // return heap object.
        return a;
    }

    /*
    Given: an integer array
    Returns: a Heap object with the elements ordered in non decreasing order in the heap.
     */
    public static Heap heapSort(int[] arr){
        // from the given array build a heap with buildMaxHeap
        Heap a = buildMaxHeap(arr);
        // loop runs from the last node in the heap to 0.
        for(int i = arr.length - 1; i >= 0; i--){
            // swap first and last nodes
            int temp = a.arr[i];
            a.arr[i] = a.arr[0];
            a.arr[0] = temp;
            // decrease heap size to exclude the last node.
            a.heapSize--;
            // restore the max heap property from the first node.
            maxHeapify(a, 0);
        }
        return a;
    }

    public static void main(String args[]){
        int[] arr = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        Heap res = heapSort(arr);
        for(int e : res.arr){
            System.out.print(e+" ");
        }

    }
}

/*
Data structure that represents a heap.
Implemented using an integer array with heapSize as one of the class variables.
 */
class Heap{
    // the array that represents the heap.
    int[] arr;
    // the heap size, which is 0 <= heapSize <= arr.length.
    int heapSize;

    // constructor
    Heap(int[] arr){
        this.arr = arr;
        // initialise the heap size as length of array.
        this.heapSize = arr.length;
    }
}

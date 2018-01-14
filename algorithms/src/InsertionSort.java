public class InsertionSort {
    public static int[] inertionSort(int[] input){
        for(int j = 1; j < input.length; j++){
            int current = input[j];
            int i = j - 1;
            while(i >= 0 && input[i] > current){
                input[i + 1] = input[i];
                i--;
            }
            input[i + 1] = current;
        }
        return input;
    }

    public static void main(String args[]){
        int[] arr1 = {3,5,7,2,1,4,6,9,0,8};
        int[] result = InsertionSort.inertionSort(arr1);
        System.out.println("The Sorted Array is: ");
        for(int e:result){
            System.out.print(e);
        }
    }
}

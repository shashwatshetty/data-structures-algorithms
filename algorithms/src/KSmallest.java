import java.util.Random;

public class KSmallest {
    /*
     Given:   an array of n integers and a non-negative integer k <= n,
     Returns: an array of length k containing the k smallest
                values in the given array, in non-decreasing order.
     Run Time: Big-O((k^2).n)
   */
    public static int[] smallest(int[] input, int k){
        int[] res = new int[k];
        int i = 0;
        int n = input.length;
        while(i < k){
            int least = Integer.MAX_VALUE;
            int leastIndex = -1;
            int index = 0;
            while(index < n){
                if(input[index] < least){
                    least = input[index];
                    leastIndex = index;
                }
                index++;
            }
            if(n > 0 && leastIndex != input.length) {
                int temp = input[n - 1];
                input[n - 1] = input[leastIndex];
                input[leastIndex] = temp;
            }
            res[i] = least;
            i++;
            n--;
        }
        return res;
    }

    public static void main(String args[]){
        Random r = new Random();
        int[] test = new int[20];
        for(int i = 0; i < 20; i++)
            test[i] = r.nextInt(20);
        System.out.println("For input array: ");
        for(int e : test)
            System.out.print(e+" ");
        System.out.println();
        int[] res = smallest(test, 15);
        System.out.println("The 15 smallest elements are: ");
        for(int e : res)
            System.out.print(e+" ");
    }
}
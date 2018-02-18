import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class KSmallest {
    /*
     Given:   an array of n integers and a non-negative integer k <= n,
     Returns: an array of length k containing the k smallest
                values in the given array, in non-decreasing order.
     Run Time: Big-O(k.n)
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

    // benchmarking code to calculate the running time for the smallest method.
    public static <T> int[] time (Supplier<T> thunk) {
        System.out.println();
        try {
            long t0 = System.currentTimeMillis();
            int[] result = (int[])thunk.get();
            long t1 = System.currentTimeMillis();
            long t = t1 - t0;
            System.out.println ( "Program Runs in " + t + " milliseconds!");
            return result;
        }
        catch (Error e) {
            System.out.println ("\nERROR: " + e);
            return null;
        }
    }

    public static void printArray(int[] res){
        for(int e : res) {
            System.out.print(e + " ");
        }
    }

    public static void main(String args[]){
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Input Array Length");
        int n = sc.nextInt();
        System.out.println("Enter Value for k");
        int k = sc.nextInt();
        int[] test = new int[n];
        for(int i = 0; i < n; i++)
            test[i] = r.nextInt(Integer.MAX_VALUE);
        System.out.println("For input array: ");
        printArray(test);
        int[] res = time(() -> smallest(test, k));
        printArray(res);
    }
}
/*
Calculates the Maximum Sub-Array in a given Array. The maximum sub-array problem is the one where
we want to find the nonempty, contiguous sub-array of an array whose values have the largest sum.
 */
public class MaximumSubArray {
    public static void main(String args[]){
        int[] test = {0,0,0,0,1,1,2};
        int[] ans = maxSubarray(test);
        Utilities.printArray(ans, "The Max subArray is:");
    }

    /*
    Pseudocode:
        FIND-MAX-CROSSING-SUBARRAY(A, low, mid, high)
            left-sum = -INFINITY
            sum = 0
            for i = mid downto low
                sum = sum + A[i]
                if sum > left-sum
                    left-sum = sum
                    max-left = i
            right-sum = -INFINITY
            sum = 0
            for j = mid + 1 to high
                sum = sum + A[j]
                if sum > right-sum
                    right-sum = sum
                    max-right = j
            return (max-left, max-right, left-sum + right-sum)
     */

    /*
    Given: an array, the lowest, middle and highest index of some sub-array of the given array
    Returns: an array with 3 elements, that contain the lowest and highest index of the max sub-array
              which crosses the mid point and the max sum.
     */
    public static int[] maxCrossingSubarray(int[] A, int low, int mid, int high) {
        // max sum of the left part
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int leftMax = 0;
        // loop which checks the max sub-array in the left part
        for (int i = mid; i >= 0; i--) {
            // adds elements to the sum
            sum += A[i];
            // when current sum is greater than max sum of the left part
            if (sum > leftSum) {
                leftSum = sum;
                // stores the lowest index in the left part
                leftMax = i;
            }
        }
        // max sum of the right part
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int rightMax = 0;
        // loop which checks the max sub-array in the right part
        for (int i = mid + 1; i < A.length; i++) {
            // adds elements to the sum
            sum += A[i];
            // when current sum is greater than max sum of the right part
            if (sum > rightSum) {
                rightSum = sum;
                // stores the highest index in the right part
                rightMax = i;
            }
        }
        // result array
        int[] subArr = {leftMax, rightMax, leftSum + rightSum};
        return subArr;
    }

    /*
    Pseudocode:
        FIND-MAXIMUM-SUBARRAY(A, low, high)
            if high == low
                return (low, high, A[low])
            else
                mid = floor((high + low)/2)
                (left-low, left-high, left-sum) = FIND-MAXIMUM-SUBARRAY(A, low, mid)
                (right-low, right-high, right-sum) = FIND-MAXIMUM-SUBARRAY(A, mid + 1, high)
                (cross-low, cross-high, cross-sum) = FIND-MAX-CROSSING-SUBARRAY(A, low, mid, high)
                if left-sum >= right-sum and left-sum >= cross-sum
                    return (left-low, left-high, left-sum)
                elseif right-sum >= left-sum and right-sum >= cross-sum
                    return (right-low, right-high, right-sum)
                else
                    (cross-low, cross-high, cross-sum)
     */

    /*
    Given: an array, lowest and highest index of some sub-array of the given array
    Returns: an array with 3 elements, that contain the lowest and highest index of the max sub-array
              and the max sum of the given array.
     */
    public static int[] findMaxSubarray(int[] A, int low, int high){
        // base case for the recursion when only one element is present
        if(low == high){
            int[] subArr = {low, high, A[low]};
            return subArr;
        }else{
            // calculate mid point
            int mid = (low + high)/2;
            // recursive call to the left part
            int[] leftResult = findMaxSubarray(A, low, mid);
            // recursive call to the right part
            int[] rightResult = findMaxSubarray(A, mid + 1, high);
            // call which calculates max sub-array which crosses the mid point
            int[] crossResult = maxCrossingSubarray(A, low, mid, high);
            // ladder if-else that gets the maximum sum from the above three results
            if(leftResult[2] >= rightResult[2] && leftResult[2] >= crossResult[2])
                return leftResult;
            else if(rightResult[2] >= crossResult[2] && rightResult[2] >= leftResult[2])
                return rightResult;
            else
                return crossResult;
        }
    }

    /*
    Given: an array
    Returns: the maximum sub-array of the given array
     */
    public static int[] maxSubarray(int[] A){
        // handles case when array is empty
        if(A == null && A.length == 0){
            return A;
        }
        // call to get the lowest and highest indices of the max sub-array
        int[] result = findMaxSubarray(A, 0, A.length - 1);
        int start = result[0];
        int end = result[1];
        int[] maxSubArr = new int[end - start + 1];
        // populates the result array from the given array
        for(int i = 0; i < maxSubArr.length; i++){
            maxSubArr[i] = A[i + start];
        }
        return maxSubArr;
    }
}


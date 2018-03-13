public class MaximumSubArray {
    public static int[] maxCrossingSubarray(int[] A, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int leftMax = 0;
        for (int i = mid; i >= 0; i--) {
            sum += A[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftMax = i;
            }
        }
        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int rightMax = 0;
        for (int i = mid + 1; i < A.length; i++) {
            sum += A[i];
            if (sum > rightSum) {
                rightSum = sum;
                rightMax = i;
            }
        }
        int[] subArr = {leftMax, rightMax, leftSum + rightSum};
        return subArr;
    }

    public static int[] findMaxSubarray(int[] A, int low, int high){
        if(low == high){
            int[] subArr = {low, high, A[low]};
            return subArr;
        }else{
            int mid = (low + high)/2;
            int[] leftResult = findMaxSubarray(A, low, mid);
            int[] rightResult = findMaxSubarray(A, mid + 1, high);
            int[] crossResult = maxCrossingSubarray(A, low, mid, high);
            if(leftResult[2] >= rightResult[2] && leftResult[2] >= crossResult[2])
                return leftResult;
            else if(rightResult[2] >= crossResult[2] && rightResult[2] >= leftResult[2])
                return rightResult;
            else
                return crossResult;
        }
    }
}


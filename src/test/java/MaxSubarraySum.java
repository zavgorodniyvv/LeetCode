import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSubarraySum {

    @Test
    public void test() {
        int [] input = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        assertEquals(6, maxSubArray(input));

        input = new int[]{1};
        assertEquals(1, maxSubArray(input));

        input = new int[]{5,4,-1,7,8};
        assertEquals(23, maxSubArray(input));
    }

    public int maxSubArray(int[] nums){
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

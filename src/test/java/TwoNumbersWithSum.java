import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoNumbersWithSum {

    @Test
    void twoNumbersWithSumTest() {
        var nums = new int[]{2, 7, 11, 15};
        var target = 9;
        var result = twoSum(nums, target);
        var expected = new int[]{0, 1}; // Expected indices of the two numbers that add up to the target
        assertArrayEquals(result, expected);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (tempMap.containsKey(complement)) {
                return new int[]{tempMap.get(complement), i};
            }
            tempMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

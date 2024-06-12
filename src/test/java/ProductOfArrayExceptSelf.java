import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductOfArrayExceptSelf {
    private final int[][] numbers = {{1, 2, 3, 4}, {-1, 1, 0, -3, 3}};

    private final int[][] expectedArrays = {{24, 12, 8, 6}, {0, 0, 9, 0, 0}};


    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    @DisplayName("Product of Array Except Self")
    void test(int i) {
        assertArrayEquals(expectedArrays[i], productExceptSelf(numbers[i]));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] left= new int[nums.length];
        int[] right=new int[nums.length];
        left[0]=1;
        for(int i=1; i< nums.length; i++)
        {
            left[i]=left[i-1]*nums[i-1];
        }
        right[nums.length-1]=1;
        for(int i=nums.length-2; i>=0;i--)
        {
            right[i]=right[i+1]*nums[i+1];
        }
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=left[i]*right[i];
        }
        return nums;
    }
}
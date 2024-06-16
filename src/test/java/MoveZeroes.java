import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoveZeroes {

    private final int[][] inputArrays = {
            {0, 1, 0, 3, 12},
            {0},
            {0, 0, 1}
    };

    private final int[][] expected = {
            {1, 3, 12, 0, 0},
            {0},
            {1, 0, 0}
    };

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("MoveZeroes")
    void test(int i) {
        moveZeroes(inputArrays[i]);
        assertArrayEquals(expected[i], inputArrays[i]);
    }

    public void moveZeroes(int[] nums) {
        int j = nums.length - 1;
        for (int i = 0; i < j; i++) {
            if (nums[i] == 0) {
                System.arraycopy(nums, i + 1, nums, i, j - i);
                nums[j--] = 0;
                i--;
            }

        }
        System.out.println();
    }
}

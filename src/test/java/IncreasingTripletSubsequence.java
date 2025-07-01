import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IncreasingTripletSubsequence {

    private final int[][] inputArrays = {
            {1,2,3,4,5},
            {5,4,3,2,1},
            {2,1,5,0,4,6},
            {20,100,10,12,5,13}
    };

    private final boolean[] expected = {true, false, true, true};

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("Increasing Triplet Subsequence")
    void test(int i) {
        assertEquals(expected[i], increasingTriplet(inputArrays[i]));
    }

    public boolean increasingTriplet(int[] nums) {
        int max1 = Integer.MAX_VALUE;
        int max2 = Integer.MAX_VALUE;
        for(int n : nums) {
            if(n <= max1) max1 = n;
            else if(n <= max2) max2 = n;
            else return true;
        }
        return false;
    }
}

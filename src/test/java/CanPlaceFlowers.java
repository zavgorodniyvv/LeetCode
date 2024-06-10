import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanPlaceFlowers {
    private final int[][] inputArrays = {
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 0},
            {1},
            {1}
    };
    private final int[] inputN = {1, 2, 2, 1, 2, 0, 1};
    private final boolean[] expected = {true, false, true, false, true, true, false};

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    @DisplayName("Can Place Flowers")
    void test(int i) {
        assertEquals(expected[i], canPlaceFlower(inputArrays[i], inputN[i]));
    }

    private boolean canPlaceFlower(int[] flowerbed, int n) {
        for(int i = 0; i< flowerbed.length; i++){
            if(flowerbed[i] == 0){
                var isLeftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
                var isRightEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                if (isLeftEmpty && isRightEmpty){
                    n--;
                }
            }
            if(n == 0){
                return true;
            }

        }
        return false;
    }
}

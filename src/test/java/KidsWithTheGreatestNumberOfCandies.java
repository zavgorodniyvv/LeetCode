import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KidsWithTheGreatestNumberOfCandies {

    private final int[][] candiesNumber = {
            {2, 3, 5, 1, 3},
            {4, 2, 1, 1, 2},
            {12, 1, 12}
    };

    private final int[] extraCandies = {3, 1, 10};

    private final List<List<Boolean>> expectedBooleanArray = List.of(
            List.of(true,true, true, false, true),
            List.of(true,false, false, false, false),
            List.of(true,false, true)
    );

    @ParameterizedTest
    @ValueSource(ints ={0, 1, 2})
    @DisplayName("Kids with the greatest number of candies")
    void test(int i) {
        assertEquals(expectedBooleanArray.get(i), kidsWithCandies(candiesNumber[i], extraCandies[i]));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxArrayElement = 0;
        for (int candy : candies) {
            maxArrayElement = Math.max(maxArrayElement, candy);
        }
        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < candies.length; i++){
            if((candies[i] + extraCandies) >= maxArrayElement) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}

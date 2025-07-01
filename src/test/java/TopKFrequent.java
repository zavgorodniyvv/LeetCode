import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequent {

    @Test
    public void topKFrequentTest() {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        var result = topKFrequent(nums, k);
        int[] expected = {1,2};
        Assertions.assertArrayEquals(expected, result);
    }

    int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(var num : nums){
            map.merge(num, 1, Integer::sum);
        }
        return map.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}

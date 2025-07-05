import org.junit.jupiter.api.Test;

import java.beans.PropertyEditorSupport;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class IntersectionOfTwoArrays {

    @Test
    public void test() {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] expected = {2};
        assertArrayEquals(expected, intersection(nums1, nums2));

    }

    int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for(var n : nums1) {
            set.add(n);
        }

        for(var n: nums2) {
            if(set.contains(n)){
                result.add(n);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

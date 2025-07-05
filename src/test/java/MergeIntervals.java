import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeIntervals {

    @Test
    void test() {
        int [][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int [][] expected = new int[][]{{1,6},{8,10},{15,18}};
        assertArrayEquals(expected, merge(intervals));
    }

    int[][] merge(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        for(int i = 1; i < intervals.length; i++){
            if(current[1] >= intervals[i][0]){
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                merged.add(current);
                current = intervals[i];
            }
        }
        merged.add(current);
        return merged.toArray(new int[merged.size()][]);
    }
}

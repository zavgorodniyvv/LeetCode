package hackerRank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 {
    @Test
    void run(){
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(4);
        arr.add(6);
        arr.add(5);
        arr.add(3);
        int result = findMedian(arr);
        System.out.println(result);
    }

    public static int findMedian(List<Integer> arr) {
        int result = 0;
        Collections.sort(arr);
        var middleElementIndex = arr.size()/2;
        result = middleElementIndex + 1;

        return arr.get(result);
    }
}

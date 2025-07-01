package hackerRank;

import org.junit.jupiter.api.Test;

import java.util.List;

public class DivisibleSumPairs {
    @Test
    void Test(){
        List<Integer> arr = List.of(1,2,3,4,5,6);
        var resunlt = divisibleSumPairs(arr.size(), 5, arr);
        System.out.println(resunlt);
    }

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int left = ar.get(i);
                int right = ar.get(j);
                if(( left + right) % k == 0){
                    result++;
                }
            }

        }


        return result;
    }

}

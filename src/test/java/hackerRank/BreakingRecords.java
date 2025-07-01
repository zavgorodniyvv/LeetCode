package hackerRank;

import org.junit.jupiter.api.Test;

import java.util.List;

public class BreakingRecords {

    @Test
    void breakingRecords(){
        var result = breakingRecords(List.of(12, 24, 10, 24));
        System.out.println();
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int min = scores.get(0);
        int max = scores.get(0);
        int countMax = 0;
        int countMin = 0;

        for(int i = 1; i < scores.size(); i++){
            int currentScore = scores.get(i);
            if(currentScore > max){
                max = currentScore;
                countMax++;
                continue;
            }

            if(currentScore < min){
                min = currentScore;
                countMin++;
                continue;
            }
        }

        return List.of(countMax, countMin);
    }
}

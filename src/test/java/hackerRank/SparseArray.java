package hackerRank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SparseArray {
    @Test
    void run(){
        List<String> strings = List.of("ab", "ab", "abc");
        List<String> queries = List.of("ab", "abc", "bc'");

        var result = matchingStrings(strings, queries);

        System.out.println(result);
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> stringToQuantiyMap = new HashMap<>();
        for(var query: queries){
            stringToQuantiyMap.put(query, 0);
        }
        for(var string: strings){
            if(stringToQuantiyMap.containsKey(string)){
                stringToQuantiyMap.merge(string, 1, Integer::sum);
            }
        }
        for(var query: queries){
            result.add(stringToQuantiyMap.get(query));
        }
        return result;
    }

}

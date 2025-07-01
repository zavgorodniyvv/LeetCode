import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupAnagramm {

    @Test
    public void test() {
        String[] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        var expected = List.of(
                List.of("eat", "tea", "ate"),
                List.of("tan", "nat"),
                List.of("bat")
        );
        assertEquals(expected, groupAnagrams(strings));

    }

    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(var str: strs){
            var sortedSrt = str.toCharArray();
            Arrays.sort(sortedSrt);
            String key = new String(sortedSrt);

            if(map.containsKey(key)){
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<>());
                map.get(key).add(str);
            }
        }

        for(var entry: map.entrySet()){
            result.add(entry.getValue());
        }

        return result;
    }
}

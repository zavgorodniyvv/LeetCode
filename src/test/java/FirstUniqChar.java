import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstUniqChar {

    @Test
    public void firstUniqChar() {
        String str = "leetcode";
        assertEquals(0, firstUniqChar(str));

        str = "loveleetcode";
        assertEquals(2, firstUniqChar(str));

        str = "aabb";
        assertEquals(-1, firstUniqChar(str));

    }

    int firstUniqChar(String s){
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();

        for(var ch: charArray){
            map.merge(ch, 1, Integer::sum);
        }

        for(int i = 0; i < charArray.length; i++){
            var number = map.get(charArray[i]);
            if(number == 1){
                return i;
            }
        }
        return -1;
    }
}

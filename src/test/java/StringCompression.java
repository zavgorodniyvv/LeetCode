import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCompression {

    private static final char[][] inputChars = {    {'a','a','b','b','c','c','c'},
                                                    {'a'},
                                                    {'a','b','b','b','b','b','b','b','b','b','b','b','b'},
                                                    {'a','a','a','b','b','a','a'}
    };
    private static final int [] expectedNumbers = {6, 1, 4, 6};

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("String Compression")
    void test(int i){
        assertEquals(expectedNumbers[i], compress(inputChars[i]));
    }

    public int compress(char[] chars) {
        char currentChar = chars[0];
        String result = "";
        int counter = 1;
        for(int i =1; i < chars.length; i++){
            if(chars[i] == currentChar){
                counter ++;
            } else {
                result = result.concat(String.valueOf(currentChar)).concat(counter == 1 ? "" : String.valueOf(counter));
                currentChar = chars[i];
                counter = 1;
            }
        }
        result = result.concat(String.valueOf(currentChar)).concat(counter == 1 ? "" : String.valueOf(counter));
        System.arraycopy(result.toCharArray(), 0, chars, 0, result.length());
        return result.length();
    }
}

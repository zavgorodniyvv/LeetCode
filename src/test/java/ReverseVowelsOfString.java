import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseVowelsOfString {
    private static final String[] inputString = {"hello", "leetcode", "sdfg", "euo", "p", "aA"};
    private static final String[] expectedResultString = {"holle", "leotcede", "sdfg", "oue", "p", "Aa"};

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    @DisplayName("Reverse Vowels of a String")
    void test(int i){
        assertEquals(expectedResultString[i], reverseVowels(inputString[i]));
    }

    public String reverseVowels(String s) {
        final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] resultArray = new char[s.length()];
        int leftPointer = 0;
        int rightPointer = s.length()-1;
        while(leftPointer <= rightPointer){
            char currentChar = s.charAt(leftPointer);
            if(!vowels.contains(currentChar)){
                resultArray[leftPointer] = currentChar;
                leftPointer++;
                continue;
            }
            currentChar = s.charAt(rightPointer);
            if(!vowels.contains(currentChar)){
                resultArray[rightPointer] = currentChar;
                rightPointer--;
                continue;
            }
            resultArray[leftPointer] = s.charAt(rightPointer);
            resultArray[rightPointer] = s.charAt(leftPointer);
            leftPointer++;
            rightPointer--;
        }

        return new String(resultArray);
    }

}

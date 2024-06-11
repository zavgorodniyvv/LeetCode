import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseWordsInAString {
    private static final String[] inputString = { "the sky is blue", "  hello world  ", "a good   example"};
    private static final String[] expectedResultString = {"blue is sky the", "world hello", "example good a"};

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
//    @ValueSource(ints = {2})
    @DisplayName("Reverse Words in a String")
    void test(int i){
        assertEquals(expectedResultString[i], reverseWords(inputString[i]));
    }

    public String reverseWords(String s) {
        s = s.trim();
        var wordsArray = s.split(" ");
        var cleanedWordsList = Arrays.stream(wordsArray).filter(e -> !e.isEmpty()).toList();
        var cleanedWordsListSize = cleanedWordsList.size();
        String[] result = new String[cleanedWordsListSize];
        for(int i = 0; i < cleanedWordsListSize/2 + 1; i++){
            int j = cleanedWordsListSize - 1 - i;
            result[i] = cleanedWordsList.get(j);
            result[j] = cleanedWordsList.get(i);
        }
        return String.join(" ", result);
    }
}

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeStringsAlternately {

    private static final String[] firstString = {"abc", "ab", "abcd"};
    private static final String[] secongString = {"pqr", "pqrs", "pq"};
    private static final String[] expectedResultString = {"apbqcr", "apbqrs", "apbqcd"};

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    @DisplayName("Merge Strings Alternately")
    void test(int i){
        assertEquals(expectedResultString[i], getStringBuilder(firstString[i], secongString[i]));
    }

    private static String getStringBuilder(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Math.max(word1.length(), word2.length()); i++) {
            if(i < word1.length()){
                sb.append(word1.charAt(i));}
            if(i < word2.length()){
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }

}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstirngInString {

    @Test
    void run() {
        String s = "ANANN";
        int result = lengthOfLongestSubstring(s);
        assertEquals(2, result); // Expected output: 3
    }

    private int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int[] charIndex = new int[128]; // Assuming ASCII characters

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charIndex[currentChar] > left) {
                left = charIndex[currentChar];
            }
            charIndex[currentChar] = right + 1; // Store the next index of the character
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

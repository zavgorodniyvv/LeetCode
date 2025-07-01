import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Brackets {

    @Test
    public void bracketsTest() {
        String  brackets = "()[]{}";
        assertTrue(isValid(brackets));

        brackets = "(]";
        assertFalse(isValid(brackets));

        brackets = "([)]";
        assertFalse(isValid(brackets));

        brackets = "{[]}";
        assertTrue(isValid(brackets));

    }

    public boolean isValid(String brackets) {
        Stack<Character> stack = new Stack<>();
        for (char c : brackets.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()){
                    return false;
                }
                char cFromStack = stack.pop();
                if(!((cFromStack == '(' && c == ')') || (cFromStack == '{' && c == '}') || (cFromStack == '[' && c == ']'))){
                    return false;
                }
            }
        }
        return stack.empty();
    }
}

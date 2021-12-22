package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ValidParentheses {
    private static final Map<Character, Character> map = new HashMap<>() {{
        put('{', '}');
        put('(', ')');
        put('[', ']');
    }};

    public boolean isValid(String s) {
        if (s.length() == 1) return false;
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);

            } else {
                if (!stack.isEmpty() && c == map.get(stack.peek())) {
                    stack.pop();

                } else {
                    return false;

                }

            }
        }

        return stack.isEmpty();
    }

    @Test
    void test() {
        Assertions.assertThat(isValid("()")).isTrue();
    }

    @Test
    void test2() {
        Assertions.assertThat(isValid("()[]{})")).isTrue();
    }

    @Test
    void test3() {
        Assertions.assertThat(isValid("(]")).isFalse();
    }

    @Test
    void test4() {
        Assertions.assertThat(isValid("([)]")).isFalse();
    }

    @Test
    void test5() {
        Assertions.assertThat(isValid(")(){}")).isFalse();
    }
}

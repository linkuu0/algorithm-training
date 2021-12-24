package leetcode;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int count = 0;
        if ("".equals(s)) return count;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);

            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);

                } else {
                    // TODO 모르겟음;
                    count = Math.max(count, i - stack.peek());
                }
            }
        }

        return count;
    }

    @Test
    void test() {
        Assertions.assertThat(longestValidParentheses("(()")).isEqualTo(2);
    }

    @Test
    void test2() {
        Assertions.assertThat(longestValidParentheses(")()())")).isEqualTo(4);
    }

    @Test
    void test3() {
        Assertions.assertThat(longestValidParentheses("()(()")).isEqualTo(2);
    }
}

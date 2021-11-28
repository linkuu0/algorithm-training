package programmers.stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * [프로그래머스] Lv.2 올바른 괄호
 * https://programmers.co.kr/learn/courses/30/lessons/12909
 *
 * String 연산은 느림. 가능하면 캐릭터로
 */
public class CorrectBraces {
    public boolean solution(String s) {
        if (s.length() % 2 == 1 || s.charAt(0) == ')')
            return false;

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (stack.isEmpty())
                    return false;
                else
                    stack.pop();

            } else {
                stack.push(s.charAt(i));

            }

        }

        return stack.isEmpty();
    }

    @Test
    void test() {
        boolean answer1 = solution("()()");
        Assertions.assertThat(answer1).isTrue();

        boolean answer2 = solution("(())()");
        Assertions.assertThat(answer2).isTrue();

        boolean answer3 = solution(")()(");
        Assertions.assertThat(answer3).isFalse();

        boolean answer4 = solution("(()(");
        Assertions.assertThat(answer4).isFalse();
    }
}

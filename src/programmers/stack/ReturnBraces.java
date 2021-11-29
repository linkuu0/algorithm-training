package programmers.stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * [프로그래머스] Lv.2 괄호 변환
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 * TODO 미완성
 */
public class ReturnBraces {
    /**
     * 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
     * 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며,
     *    v는 빈 문자열이 될 수 있습니다.
     * 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
     *   3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
     * 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
     *   4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
     *   4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
     *   4-3. ')'를 다시 붙입니다.
     *   4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
     *   4-5. 생성된 문자열을 반환합니다.
     */

    public String reverse(String w) {
        if (w.length() <= 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder(w).reverse();
        return sb.substring(1, sb.length()-1);
    }

    public String split(String w) {
        String u = "", v;
        int cnt = 0;

        for (int i=0; i<w.length(); i++) {
            if (w.charAt(i) == '(')
                cnt++;
            else
                cnt--;

            if (cnt == 0) {
                u = w.substring(0, i+1);
                v = w.substring(i+1);

                if (validateCorrectBraces(u)) {
                    u += split(v);

                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("(");
                    sb.append(split(v));
                    sb.append(")");
                    sb.append(reverse(u));

                    return sb.toString();
                }

                break;
            }
        }

        return u;

    }

    public boolean validateCorrectBraces(String s) {
        if (s.charAt(0) == ')')
            return false;

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char brace = s.charAt(i);

            if (!stack.isEmpty() && brace == ')')
                stack.pop();
            else {
                stack.push(brace);
            }
        }

        return stack.isEmpty();

    }

    public String solution(String p) {
        if (p.length() == 0 || validateCorrectBraces(p))
            return p;

        return split(p);
    }

    @Test
    void test() {
        String answer1 = solution("(()())()");
        Assertions.assertThat(answer1).isEqualTo("(()())()");

        String answer2 = solution(")(");
        Assertions.assertThat(answer2).isEqualTo("()");

        String answer3 = solution("()))((()");
        Assertions.assertThat(answer3).isEqualTo("()(())()");

    }

    @Test
    void reverseTest() {
        String reverse = reverse("123");
        Assertions.assertThat(reverse).isEqualTo("2");

        String reverse2 = reverse("12");
        Assertions.assertThat(reverse2).isEqualTo("");

        String reverse3 = reverse("");
        Assertions.assertThat(reverse3).isEqualTo("");

    }

}

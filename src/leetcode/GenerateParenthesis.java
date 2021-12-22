package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class GenerateParenthesis {
    private List<String> list;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();

        dfs(n, n, "");
        return list;
    }

    private void dfs(int open, int close, String str) {
        if (open == 0 && close == 0) {
            list.add(str);
            return;
        }

        if (open > 0) {
            dfs(open - 1, close, str + "(");
        }

        if (close > open) {
            dfs(open, close - 1, str + ")");
        }

    }

    @Test
    void test() {
        Assertions.assertThat(generateParenthesis(3))
                .isEqualTo(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"));
    }
}

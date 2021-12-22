package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LetterCombinations {
    private static final Map<Character, String> map = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    private List<String> result;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();

        if ("".equals(digits))
            return result;

        char[] arr = new char[digits.length()];
        dfs(0, digits, arr);
        return result;

    }

    private void dfs(int depth, String digits, char[] arr) {
        if (depth == digits.length()) {
            result.add(new String(arr));
            return;
        }

        String str = map.get(digits.charAt(depth));
        for (int i = 0; i<str.length(); i++) {
            arr[depth] = str.charAt(i);
            dfs(depth+1, digits, arr);
        }

    }


    @Test
    void test() {
        Assertions.assertThat(letterCombinations("23"))
                .isEqualTo(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
    }

    @Test
    void test2() {
        Assertions.assertThat(letterCombinations("")).isEqualTo(new ArrayList<>());
    }

    @Test
    void test3() {
        Assertions.assertThat(letterCombinations("2")).isEqualTo(Arrays.asList("a", "b", "c"));
    }
}

package leetcode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthOfConcatencatedString {
    private int result = 0;

    public int maxLength(List<String> arr) {
        dfs(0, "", arr);
        return result;
    }

    private void dfs(int depth, String s, List<String> arr) {
        boolean isUniqueChar = isUniqueChars(s);

        if (isUniqueChar) {
            result = Math.max(s.length(), result);
        }

        if (arr.size() == depth || !isUniqueChar) {
            return;
        }

        for (int i=depth; i<arr.size(); i++) {
            dfs(i+1, s + arr.get(i), arr);
        }
    }

    private boolean isUniqueChars(String str) {
        Set<Character> charset = new HashSet<>();

        for (char c: str.toCharArray()) {
            if (charset.contains(c)) {
                return false;
            }

            charset.add(c);
        }

        return true;
    }

    @Test
    void test() {
        int answer = maxLength(Arrays.asList("un", "iq", "ue"));
        Assertions.assertThat(answer).isEqualTo(4);
    }

    @Test
    void test2() {
        int answer = maxLength(Arrays.asList("cha", "r", "act", "ers"));
        Assertions.assertThat(answer).isEqualTo(6);
    }

    @Test
    void test3() {
        int answer = maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz"));
        Assertions.assertThat(answer).isEqualTo(26);
    }

    @Test
    void test4() {
        int answer = maxLength(Arrays.asList("aa", "bb"));
        Assertions.assertThat(answer).isEqualTo(0);
    }

    @Test
    void test5() {
        int answer = maxLength(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"));
        Assertions.assertThat(answer).isEqualTo(16);
    }

}

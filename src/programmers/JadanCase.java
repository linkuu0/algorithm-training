package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class JadanCase {
    static public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] strings = s.toLowerCase().split("");
        boolean flag = true;

        for (String chr: strings) {
            sb.append(flag ? chr.toUpperCase() : chr);
            flag = " ".equals(chr);
        }

        return sb.toString();
    }

    @Test
    void test1() {
        String answer = solution("3people unFollowed me");
        Assertions.assertThat(answer).isEqualTo("3people Unfollowed Me");
    }

    @Test
    void test2() {
        String answer = solution("for the last week");
        Assertions.assertThat(answer).isEqualTo("For The Last Week");
    }
}

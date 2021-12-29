package programmers.dfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 단체사진 찍기
 * https://programmers.co.kr/learn/courses/30/lessons/1835
 */
public class GroupPicture {
    private static final String[] friends = new String[] {"A", "C", "F", "J", "M", "N", "R", "T"};
    private int count;

    public int solution(int n, String[] data) {
        boolean[] visited = new boolean[friends.length];
        this.count = 0;

        dfs("", visited, data);
        return this.count;
    }

    private void dfs(String formation, boolean[] visited, String[] data) {
        if (formation.length() == friends.length) {
            if (isValid(formation, data))
                this.count++;

            return;
        }

        for (int i=0; i<friends.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(formation + friends[i], visited, data);
                visited[i] = false;
            }
        }

    }

    private boolean isValid(String formation, String[] data) {
        for (String rule: data) {
            char op = rule.charAt(3);
            int actual = Math.abs(formation.indexOf(rule.charAt(0)) - formation.indexOf(rule.charAt(2)));
            int expected = rule.charAt(4) - '0' + 1;  // 예상 결과

            if (op == '=' && !(actual == expected)
                    || op == '>' && !(actual > expected)
                    || op == '<' && !(actual < expected))

                return false;

        }

        return true;
    }

    @Test
    void test() {
        int answer = solution(2, new String[]{"N~F=0", "R~T>2"});
        Assertions.assertThat(answer).isEqualTo(3648);
    }

    @Test
    void test2() {
        int answer = solution(2, new String[]{"M~C<2", "C~M>1"});
        Assertions.assertThat(answer).isEqualTo(0);
    }
}

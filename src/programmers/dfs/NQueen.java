package programmers.dfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [프로그래머스] Lv.3 N-Queen
 * https://programmers.co.kr/learn/courses/30/lessons/12952
 */
public class NQueen {
    private int n;
    private int answer = 0;
    private int[] col;

    public boolean check(int row) {
        for (int i=0; i<row; i++) {
            if (this.col[i] == this.col[row])
                return false;

            if (Math.abs(i - row) == Math.abs(this.col[i] - this.col[row]))
                return false;
        }

        return true;
    }

    public void dfs(int level) {
        if (level == this.n) {
            answer++;

        } else {
            for (int i=0; i<this.n; i++) {
                this.col[level] = i;

                if (check(level)) {
                    dfs(level+1);
                }
            }

        }
    }

    public int solution(int n) {
        this.n = n;

        for (int i=0; i<n; i++) {
            this.col = new int[n];

            this.col[0] = i;
            dfs(1);
        }

        return answer;
    }

    @Test
    void test() {
        int answer = solution(4);
        Assertions.assertThat(answer).isEqualTo(2);
    }
}

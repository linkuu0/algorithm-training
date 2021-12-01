package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NQueen {
    int n;
    int answer = 0;

    public boolean check(int row, int[] col) {
        for (int i=0; i<row; i++) {
            if (col[i] == col[row])
                return false;

            if (Math.abs(i - row) == Math.abs(col[i] - col[row]))
                return false;
        }

        return true;
    }

    public void dfs(int level, int[] col) {
        if (level == this.n) {
            answer++;

        } else {
            for (int i=0; i<this.n; i++) {
                col[level] = i;

                if (check(level, col)) {
                    dfs(level+1, col);
                }
            }

        }
    }

    public int solution(int n) {
        this.n = n;

        for (int i=0; i<n; i++) {
            int[] col = new int[n];

            col[0] = i;
            dfs(1, col);
        }

        return answer;
    }

    @Test
    void test() {
        int answer = solution(4);
        Assertions.assertThat(answer).isEqualTo(2);
    }
}

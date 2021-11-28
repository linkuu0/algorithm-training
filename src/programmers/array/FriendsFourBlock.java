package programmers.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [프로그래머스] Lv.2 프렌즈4블록
 * https://programmers.co.kr/learn/courses/30/lessons/17679
 */
public class FriendsFourBlock {
    private char[][] boards;

    private int removeChara() {
        int m = boards.length;
        int n = boards[0].length;
        int cnt = 0;

        boolean[][] removeBoard = new boolean[m][n];
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (boards[i][j] != '*') {
                    char curr = boards[i][j];
                    if (curr == boards[i][j + 1] && curr == boards[i + 1][j] && curr == boards[i + 1][j + 1]) {
                        removeBoard[i][j] = true;
                        removeBoard[i][j + 1] = true;
                        removeBoard[i + 1][j] = true;
                        removeBoard[i + 1][j + 1] = true;
                    }
                }
            }
        }

        // 지워야 하는 대상 카운트
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (removeBoard[i][j]) {
                    cnt++;
                    boards[i][j] = '*';
                }
            }
        }

        return cnt;
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        boards = new char[m][n];

        for (int i = 0; i < m; i++) {
            String row = board[i];
            for (int j = 0; j < n; j++) {
                boards[i][j] = row.charAt(j);
            }
        }

        while (true) {
            int remove = removeChara();

            if (remove == 0)
                break;

            answer += remove;
            rebase();

        }

        return answer;
    }

    private void rebase() {
        int m = boards.length;
        int n = boards[0].length;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (boards[i][j] == '*') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (boards[k][j] != '*') {
                            boards[i][j] = boards[k][j];
                            boards[k][j] = '*';
                            break;
                        }
                    }
                }
            }
        }
    }


    @Test
    void test() {
        int answer = solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
        Assertions.assertThat(answer).isEqualTo(14);

        int answer2 = solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"});
        Assertions.assertThat(answer2).isEqualTo(15);

    }

}

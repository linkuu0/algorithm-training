package programmers.dfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 카카오 프렌즈 컬러링북
 * https://programmers.co.kr/learn/courses/30/lessons/1829
 */
public class ColoringBook {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private int areaCount;
    private int maxSizeArea;
    private boolean[][] visited;
    private int size;

    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (picture[i][j] > 0 && !visited[i][j]) {
                    size = 1;// 색칠한 부분에 대해서만 탐색
                    dfs(i, j, picture);
                    areaCount++;
                    maxSizeArea = Math.max(maxSizeArea, size);
                }
            }
        }

        return new int[] {this.areaCount, this.maxSizeArea};
    }

    private void dfs(int m, int n, int[][] picture) {
        visited[m][n] = true;

        for (int i=0; i<4; i++) {
            int x = m + dx[i];
            int y = n + dy[i];

            if (x >= 0 && y >= 0 && x < picture.length && y < picture[0].length) {
                if (picture[x][y] == picture[m][n] && !visited[x][y]) {
                    dfs(x, y, picture);
                    visited[x][y] = true;
                    size++;
                }
            }
        }
    }

    @Test
    void test() {
        int[] answer = solution(6, 4, new int[][] {{1,1,1,0}, {1,2,2,0}, {1,0,0,1}, {0,0,0,1}, {0,0,0,3}, {0,0,0,3}});
        Assertions.assertThat(answer).isEqualTo(new int[]{4,5});
    }
}

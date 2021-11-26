package programmers.dynamic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * [프로그래머스] Lv.2 땅따먹기
 * @link https://programmers.co.kr/learn/courses/30/lessons/12913
 */
public class LandWar {
    static int solution(int[][] land) {

        for (int i=1; i<land.length; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1][3]));
            land[i][2] += Math.max(land[i-1][1], Math.max(land[i-1][0], land[i-1][3]));
            land[i][3] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1][0]));
        }

        return Arrays.stream(land[land.length - 1]).max().getAsInt();
    }

    @Test
    void test() {
        int answer = solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}});
        Assertions.assertThat(answer).isEqualTo(16);
    }
}

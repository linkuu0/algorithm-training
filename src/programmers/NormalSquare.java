package programmers;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * [프로그래머스] Lv.2 멀쩡한 사각형
 * https://programmers.co.kr/learn/courses/30/lessons/62048
 */
public class NormalSquare {

    public long solution(int w, int h) {
        long answer = 0;
        for (int i=0; i<w; i++) {
            answer += (long) h*i/w;
        }

        return answer * 2;
    }

    @Test
    void test() {
        long answer = solution(8, 12);
        Assertions.assertThat(answer).isEqualTo(80);
    }
}

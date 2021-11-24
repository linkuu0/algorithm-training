package lecture.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WeddingTest {

    @Test
    void test() {
        Wedding wedding = new Wedding();
        int answer = wedding.solution(new int[][] {{14,18},{12,15},{15,20},{20,30},{5,14}});

        Assertions.assertThat(answer).isEqualTo(2);
    }
}
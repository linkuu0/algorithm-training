package programmers.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarpetTest {

    @Test
    void test() {
        Carpet carpet = new Carpet();
        int[] answer = carpet.solution(24, 24);

        Assertions.assertThat(answer).isEqualTo(new int[]{8,6});
    }

}
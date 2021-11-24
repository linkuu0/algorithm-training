package programmers.search;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PreTestTest {
    @Test
    void test() {
        PreTest preTest = new PreTest();
        int[] answer = preTest.solution(new int[]{1, 2, 3, 4, 5});

        Assertions.assertThat(answer).isEqualTo(new int[]{1});
    }

}
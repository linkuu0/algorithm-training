package programmers.dfs;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TargetNumberTest {

    @Test
    void test() {
        TargetNumber test = new TargetNumber();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 5;

        int answer = test.solution(numbers, target);
        Assertions.assertThat(answer).isEqualTo(1);
    }

}
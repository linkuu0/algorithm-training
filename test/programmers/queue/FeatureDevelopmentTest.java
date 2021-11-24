package programmers.queue;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class FeatureDevelopmentTest {
    @Test
    void test() {
        FeatureDevelopment featureDevelopment = new FeatureDevelopment();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] expected = {2, 1};

        int[] answer1 = featureDevelopment.solution(progresses, speeds);
        Assertions.assertThat(answer1).isEqualTo(expected);

        int[] answer2 = featureDevelopment.solutionUsingQueue(progresses, speeds);
        Assertions.assertThat(answer2).isEqualTo(expected);

    }
}